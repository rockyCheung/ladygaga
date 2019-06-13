package com.gwill.agent;

import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperCall;

import java.util.concurrent.Callable;

/**
 * Created by zhangpenghong on 2019/6/12.
 */
public class LaddyGGMethodAdviceInterceptor {

@RuntimeType
public static String intercept(@SuperCall Callable<String> zuper) throws Throwable {
	long startTime = System.currentTimeMillis();
	System.out.println( String.format( "the classs %s,start time %d", zuper.getClass().getName(), startTime ) );
	String ret = null;
	try {
		ret = zuper.call();
		System.out.println( "@@@@" + ret );
	} catch (Throwable t) {
		throw t;
	} finally {
		long spendTime = System.currentTimeMillis() - startTime;
		System.out.println( String.format( "the classs %s,spend time %d", zuper.getClass().getName(), spendTime ) );
	}
	return ret;
}

}
