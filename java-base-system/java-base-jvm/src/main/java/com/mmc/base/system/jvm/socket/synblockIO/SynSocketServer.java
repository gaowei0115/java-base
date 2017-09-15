// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.base.system.jvm.socket.synblockIO;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

/** 
 * className: SynSocketServer<br/>
 * Description: 模拟同步阻塞IO模式<br/>
 * Author: GW<br/>
 * CreateTime： 2017年9月15日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class SynSocketServer {

	private final int port;
	private final String host;
	
	/**
	 * @param port
	 * @param host
	 */
	public SynSocketServer(int port, String host) {
		this.port = port;
		this.host = host;
	}
	
	/**
	 * Description：初始化服务<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 */
	public void init() {
		System.out.println("start server.....");
		ServerSocket ss;
		try {
			ss = new ServerSocket();
			SocketAddress address = new InetSocketAddress(host, port);
			ss.bind(address);
			ss.setReceiveBufferSize(1024);
			while (true) {
				Socket socket = ss.accept();
				InputStream is = socket.getInputStream();
				byte[] buffer = new byte[2048];
				while ((is.read()) != -1) {
					is.read(buffer);
					System.out.println(new String(buffer));
				}
//				is.close();
//				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		SynSocketServer socketServer = new SynSocketServer(8888, "10.0.20.78");
		socketServer.init();
	}
}
