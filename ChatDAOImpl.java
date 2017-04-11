package daos;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ChatDAOImpl implements ChatDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public ChatDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


}
