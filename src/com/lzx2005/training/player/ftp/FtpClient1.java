package com.lzx2005.training.player.ftp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * Created by Lizhengxian on 2017/2/24.
 */
public class FtpClient1 {


    public static void main(String[] args) throws IOException {
        //Create a asyn channel
        final AsynchronousSocketChannel channel = AsynchronousSocketChannel.open();

        channel.connect(new InetSocketAddress("ftp.gnu.org", 21), channel, new CompletionHandler<Void, AsynchronousSocketChannel>() {
            @Override
            public void completed(Void result, AsynchronousSocketChannel attachment) {
                //callback for completed
                FtpClient1 client = new FtpClient1();
                client.start(channel);
            }

            @Override
            public void failed(Throwable exc, AsynchronousSocketChannel attachment) {
                //callback for failed
                exc.printStackTrace();
            }
        });

        //stop JVM quit
        System.in.read();

    }

    AsynchronousSocketChannel channel;

    public void start(AsynchronousSocketChannel channel){
        this.channel = channel;
        //ready to read buffer
        ByteBuffer buffer = ByteBuffer.allocateDirect(128);
        //send read request
        channel.read(buffer, buffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                if(result>0){
                    //读到信息了，简单处理
                    int position = attachment.position() - 1;
                    if(attachment.get(position-1)==13 && attachment.get(position) == 10){
                        if(isValidReply(attachment)){
                            attachment.flip();
                            showReply(attachment);
                            if(getReplyCode(attachment)==220){
                                login();
                            }
                        }
                    }else{
                        FtpClient1.this.channel.read(attachment,attachment,this);
                    }
                }else{
                    System.out.println("remote server closed");
                }
            }



            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                exc.printStackTrace();
            }
        });
    }

    private void login() {
        String user = "user anonymous\r\n";
        ByteBuffer buffer = ByteBuffer.wrap(user.getBytes());
        channel.write(buffer, buffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                if(attachment.hasRemaining()){
                    System.out.println("send login request");
                    channel.write(attachment,attachment,this);
                }else {
                    System.out.println("something wrong with login");
                    //todo 此处有问题
                }
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                exc.printStackTrace();
            }
        });
    }

    private int getReplyCode(ByteBuffer attachment) {
        return Character.digit(attachment.get(0),10)*100
                +Character.digit(attachment.get(1),10)*10
                +Character.digit(attachment.get(2),10);
    }

    private void showReply(ByteBuffer attachment) {
        while (attachment.hasRemaining()){
            System.out.print((char)attachment.get());
        }
    }

    private boolean isValidReply(ByteBuffer attachment) {
        return attachment.get(3)==32
                && Character.isDigit(attachment.get(0))
                && Character.isDigit(attachment.get(1))
                && Character.isDigit(attachment.get(2));
    }

}
