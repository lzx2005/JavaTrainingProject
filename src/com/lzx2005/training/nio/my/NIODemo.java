package com.lzx2005.training.nio.my;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * Created by Lizhengxian on 2017/2/27.
 */
public class NIODemo {
    public static void main(String[] args) throws IOException {
        NIODemo.testDemo1();

    }

    public static void testDemo1() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("/Users/john/Documents/test.conf","rw");

        FileChannel channel = randomAccessFile.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(12);


        //编码
        Charset charset = Charset.forName("UTF-8");
        CharsetDecoder charsetDecoder = charset.newDecoder();
        while (channel.read(buffer)!=-1){
            buffer.flip();
            CharBuffer charBuffer = charsetDecoder.decode(buffer);
            while (charBuffer.hasRemaining()){
                System.out.print(charBuffer.get());
            }
            buffer.clear();
        }
        channel.close();
        randomAccessFile.close();
    }
}
