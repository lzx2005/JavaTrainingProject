package com.lzx2005.training.nio.my;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Lizhengxian on 2017/3/22.
 */
public class SelectorDemo1 {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.socket().bind(new InetSocketAddress(9999));

        Selector selector = Selector.open();
        channel.configureBlocking(false);
        channel.register(selector, SelectionKey.OP_ACCEPT);
        while(true) {
            int readyChannels = selector.select();
            if(readyChannels == 0) continue;
            Set selectedKeys = selector.selectedKeys();
            Iterator keyIterator = selectedKeys.iterator();
            while(keyIterator.hasNext()) {
                SelectionKey key = (SelectionKey) keyIterator.next();
                if(key.isAcceptable()) {
                    System.out.println("建立连接");
                    ServerSocketChannel channel1 = (ServerSocketChannel)key.channel();
                    SocketChannel accept = channel1.accept();
                    System.out.println("获取到SocketChannel管道:"+accept.toString());
                    ByteBuffer buffer = ByteBuffer.allocate(128);
                    while(accept.read(buffer)!=-1){
                        buffer.flip();
                        while (buffer.hasRemaining()){
                            System.out.print((char)buffer.get());
                        }
                        buffer.clear();
                    }
                    System.out.println();
                    System.out.println("接收消息完成");
                } else if (key.isConnectable()) {
                    // a connection was established with a remote server.
                    System.out.println(2);
                } else if (key.isReadable()) {
                    // a channel is ready for reading
                    System.out.println(3);
                } else if (key.isWritable()) {
                    // a channel is ready for writing
                    System.out.println(4);
                }
                keyIterator.remove();
            }
        }
    }
}
