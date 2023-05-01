package com.neiman.Example;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("applicationContext.xml");
		
		TV tv = ctx.getBean(TV.class);
		tv.turnOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.turnOff();
	}

}
