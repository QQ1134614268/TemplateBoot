package com.it.sim.socket;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Nio2LineClient {
    public static void main(String[] args) {
        Socket socket;
        Scanner scanner = new Scanner(System.in);
        try {
            socket = new Socket("127.0.0.1", 8899);
            PrintStream printStream = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("请输入:");
            String nextLine = scanner.nextLine();
            printStream.println(nextLine);
            printStream.flush();

            // 读取服务器返回的数据
            String line = bufferedReader.readLine();
            System.out.println(line);
            printStream.close();
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

