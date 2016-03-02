package org.ahhn.com.aop.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

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
@Order(0)
@Aspect
@Component
public class ValidateAspect {

	@Before("org.ahhn.com.aop.impl.LoggingAspect.declareJointPointExpression()")
	public void validateArgs(JoinPoint joinPoint) {
		System.out.println("--->validate: " + Arrays.asList(joinPoint.getArgs()));
	}
}
