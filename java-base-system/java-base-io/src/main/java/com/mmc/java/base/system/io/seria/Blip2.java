// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.io.seria;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/** 
 * ClassName: Blip2<br/>
 * Description: <br/>
 * Author: GW<br/>
 * Create： 2017年8月19日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class Blip2 implements Externalizable {

	Blip2() {
		System.out.println("Blip2 Constructor");
	}
	
	/* (non-Javadoc)
	 * @see java.io.Externalizable#writeExternal(java.io.ObjectOutput)
	 */
	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("Blip2 writeExternal");
	}

	/* (non-Javadoc)
	 * @see java.io.Externalizable#readExternal(java.io.ObjectInput)
	 */
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		System.out.println("Blip2 readExternal");
	}

}
