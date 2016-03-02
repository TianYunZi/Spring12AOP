package org.ahhn.com.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;
import java.util.List;

/**
 * Created by XJX on 2016/3/1.
 */
public class LoggingAspect {

	public void declareJointPointExpression(){}

	public void beforeMethod(JoinPoint joinPointot) {
		String methodName = joinPointot.getSignature().getName();
		List<Object> args = Arrays.asList(joinPointot.getArgs());
		System.out.println("The Method " + methodName + " begins " + args);
	}

	public void afterMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The Method " + methodName + " after " + args);
	}

	public void afterReturning(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The Method " + methodName + " return " + result);
	}

	public void afterThrowing(JoinPoint joinPoint, Exception ex) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The Method " + methodName + " afterThrowing " + ex);
	}

	public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint) {
		Object result = null;
		String methodName = proceedingJoinPoint.getSignature().getName();

		//执行目标方法
		try {
			//前置通知
			System.out.println("The Method " + methodName + " 前置通知 " + Arrays.asList(proceedingJoinPoint.getArgs()));
			//执行目标方法
			result = proceedingJoinPoint.proceed();
			//返回通知
			System.out.println("The Method " + methodName + " 返回通知 " + Arrays.asList(proceedingJoinPoint.getArgs()) + " " + result);
		} catch (Throwable throwable) {
			//异常通知
			throwable.printStackTrace();
		}
		//后置通知
		return result;
	}
}
