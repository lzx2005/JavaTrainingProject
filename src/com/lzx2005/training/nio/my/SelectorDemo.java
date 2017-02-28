package com.lzx2005.training.nio.my;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Lizhengxian on 2017/2/27.
 */
public class SelectorDemo {
    public static void main(String[] args) throws IOException {
        SelectorDemo.testSelector();
    }

    public static void testSelector() throws IOException {
        Selector selector = Selector.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress("www.lzx2005.com",80);
        SocketChannel socketChannel = SocketChannel.open(inetSocketAddress);
        socketChannel.configureBlocking(false);
        SelectionKey key = socketChannel.register(selector, SelectionKey.OP_CONNECT);

        int select = selector.select();
        System.out.println(select);
        Set<SelectionKey> selectionKeys = selector.selectedKeys();

        Iterator<SelectionKey> iterator = selectionKeys.iterator();

        while (iterator.hasNext()){
            SelectionKey next = iterator.next();
            System.out.println(next);
        }
    }
}
