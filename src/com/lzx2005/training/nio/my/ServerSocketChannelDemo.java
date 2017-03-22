package com.lzx2005.training.nio.my;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * Created by Lizhengxian on 2017/3/22.
 */
public class ServerSocketChannelDemo {


    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(9998));
        boolean serverOpen =true;
        System.out.println("服务器启动...监听端口[9998]...");
        while (serverOpen){
            SocketChannel socketChannel = serverSocketChannel.accept();
            if(socketChannel!=null){
                StringBuilder sb = new StringBuilder();
                System.out.println("接收到数据...");
                ByteBuffer byteBuffer = ByteBuffer.allocate(24);
                Charset charset = Charset.forName("utf-8");
                CharsetDecoder charsetDecoder = charset.newDecoder();
                while (socketChannel.read(byteBuffer)!=-1){
                    byteBuffer.flip();
                    CharBuffer charBuffer = charsetDecoder.decode(byteBuffer);
                    while (charBuffer.hasRemaining()){
                        sb.append(charBuffer.get());
                    }
                    byteBuffer.clear();
                }
                if(sb.toString().equals("exit()")){
                    serverOpen = false;
                }
                System.out.println(sb.toString());
            }
        }
    }
}
