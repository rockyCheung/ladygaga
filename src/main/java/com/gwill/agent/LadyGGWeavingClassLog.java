package com.gwill.agent;

import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;

import java.io.File;
import java.io.IOException;

/**
 * Created by zhangpenghong on 2019/6/12.
 */
public enum LadyGGWeavingClassLog {
	INSTANCE;
private File weavingClassLogPath;

public void log(TypeDescription typeDescription, DynamicType dynamicType) {
	synchronized (INSTANCE) {
		try {
			if (weavingClassLogPath == null) {
				try {
					String logPath = (String) YmlLoader.getLog().get( "path" );
					weavingClassLogPath = new File( logPath );
					if (!weavingClassLogPath.exists()) {
						weavingClassLogPath.mkdir();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			try {
				dynamicType.saveIn( weavingClassLogPath );
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
}
}
