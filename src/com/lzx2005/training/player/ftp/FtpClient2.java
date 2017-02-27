package com.lzx2005.training.player.ftp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * Created by Lizhengxian on 2017/2/24.
 */
public class FtpClient2 {

    public static void main(String[] args) throws IOException {
        AsynchronousSocketChannel channel = AsynchronousSocketChannel.open();
        channel.connect(new InetSocketAddress("ftp.gnu.org", 21), channel, new CompletionHandler<Void, AsynchronousSocketChannel>() {
            @Override
            public void completed(Void result, AsynchronousSocketChannel attachment) {
                FtpClient2 client = new FtpClient2();
                client.start(attachment);
            }

            @Override
            public void failed(Throwable exc, AsynchronousSocketChannel attachment) {

            }
        });
        System.in.read();
    }

    AsynchronousSocketChannel channel;

    private void start(AsynchronousSocketChannel channel) {
        this.channel = channel;
        readResponse();
    }

    private void readResponse() {
        ByteBuffer buffer = ByteBuffer.allocateDirect(128);
        read(buffer);
    }

    private void read(ByteBuffer buffer) {
        channel.read(buffer,buffer,reader);
    }


    private CompletionHandler<Integer,? super ByteBuffer> reader = new CompletionHandler<Integer, ByteBuffer>() {
        @Override
        public void completed(Integer result, ByteBuffer attachment) {
            if(result>0){
                int position = attachment.position() - 1;
                if(attachment.get(position-1)==13 && attachment.get(position) == 10){//判断是否为"\r\n"
                    if(isValidReply(attachment,0)){
                        attachment.flip();
                        showReply(attachment);
                        onReply(getReplyCode(attachment,0));
                    }else {
                        removeLine(attachment,position-2);
                        if(isValidReply(attachment,0)){
                            attachment.flip();
                            showReply(attachment);
                            onReply(getReplyCode(attachment,0));
                        }else {
                            read(attachment);
                        }
                    }
                }else {
                    if(!attachment.hasRemaining()){
                        removeLine(attachment,position-1);
                    }
                    read(attachment);
                }
            }else {
                System.out.println("remote server closed");
            }
        }

        @Override
        public void failed(Throwable exc, ByteBuffer attachment) {
            exc.printStackTrace();
        }
    };




    private void removeLine(ByteBuffer attachment, int position) {
        int limit = attachment.position();
        byte c;
        while (position>=0){
            c = attachment.get(position);
            if(c==13||c==10){
                showReply(attachment,position);
                attachment.position(position+1);
                attachment.limit(limit);
                attachment.compact();
                break;
            }
            position--;
        }
    }


    private void onReply(int replyCode) {
        if(replyCode == 220){
            login();
        }
        if(replyCode == 230){
            writeCommand("size README");
        }else if(replyCode == 213){
            writeCommand("QUIT");
        }else if(replyCode == 221){
            try {
                channel.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void writeCommand(String str) {
        System.out.print("==>");
        System.out.println(str);
        ByteBuffer buffer = ByteBuffer.wrap((str+"\r\n").getBytes());
        write(buffer);
    }

    private void write(ByteBuffer buffer) {
        channel.write(buffer,buffer,writer);
    }



    private CompletionHandler<Integer,? super ByteBuffer> writer = new CompletionHandler<Integer, ByteBuffer>() {
        @Override
        public void completed(Integer result, ByteBuffer attachment) {
            if(attachment.hasRemaining()){
                channel.write(attachment,attachment,this);
            }else {
                readResponse();
            }
        }

        @Override
        public void failed(Throwable exc, ByteBuffer attachment) {
            exc.printStackTrace();
        }
    };

    private void login() {
        String user  = "user anonymous";
        writeCommand(user);
    }

    private int getReplyCode(ByteBuffer attachment, int start) {
        return Character.digit(attachment.get(start),10)*100
                +Character.digit(attachment.get(start+1),10)*10
                +Character.digit(attachment.get(start+2),10);
    }

    private void showReply(ByteBuffer attachment) {
        while (attachment.hasRemaining()){
            System.out.print((char)attachment.get());
        }
    }

    private void showReply(ByteBuffer attachment, int position) {
        for(int i=0;i<position;i++){
            System.out.print((char)attachment.get(i));
        }
    }

    private boolean isValidReply(ByteBuffer attachment, int start) {
        return attachment.get(3)==32
                && Character.isDigit(attachment.get(start))
                && Character.isDigit(attachment.get(start+1))
                && Character.isDigit(attachment.get(start+2));
    }

}
