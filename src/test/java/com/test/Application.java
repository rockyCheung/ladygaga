package com.test;

/**
 * Created by zhangpenghong on 2019/6/11.
 */
public class Application {
public static void main(String[] start) {
	Application aa = new Application();
	aa.agentHello( "Agent" );
}

public String agentHello(String name) {
	return "Hello," + name;
}
}
