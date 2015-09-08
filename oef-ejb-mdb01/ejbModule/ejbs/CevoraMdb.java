package ejbs;

import java.util.Enumeration;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Message-Driven Bean implementation class for: CevoraMdb
 */
@MessageDriven(
		activationConfig = {
				@ActivationConfigProperty(propertyName = "destination", propertyValue = "betatopic"),
				@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
				@ActivationConfigProperty(propertyName = "messageSelector", propertyValue="klant = 'Cevora'")
		}, 
		mappedName = "betatopic")
public class CevoraMdb implements MessageListener {

    /**
     * Default constructor. 
     */
    public CevoraMdb() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
	public void onMessage(Message message) {
		if (message instanceof MapMessage) {
			MapMessage mm = (MapMessage) message;
			try {
				Enumeration<String> mapnamen = mm.getMapNames();
				System.out.println("Cevora kreeg het volgende bericht:");
				while (mapnamen.hasMoreElements()) {
					String naam = mapnamen.nextElement();
					System.out.println(naam + ": " + mm.getString(naam));
				}
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

}
