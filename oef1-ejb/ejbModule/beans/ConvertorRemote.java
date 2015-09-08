package beans;

import javax.ejb.Remote;

@Remote
public interface ConvertorRemote {

	/**
	 * 
	 * @param input
	 * @return
	 */
	public abstract double fahrenheitCelsius(double input);
	
	/**
	 * 
	 * @param input
	 * @return
	 */
	public abstract double celsiusFahrenheit(double input);

}