package com.it.sim.net.t2;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 客户端
 *
 * @author John
 */
@Slf4j
public class BioLineClient2 {
	public static void main(String[] args) throws IOException {

		//1、连接服务端，连上则返回Socket对象
		Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

		//2、IO写出
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		bufferedWriter.write("hello，server");
		bufferedWriter.newLine();    //插入一个换行符，表示写入内容结束，注意：要求对方使用readLine();
		bufferedWriter.flush();    //如果使用的字符流，需要手动刷新，否则数据不会写入数据通道
		
		//3、IO读取
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String s = bufferedReader.readLine();
		System.out.println(s);
		
		//4、关闭资源
		bufferedWriter.close();
		bufferedReader.close();
		socket.close();
		log.info("客户端退出！！！" );
	}
}
