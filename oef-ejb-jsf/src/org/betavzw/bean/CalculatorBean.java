package org.betavzw.bean;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class CalculatorBean
 */
@Stateless
@LocalBean
public class CalculatorBean {

	/**
	 * Default constructor.
	 */
	public CalculatorBean() {
		// TODO Auto-generated constructor stub
	}

	public int optellen(int a, int b, Operand operand) {
		return operand.getFunction().apply(a, b);
	}

}
