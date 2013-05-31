package com.toastedbits.jettest.server;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import org.eclipse.jetty.server.Server;

public class SpringLauncher {
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("serverContext.xml");
		Server server = ctx.getBean("server", Server.class);
		server.start();
		server.join();
	}
}
