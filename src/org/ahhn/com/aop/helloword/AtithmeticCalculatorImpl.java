package org.ahhn.com.aop.helloword;

/**
 * Created by XJX on 2016/2/29.
 */
public class AtithmeticCalculatorImpl implements AtithmeticCalculator {
	@Override
	public int add(int i, int j) {
		int result=i+j;
		return result;
	}

	@Override
	public int sub(int i, int j) {
		return 0;
	}

	@Override
	public int mul(int i, int j) {
		return 0;
	}

	@Override
	public int div(int i, int j) {
		return 0;
	}
}
