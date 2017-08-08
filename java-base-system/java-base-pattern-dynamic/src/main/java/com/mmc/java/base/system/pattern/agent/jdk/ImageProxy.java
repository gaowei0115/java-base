// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.java.base.system.pattern.agent.jdk;

import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/** 
 * className: ImageProxy<br/>
 * Description: 代理ImageIcon类实现<br/>
 * Author: GW<br/>
 * CreateTime： 2017年8月8日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class ImageProxy implements Icon {

	private ImageIcon imageIcon;
	private boolean retrieving = false;
	private Thread retrieveThread;
	private String imageUrl;
	
	/**
	 * @param imageUrl
	 */
	public ImageProxy(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.Icon#paintIcon(java.awt.Component, java.awt.Graphics, int, int)
	 */
	public void paintIcon(final Component c, Graphics g, int x, int y) {
		if (imageIcon != null) {
			imageIcon.paintIcon(c, g, x, y);
		} else {
			g.drawString("loading icon, please waiting...", x + 300, y + 400);
			if (!retrieving) {
				retrieving = true;
				retrieveThread = new Thread(new Runnable() {
					
					public void run() {
						try {
							imageIcon = new ImageIcon(imageUrl, " icon ");
							c.repaint();
						} catch (Exception e) {
							
						}
					}
				});
				retrieveThread.start();
			}
		}
	}

	/* (non-Javadoc)
	 * @see javax.swing.Icon#getIconWidth()
	 */
	public int getIconWidth() {
		if (imageIcon != null) {
			return imageIcon.getIconWidth();
		} else {
			return 600;
		}
	}

	/* (non-Javadoc)
	 * @see javax.swing.Icon#getIconHeight()
	 */
	public int getIconHeight() {
		if (imageIcon != null) {
			return imageIcon.getIconHeight();
		} else {
			return 800;
		}
	}

}
