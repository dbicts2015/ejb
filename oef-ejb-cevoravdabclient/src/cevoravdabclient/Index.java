package cevoravdabclient;

import java.math.BigDecimal;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnectionFactory;

@Named
@RequestScoped
public class Index {
	
	@Resource(mappedName="java:comp/DefaultJMSConnetionFactory")
	private TopicConnectionFactory factory;

	@Resource(mappedName = "betatopic")
	private Topic topic;

	private BigDecimal bedrag;
	private String bestemmeling;

	public void verzenden() throws JMSException {
		Connection conn = null;
		Session sessie = null;
		try {
			conn = factory.createConnection();
			sessie = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageProducer producer = sessie.createProducer(topic);
			MapMessage message = sessie.createMapMessage();
			message.setString("Bedrag", bedrag.toPlainString());
			message.setStringProperty("klant", bestemmeling);
			producer.send(message);
		} finally {
			if (sessie != null)
				sessie.close();
			if (conn != null)
				conn.close();
		}
	}

	public BigDecimal getBedrag() {
		return bedrag;
	}

	public void setBedrag(BigDecimal bedrag) {
		this.bedrag = bedrag;
	}

	public String getBestemmeling() {
		return bestemmeling;
	}

	public void setBestemmeling(String bestemmeling) {
		this.bestemmeling = bestemmeling;
	}
}
