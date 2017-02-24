package com.lzx2005.training.player.ftp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * Created by Lizhengxian on 2017/2/24.
 */
public class FtpClient3 {
    public static void main(String[] args) throws IOException {
        AsynchronousSocketChannel channel = AsynchronousSocketChannel.open();
        channel.connect(new InetSocketAddress("ftp.gnu.org", 21), channel,
                new CompletionHandler<Void, AsynchronousSocketChannel>() {
                    @Override
                    public void completed(Void result,
                                          AsynchronousSocketChannel attachment) {
                        FtpClient3 client = new FtpClient3();
                        client.start(attachment);
                    }

                    @Override
                    public void failed(Throwable exc,
                                       AsynchronousSocketChannel attachment) {
                        exc.printStackTrace();
                    }
                });
        System.in.read();
    }

    AsynchronousSocketChannel channel;

    void readResponse() {
        ByteBuffer buffer = ByteBuffer.allocateDirect(128);
        read(buffer);
    }

    void read(ByteBuffer buffer) {
        channel.read(buffer, buffer, reader);
    }
    // 使用内部类接收读操作完成通知
    CompletionHandler<Integer, ByteBuffer> reader =
            new CompletionHandler<Integer, ByteBuffer>() {
                @Override
                public void completed(Integer result, ByteBuffer attachment) {
                    if (result > 0) {
                        int position = attachment.position() - 1;
                        if (attachment.get(position - 1) == 13 &&
                                attachment.get(position) == 10) {
                            if (isValidReply(attachment, 0)) {
                                attachment.flip();
                                showReply(attachment);
                                // 状态逻辑，处理响应
                                onReply(getReplyCode(attachment, 0));
                            } else {
                                removeLine(attachment, position - 2);
                                if (isValidReply(attachment, 0)) {
                                    attachment.flip();
                                    showReply(attachment);
                                    onReply(getReplyCode(attachment, 0));
                                } else
                                    read(attachment);
                            }
                        } else {
                            if (!attachment.hasRemaining())
                                removeLine(attachment, position - 1);
                            read(attachment);
                        }
                    } else {
                        System.out.println("remote server closed");
                    }
                }
                @Override
                public void failed(Throwable exc, ByteBuffer attachment) {
                    exc.printStackTrace();
                }
            };

    public void start(AsynchronousSocketChannel channel) {
        this.channel = channel;
        readResponse();
    }

    protected void onReply(int replyCode) {
        // 按照前面定义好的步骤，处理状态逻辑
        if (replyCode == 220)
            login();
        if (replyCode == 230)
            writeCommand("size README");
        else if (replyCode == 213)
            writeCommand("QUIT");
        else if (replyCode == 221)
            try {
                channel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    void writeCommand(String string) {
        System.out.print("==>");
        System.out.println(string);
        ByteBuffer buffer = ByteBuffer.wrap((string + "\r\n").getBytes());
        write(buffer);
    }

    void write(ByteBuffer buffer) {
        channel.write(buffer, buffer, writer);
    }
    // 使用内部类接收写操作完成通知
    CompletionHandler<Integer, ByteBuffer> writer =
            new CompletionHandler<Integer, ByteBuffer>() {
                @Override
                public void completed(Integer result, ByteBuffer attachment) {
                    if (attachment.hasRemaining())
                        channel.write(attachment, attachment, this);
                    else
                        readResponse();
                }
                @Override
                public void failed(Throwable exc, ByteBuffer attachment) {
                    exc.printStackTrace();
                }
            };

    protected void login() {
        String user = "user anonymous";
        writeCommand(user);
    }

    // 处理多行响应
    protected void removeLine(ByteBuffer buffer, int position) {
        int limit = buffer.position();
        byte c;
        while (position >= 0) {
            c = buffer.get(position);
            if (c == 13 || c == 10) {
                showReply(buffer, position);
                buffer.position(position + 1);
                buffer.limit(limit);
                buffer.compact();
                break;
            }
            position--;
        }
    }
    // 针对多数 FTP 服务器的响应的偷懒的方法，不用费劲处理 String。
    protected void showReply(ByteBuffer buffer) {
        while (buffer.hasRemaining())
            System.out.print((char) buffer.get());
    }

    protected void showReply(ByteBuffer buffer, int position) {
        for (int i = 0; i < position; i++)
            System.out.print((char) buffer.get(i));
    }

    public static int getReplyCode(ByteBuffer buffer, int start) {
        return Character.digit(buffer.get(start), 10) * 100 +
                Character.digit(buffer.get(start + 1), 10) * 10
                + Character.digit(buffer.get(start + 2), 10);
    }

    public static boolean isValidReply(ByteBuffer buffer, int start) {
        return buffer.get(start + 3) == 32 &&
                Character.isDigit(buffer.get(start))
                && Character.isDigit(buffer.get(start + 1))
                && Character.isDigit(buffer.get(start + 2));
    }

}
