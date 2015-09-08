package ejbs;

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
		System.out.println("in constructor van calculator bean");
	}

	public int telOp(int getal_1, int getal_2) {
		return getal_1 + getal_2;
	}

}
