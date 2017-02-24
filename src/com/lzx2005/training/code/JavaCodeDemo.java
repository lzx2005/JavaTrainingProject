package com.lzx2005.training.code;

import java.io.*;

/**
 * Created by Lizhengxian on 2017/2/23.
 * Java编码练习
 */

public class JavaCodeDemo {
    public static void codeDemo1() throws IOException {
        String file = "/Users/john/Documents/test.conf";
        String charset = "UTF-8";

        //往文件里写中文字，以UTF-8编码
        FileOutputStream outputStream = new FileOutputStream(file);
        OutputStreamWriter writer = new OutputStreamWriter(outputStream,charset);
        writer.write("这是要写的中文字");
        writer.close();

        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader reader = new InputStreamReader(fileInputStream,charset);

        StringBuffer sb = new StringBuffer();
        char[] chars = new char[24];
        int count = 0;
        while ((count = reader.read(chars))!=-1){
            sb.append(chars,0,count);
        }
        reader.close();

        System.out.println(sb.toString());

    }

    public static void main(String[] args) throws IOException {
        codeDemo1();
    }
}
