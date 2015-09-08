package org.betavzw.bean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class Index implements Serializable {

	private static final long serialVersionUID = 1L;
	private int getal1;
	private int getal2;
	private Operand operand = Operand.SUM;
	
	@EJB private CalculatorBean calculator;

	public int som() {
		return calculator.optellen(getal1, getal2, operand);
	}

	/**
	 * @return the getal1
	 */
	public int getGetal1() {
		return getal1;
	}

	/**
	 * @param getal1
	 *            the getal1 to set
	 */
	public void setGetal1(int getal1) {
		this.getal1 = getal1;
	}

	/**
	 * @return the getal2
	 */
	public int getGetal2() {
		return getal2;
	}

	/**
	 * @param getal2
	 *            the getal2 to set
	 */
	public void setGetal2(int getal2) {
		this.getal2 = getal2;
	}

	/**
	 * @return the operand
	 */
	public Operand getOperand() {
		return operand;
	}

	/**
	 * @param operand the operand to set
	 */
	public void setOperand(Operand operand) {
		this.operand = operand;
	}

	public Operand[] operands() {
		return Operand.values();
	}

}