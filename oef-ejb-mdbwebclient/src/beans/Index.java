package beans;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.TextMessage;

@Named
@RequestScoped
public class Index {

	private String bericht;
	
	@Resource(mappedName="java:comp/DefaultJMSConnectionFactory")
	private QueueConnectionFactory connection_factory;
	
	@Resource(mappedName="betaqueue")
	private Queue queue;
	
	public String getBericht() {
		return bericht;
	}
	
	public void setBericht(String bericht) {
		this.bericht = bericht;
	}
	
	public void verzenden() {
		QueueConnection conn = null;
		QueueSession session = null;
		try {
			conn = connection_factory.createQueueConnection();
			session = conn.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
			QueueSender sender = session.createSender(queue);
			TextMessage message = session.createTextMessage();
			for (int i = 0; i < 10000; i++) {
				message.setText(bericht + " " + i);
				sender.send(message);
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
		finally{
			if (session != null){
				try {
					session.close();
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
			if (conn != null){
				try {
					conn.close();
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
