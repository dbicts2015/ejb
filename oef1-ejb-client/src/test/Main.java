package test;


import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import beans.ConvertorRemote;

public class Main {

	public static void main(String[] args) throws NamingException {
		Properties props = new Properties();
		props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
		props.put("org.omg.CORBA.ORBInitialHost", "localhost");
		Context ctx = new InitialContext(props);
		
		ConvertorRemote convertor = (ConvertorRemote) ctx.lookup("java:global/oef1-ejb/Convertor");
		System.out.println(convertor.celsiusFahrenheit(10.0));
	}

}