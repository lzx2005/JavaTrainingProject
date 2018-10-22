package com.lzx2005.training.socket;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        socket.setSoTimeout(3000);
        SocketAddress socketAddress = new InetSocketAddress(Inet4Address.getLocalHost(), 2000);
        socket.connect(socketAddress);

        System.out.println("连接成功！");
        System.out.printf("客户端信息[%s:%s]\n", socket.getLocalAddress(), socket.getLocalPort());
        System.out.printf("服务端信息[%s:%s]\n", socket.getInetAddress(), socket.getPort());

        try {
            todo(socket);
        } catch (Exception e) {
            System.out.println("连接出错");
        }
        socket.close();

    }


    private static void todo(Socket socket) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        PrintStream printStream = new PrintStream(socket.getOutputStream());

        BufferedReader inputReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        boolean flag = true;
        do {
            String str = reader.readLine();
            if ("quit".equalsIgnoreCase(str)) {
                flag = false;
            }
            printStream.println(str);
            String echo = inputReader.readLine();
            System.out.println(echo);
        } while (flag);

        reader.close();
        printStream.close();
        inputReader.close();
    }
}
