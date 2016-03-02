package org.ahhn.com.aop.xml;

import org.aspectj.lang.JoinPoint;

import java.util.Arrays;

/**
 * Created by XJX on 2016/3/2.
 */
//验证通知

/***
 *
 * 用@Order指定切面优先级，值越小，优先级越高
 *
  */
public class ValidateAspect {

	public void validateArgs(JoinPoint joinPoint) {
		System.out.println("--->validate: " + Arrays.asList(joinPoint.getArgs()));
	}
}
