package com.it.sim.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSend {
	public static void main(String[] args) throws IOException {
		
		//1、在9998端口接收数据
		DatagramSocket socket = new DatagramSocket(9998);
		
		//2、封装包
		byte[ ] data = "hello，明天吃火锅".getBytes();
		DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getByName("10.212.130.221"), 9999);
		socket.send(packet);
		
		//3、接收数据包
		byte[ ] buf = new byte[1024];
		DatagramPacket packet1 = new DatagramPacket(buf, buf.length);
		socket.receive(packet1);
		
		//3、拆包
		int length = packet1.getLength();
		byte[ ] data1 = packet1.getData();
		String s = new String(data1, 0, length);
		System.out.println(s);
		
		//3、关闭资源
		socket.close();
		System.out.println("A端结束！！！");
	}
}
