package org.ahhn.com.aop.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created by XJX on 2016/3/1.
 */
//把这个类声明为切面：需要把该类放入IOC容器中、再声明为一个切面
@Aspect
@Component
public class LoggingAspect {
	//声明该方法是一个前置通知：在目标方法开始之前执行
	@Before("execution(public int org.ahhn.com.aop.impl.ArithmeticCalculator.*(int,int))")
	public void beforeMethod(JoinPoint joinPointot) {
		String methodName = joinPointot.getSignature().getName();
		List<Object> args = Arrays.asList(joinPointot.getArgs());
		System.out.println("The Method " + methodName + " begins " + args);
	}
}
