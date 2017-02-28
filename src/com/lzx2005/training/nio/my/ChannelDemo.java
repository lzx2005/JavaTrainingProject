package com.lzx2005.training.nio.my;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Lizhengxian on 2017/2/21.
 */
public class ChannelDemo {
    public static void main(String[] args) throws IOException {
        //新建一个RandomAccessFile
        RandomAccessFile randomAccessFile = new RandomAccessFile("/Users/john/Documents/test.conf", "rw");
        //从randomAccessFile中获得Channel
        FileChannel channel = randomAccessFile.getChannel();

        //使用Buffer申请字节空间
        ByteBuffer buf = ByteBuffer.allocate(32);
        while (channel.read(buf)!=-1){
            //将Buffer切换到读模式
            buf.flip();
            while (buf.hasRemaining()){
                System.out.print((char)buf.get());
            }
            //清空数据
            buf.clear();
        }
    }
}