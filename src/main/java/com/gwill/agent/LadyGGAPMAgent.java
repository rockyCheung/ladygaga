package com.gwill.agent;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.utility.JavaModule;

import java.lang.instrument.Instrumentation;

/**
 * Created by zhangpenghong on 2019/6/12.
 */
public class LadyGGAPMAgent {
public static void premain(String agentOps, Instrumentation inst) {
	instrument( agentOps, inst );
}

public static void agentmain(String agentOps, Instrumentation inst) {
	instrument( agentOps, inst );
}

private static void instrument(String agentOps, Instrumentation inst) {
	// 初始化配置
	YmlLoader.loadYmlConfig( agentOps );
	new AgentBuilder.Default()
			.ignore( LaddyGGElementMatcher.buildeMatcher( YmlLoader.getExcludePackages() ) )
			.type( LaddyGGElementMatcher.buildeMatcher( YmlLoader.getIncludePackages() ) )
			.transform( new LaddyGGTransformer() )
			.with( new LaddyGGListener() )
			.installOn( inst );
}

private static class LaddyGGListener implements AgentBuilder.Listener {
	@Override
	public void onDiscovery(String typeName, ClassLoader classLoader, JavaModule module, boolean loaded) {

	}

	@Override
	public void onTransformation(TypeDescription typeDescription, ClassLoader classLoader, JavaModule module,
	                             boolean loaded, DynamicType dynamicType) {
		//修改后的类输出
		LadyGGWeavingClassLog.INSTANCE.log( typeDescription, dynamicType );
	}

	@Override
	public void onIgnored(TypeDescription typeDescription, ClassLoader classLoader, JavaModule module,
	                      boolean loaded) {
	}

	@Override
	public void onError(String typeName, ClassLoader classLoader, JavaModule module, boolean loaded,
	                    Throwable throwable) {
	}

	@Override
	public void onComplete(String typeName, ClassLoader classLoader, JavaModule module, boolean loaded) {
	}
}
}
