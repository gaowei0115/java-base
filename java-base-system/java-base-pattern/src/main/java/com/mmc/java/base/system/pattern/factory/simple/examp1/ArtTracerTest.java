// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.java.base.system.pattern.factory.simple.examp1;

/** 
 * ClassName: ArtTracerTest<br/>
 * Description: <br/>
 * Author: GW<br/>
 * Create： 2017年9月2日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class ArtTracerTest {

	public static void main(String[] args) throws BadShapeException {
		Graph graph = ArtTracer.getInstance("square1");
		graph.draw();
		graph.erase();
	}
}
