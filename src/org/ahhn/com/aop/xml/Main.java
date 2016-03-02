package org.ahhn.com.aop.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by XJX on 2016/3/1.
 */
public class Main {
	public static void main(String[] args) {
		//1、创建Spring的IOC容器
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-xml.xml");

		//2、从IOC容器中获取bean的实例
		ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) ctx.getBean("arithmeticCalculator");

		//使用bean
		int result = arithmeticCalculator.add(3, 6);
		System.out.println("result: " + result);

		int result2 = arithmeticCalculator.div(9, 6);
		System.out.println("result2: " + result2);

		//抛异常
		int result3 = arithmeticCalculator.div(9, 1);
		System.out.println("result3: " + result3);
	}
}
