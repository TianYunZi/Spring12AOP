package org.ahhn.com.aop.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created by XJX on 2016/3/1.
 */
//把这个类声明为切面：需要把该类放入IOC容器中、再声明为一个切面
@Order(1)
@Aspect
@Component
public class LoggingAspect {

	/***
	 * 定义一个方法，用于声明切入点表达式。一般的，该方法中再不需要添入其它代码
	 * 使用@Pointcut声明切入点表达式
	 */
	@Pointcut("execution(public int org.ahhn.com.aop.impl.ArithmeticCalculator.*(int,int))")
	public void declareJointPointExpression(){}

	//声明该方法是一个前置通知：在目标方法开始之前执行
	@Before("declareJointPointExpression()")
	public void beforeMethod(JoinPoint joinPointot) {
		String methodName = joinPointot.getSignature().getName();
		List<Object> args = Arrays.asList(joinPointot.getArgs());
		System.out.println("The Method " + methodName + " begins " + args);
	}

	//后置通知：在目标方法执行后（无论是否发生异常），执行的通知，在后置通知中，还不能访问目标方法执行的结果
//	@After("execution(public int ArithmeticCalculator.add(int,int ))")
	@After("execution(public int ArithmeticCalculator.*(int,int ))")
	public void afterMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The Method " + methodName + " after " + args);
	}

	//在方法正常结束后受执行的代码
	//返回通知是可以访问方法的返回值的
	@AfterReturning(value = "declareJointPointExpression()", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The Method " + methodName + " return " + result);
	}

	//在方法出现异常时执行，可以访问到异常对象，且可以指定出现特定异常时执行通知代码
	@AfterThrowing(value = "execution(public int ArithmeticCalculator.*(int,int))", throwing = "ex")
	public void afterThrowing(JoinPoint joinPoint, Exception ex) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The Method " + methodName + " afterThrowing " + ex);
	}

	//环绕通知
	//环绕通知需要携带ProceedingJoinPoint类型的参数
	//环绕通知类似于动态代理的全过程，ProceedingJoinPoint类型的参数可以决定是否执行目标方法，且环绕通知必须有返回值，返回值即为目标方法的返回值
	@Around("execution(public int ArithmeticCalculator.*(int,int))")
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
