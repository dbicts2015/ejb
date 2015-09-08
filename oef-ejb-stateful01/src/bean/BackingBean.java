package bean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class BackingBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EJB private MyBean bean;

	public int getTeller() {
		return bean.getTeller();
	}

	public void verhoog() {
		bean.verhoogTeller();
	}
}