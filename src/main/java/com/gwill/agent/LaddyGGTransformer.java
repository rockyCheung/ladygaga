package com.gwill.agent;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaModule;

/**
 * Created by zhangpenghong on 2019/6/13.
 */
public class LaddyGGTransformer implements AgentBuilder.Transformer {

public DynamicType.Builder<?> transform(DynamicType.Builder<?> builder, TypeDescription typeDescription, ClassLoader classLoader, JavaModule javaModule) {
//	String className = typeDescription.getCanonicalName();
//	MethodList list = typeDescription.getDeclaredMethods();
	try {
		builder = builder.method( ElementMatchers.any() ).intercept( MethodDelegation.to( LaddyGGMethodAdviceInterceptor.class ) );
	} catch (Exception e) {
		e.printStackTrace();
	}
	return builder;
}
}
