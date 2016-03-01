package org.ahhn.com.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by XJX on 2016/3/1.
 */
public class Main {
	public static void main(String[] args) {
		//1、创建Spring的IOC容器
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");

		//2、从IOC容器中获取bean的实例
		ArithmeticCalculator arithmeticCalculator = ctx.getBean(ArithmeticCalculator.class);

		//使用bean
		int result = arithmeticCalculator.add(3, 6);
		System.out.println("result:" + result);

		int result2 = arithmeticCalculator.div(9, 6);
		System.out.println("result:" + result2);
	}
}
