package com.gwill.agent;

import org.ho.yaml.Yaml;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by zhangpenghong on 2019/6/11.
 */
public class YmlLoader {
private static HashMap config = null;

public static HashMap loadYmlConfig(String fileName) {
	if (config == null) {
		File conf = new File( fileName );
		if (conf.exists()) {
			try {
				HashMap confMap = (HashMap) Yaml.load( conf );
				config = (HashMap) confMap.get( "agent" );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	return config;
}

public static ArrayList getIncludePackages() {
	return (ArrayList) config.get( "include" );
}

public static ArrayList getExcludePackages() {
	return (ArrayList) config.get( "exculde" );
}

public static ArrayList getExcludeClassRegexs() {
	return (ArrayList) config.get( "exclude-class" );
}

public static HashMap getLog() {
	return (HashMap) config.get( "log" );
}
}
