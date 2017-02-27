package com.lzx2005.training.io;

import java.io.*;

/**
 * Created by Lizhengxian on 2017/2/27.
 */
public class TestIO {
    public static void main(String[] args) {
        File file = new File("/Users/john/Documents/test.conf");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader reader = new InputStreamReader(fileInputStream);
            char[] bytes = new char[1024];
            int count;
            while ((count =reader.read(bytes,0,bytes.length))!=-1){
                System.out.println(String.valueOf(bytes,0,count));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
