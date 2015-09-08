package ejbs;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Message-Driven Bean implementation class for: MdbBetaBean
 */
@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "betaqueue"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") }, mappedName = "betaqueue")
public class MdbBetaBean implements MessageListener {

	/**
	 * De context
	 */
	@Resource private MessageDrivenContext mdc;

	/**
	 * Default constructor.
	 */
	public MdbBetaBean() {
		// EJB Default constructor
	}

	/**
	 * @see MessageListener#onMessage(Message)
	 */
	@Override public void onMessage(Message message) {
		try {
			if (message instanceof TextMessage) {
				TextMessage msg = (TextMessage) message;
						System.out.println(msg.getText());
			} else {
				System.out.println("Message of wrong type: " + message.getClass().getName());
			}
		} catch (JMSException e) {
			e.printStackTrace();
			mdc.setRollbackOnly();
		} catch (Throwable te) {
			te.printStackTrace();
		}
	}

}
