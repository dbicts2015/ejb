package bean;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;

/**
 * Session Bean implementation class MyBean
 */
@Stateful
@LocalBean
public class MyBean {

	/**
	 * 
	 */
	private int teller;

	/**
	 * Default constructor.
	 */
	public MyBean() {
		// EJB default constructor
	}

	public int getTeller() {
		return teller;
	}

	public void verhoogTeller() {
		teller++;
	}

}