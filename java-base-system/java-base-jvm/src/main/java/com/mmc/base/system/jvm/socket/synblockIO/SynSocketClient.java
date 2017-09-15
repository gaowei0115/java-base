// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.base.system.jvm.socket.synblockIO;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/** 
 * className: SynSocketClient<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年9月15日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class SynSocketClient {

	private final int port;
	private final String host;
	
	public SynSocketClient(int port, String host) {
		this.port = port;
		this.host = host;
	}
	
	/**
	 * Description：发送数据<br/>
	 * Author：GW<br/>
	 * History: (version) Author DateTime Note <br/>
	 * @param message
	 */
	public void send(String message) {
		try {
			Socket socket = new Socket(host, port);
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			pw.print(message);
			pw.flush();
			pw.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		SynSocketClient client = new SynSocketClient(8888, "10.0.20.78");
		client.send("hello server");
	}
}
