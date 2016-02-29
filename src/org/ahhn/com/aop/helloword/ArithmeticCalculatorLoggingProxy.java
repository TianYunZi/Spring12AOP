package org.ahhn.com.aop.helloword;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * Created by XJX on 2016/2/29.
 */
public class ArithmeticCalculatorLoggingProxy {
	private ArithmeticCalculator target;

	public ArithmeticCalculatorLoggingProxy(ArithmeticCalculator target) {
		this.target = target;
	}

	public ArithmeticCalculator getLoggingProxy() {
		ArithmeticCalculator proxy = null;

		//代理类由哪个类加载器进行加载
		ClassLoader loader = target.getClass().getClassLoader();

		//代理对象的类型，既其中有哪些方法
		Class[] interfaces = new Class[]{ArithmeticCalculator.class};

		//当调用代理类对象其中的方法时，该执行的代码
		InvocationHandler handler = new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				String methodName = method.getName();
				//日志
				System.out.println("The method" + methodName + " begins with " + Arrays.asList(args));
				//执行方法
				Object result = method.invoke(target, args);
				//日志
				System.out.println("The method" + methodName + " end with " + result);
				return result;
			}
		};

		proxy = (ArithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, handler);
		return proxy;
	}
}
