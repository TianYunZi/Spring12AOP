package org.ahhn.com.aop.helloword;

/**
 * Created by XJX on 2016/2/29.
 */
public class Main {
	public static void main(String[] args) {
//		ArithmeticCalculator arithmeticCalculator = null;
//		arithmeticCalculator = new ArithmeticCalculatorImpl();
//
//		int result = arithmeticCalculator.add(2, 3);
//		System.out.println("-->" + result);
//
//		result = arithmeticCalculator.sub(2, 3);
//		System.out.println("-->" + result);
//
//		result = arithmeticCalculator.mul(2, 3);
//		System.out.println("-->" + result);
//
//		result = arithmeticCalculator.div(2, 3);
//		System.out.println("-->" + result);

		ArithmeticCalculator target=new ArithmeticCalculatorLoggingImpl();
		ArithmeticCalculator proxy=new ArithmeticCalculatorLoggingProxy(target).getLoggingProxy();
		System.out.println(proxy.getClass().getName());

		int result = proxy.add(2, 3);
		System.out.println("-->" + result);

		result = proxy.sub(2, 3);
		System.out.println("-->" + result);

		result = proxy.mul(2, 3);
		System.out.println("-->" + result);

		result = proxy.div(2, 3);
		System.out.println("-->" + result);
	}
}
