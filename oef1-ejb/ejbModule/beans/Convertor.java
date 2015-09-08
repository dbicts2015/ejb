package beans;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class Convertor
 */
@Stateless
public class Convertor implements ConvertorRemote {

    /**
     * Default constructor. 
     */
    public Convertor() {
    	
    }

	@Override
	public double fahrenheitCelsius(double input) {
		return input * (1.8) + 32;
	}

	@Override
	public double celsiusFahrenheit(double input) {
		return (input - 32) / 1.8;
	}

}
