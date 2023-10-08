package com.it.sim.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPReceiver {
	public static void main(String[] args) throws IOException {
		
		//1、指定9999端口，准备接收数据包
		DatagramSocket socket = new DatagramSocket(9999);
		
		//2、开始接收数据包
		byte[ ] buf = new byte[1024];
		DatagramPacket packet = new DatagramPacket(buf, buf.length);
		socket.receive(packet);
		
		//3、拆包
		int length = packet.getLength();
		byte[ ] data = packet.getData();
		String s = new String(data, 0, length);
		System.out.println(s);
		
		//4、封装包
		byte[ ] data1 = "好的，明天见".getBytes();
		DatagramPacket packet1 = new DatagramPacket(data1, data1.length, InetAddress.getByName("10.212.130.221"), 9998);
		socket.send(packet1);
		
		//4、关闭资源
		socket.close();
		System.out.println("B端结束！！！");
	}
}
