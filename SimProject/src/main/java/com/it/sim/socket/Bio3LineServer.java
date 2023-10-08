package com.it.sim.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 服务器端
 * @author John
 */
public class Bio3LineServer {
	public static void main(String[] args) throws IOException {
		
		//1、在本机的9999端口监听，等待连接。。。
		ServerSocket serverSocket = new ServerSocket(9999);
		Socket socket = serverSocket.accept();
		
		//2、IO读取
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String s = bufferedReader.readLine();
		System.out.println(s);
		
		//3、IO写出
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		bufferedWriter.write("hello, client");
		bufferedWriter.newLine();
		bufferedWriter.flush();
		
		//4、关闭资源
		bufferedWriter.close();
		bufferedReader.close();
		socket.close();
		serverSocket.close();

		System.out.println("服务端退出！！！");
	}
}
