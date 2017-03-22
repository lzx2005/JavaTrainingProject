package com.lzx2005.training.nio.my;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Set;

/**
 * Created by Lizhengxian on 2017/3/22.
 */
public class SocketChannelDemo {

    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("localhost", 9998));
        ByteBuffer buffer = ByteBuffer.allocate(48);
        String str = "exit()";
        StringBuilder sb = new StringBuilder(str);
        while (sb.length()>0){
            String subString;
            if(buffer.capacity()>sb.length()){
                subString = sb.substring(0, sb.length());
                sb.delete(0,sb.length());
            }else{
                subString = sb.substring(0, buffer.capacity());
                sb.delete(0,buffer.capacity());
            }
            System.out.println(subString);

            buffer.clear();
            buffer.put(subString.getBytes("UTF-8"));
            buffer.flip();
            while (buffer.hasRemaining()){
                socketChannel.write(buffer);
            }
        }
    }
}
