package com.gwill.agent;

import net.bytebuddy.description.NamedElement;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;

import java.util.List;

/**
 * Created by zhangpenghong on 2019/6/13.
 */
public class LaddyGGElementMatcher {

private static ElementMatcher.Junction buildeMatcher(String prefix) {
	ElementMatcher.Junction elementMatchers = null;
	if (elementMatchers == null) {
		elementMatchers = ElementMatchers.nameStartsWith( prefix );
	} else {
		elementMatchers = elementMatchers.or( ElementMatchers.nameStartsWith( prefix ) );
	}
	return elementMatchers;
}

public static <T extends NamedElement> ElementMatcher.Junction<T> buildeMatcher(List<String> packagesList) {
	ElementMatcher.Junction elementMatchers = null;
	for (String packageName : packagesList) {
		elementMatchers = LaddyGGElementMatcher.buildeMatcher( packageName );
	}
	return elementMatchers;
}
}
