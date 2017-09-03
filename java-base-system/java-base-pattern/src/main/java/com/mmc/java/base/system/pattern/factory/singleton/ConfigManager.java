// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.pattern.factory.singleton;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicLong;


/** 
 * ClassName: ConfigManager<br/>
 * Description: 属性文件管理单例模式实现<br/>
 * Author: GW<br/>
 * Create： 2017年9月3日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class ConfigManager {

	private static final String PFILE = System.getProperty("user.dir") + File.separator + "singleton.properties";
	
	private final File m_file;
	
	private final AtomicLong last_modify_time;
	
	private final Properties properties;
	
	private static ConfigManager instance = new ConfigManager();
	
	/**
	 * Construtor()
	 * ConfigManager.java
	 */
	private ConfigManager() {
		this.m_file = new File(PFILE);
		last_modify_time = new AtomicLong();
		last_modify_time.set(m_file.lastModified());
		if (last_modify_time.get() == 0) {
			System.err.println("properties " + PFILE + " file is not exist");
		} 
		properties = new Properties();
		try {
			properties.load(new FileInputStream(m_file));
		} catch (Exception e) {
			System.err.println("load " + PFILE + " properties error");
		}
	}
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @return
	 */
	public static ConfigManager getInstance() {
		return instance;
	}
	
	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @param key
	 * @param defaultItem
	 * @return
	 */
	public final Object getConfigItem(String key, Object defaultItem) {
		long newTime = m_file.lastModified();
		if (newTime == 0) {
			// 属性文件是否存在
			if (last_modify_time.get() == 0) {
				System.err.println("properties " + PFILE + " file is not exist");
			} else {
				System.err.println("properties " + PFILE + " file is delete");
			}
			return defaultItem;
		} else {
			// 属性文件存在
			if (newTime > last_modify_time.get()) {
				// 属性文件被修改过
				properties.clear();
				try {
					properties.load(new FileInputStream(m_file));
				} catch(Exception e) {
					System.err.println("reload " + PFILE + " properties error");
					e.printStackTrace();
				}
			}
			
			last_modify_time.set(newTime);
			Object val = properties.get(key);
			if (val == null) {
				return defaultItem;
			}
			return val;
		}
	}
	
}
