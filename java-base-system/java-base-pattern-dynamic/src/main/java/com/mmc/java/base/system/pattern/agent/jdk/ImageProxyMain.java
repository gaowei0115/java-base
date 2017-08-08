// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.pattern.agent.jdk;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;

/** 
 * className: ImageProxyMain<br/>
 * Description: <br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月8日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class ImageProxyMain {

	
	public static void main(String[] args) {
		String imageUrl = "https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2720591281,1790277670&fm=173&s=009A743259AFC0CC527D28D70100C0B2&w=413&h=392&img.JPEG";
		JFrame frame = new JFrame("testing....");
		Icon image = new ImageProxy(imageUrl);
		JButton jButton = new JButton("");
		jButton.setIcon(image);
		frame.getContentPane().add(jButton);  
		frame.setVisible(true);  
	}
}
