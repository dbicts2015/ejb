package org.betavzw.bean;

import java.util.function.BiFunction;

public enum Operand {

	SUM((o1, o2) -> o1 + o2),
	SUBTRACT((o1, o2) -> o1 - o2),
	MULTIPLY((o1, o2) -> o1 * o2),
	DIVIDE((o1, o2) -> o1 / o2);
	
	private final BiFunction<Integer, Integer, Integer> function;
	
	private Operand(BiFunction<Integer, Integer, Integer> function) {
		this.function = function;
	}

	public BiFunction<Integer, Integer, Integer> getFunction() {
		return function;
	}

}