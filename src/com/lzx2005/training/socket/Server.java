package com.lzx2005.training.socket;

import com.mysql.cj.core.util.StringUtils;

import java.io.*;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(2000, 1, Inet4Address.getLocalHost());
        System.out.println("开始监听...");
        for (; ; ) {
            Socket accept = serverSocket.accept();
            SocketHandler socketHandler = new SocketHandler(accept);
            socketHandler.start();
        }

    }


    static class SocketHandler extends Thread {
        Socket socket;
        boolean flag = true;

        SocketHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            super.run();
            System.out.println("连接成功");
            System.out.printf("客户端信息[%s:%s]\n", socket.getInetAddress(), socket.getPort());


            try {

                PrintStream printStream = new PrintStream(socket.getOutputStream());
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                do {
                    String str = bufferedReader.readLine();
                    if (null != str && !"".equalsIgnoreCase(str)) {
                        if ("quit".equalsIgnoreCase(str)) {
                            flag = false;
                            printStream.println("bye");
                            System.out.printf("客户端断开连接：[%s:%s]\n", socket.getInetAddress(), socket.getPort());
                        } else {
                            System.out.println("接收到数据：" + str);
                            printStream.println("数据长度：" + str.length());
                        }
                    }else {
                        System.out.println("接收到数据：" + str);
                        printStream.println("数据长度：" + 0);
                    }
                } while (flag);
                bufferedReader.close();
                printStream.close();
                socket.close();
            } catch (IOException e) {
                System.out.println("接收数据出错");
            }
        }
    }
}
