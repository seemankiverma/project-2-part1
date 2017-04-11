package daos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import controllers.BlogController;
import models.User;

@SuppressWarnings("deprecation")
@Repository(value = "UserDAO")
public class UserDAOImpl implements UserDAO {

	private static final Logger logger	= LoggerFactory.getLogger(UserDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean save(User user) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Transactional
	public boolean update(User user) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean delete(User user) {
		// TODO Auto-generated method stub
		try {
			//System.out.println(userID);
			//String y=Integer.toString(userID);
			sessionFactory.getCurrentSession().delete(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public User get(int userID) {
		// TODO Auto-generated method stub
		String hql = "from User where user_id=" + userID ;

		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) query.list();

		if (list != null && !list.isEmpty()) {
			System.out.println("user retrieved from DAOImpl");
			return list.get(0);
		} else {
			return null;
		}
	}

	@Transactional
	public User getName(String name) {
		// TODO Auto-generated method stub
		String hql = "from User where userID=" + "'" + name + "'";
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) query.list();

		if (list != null && !list.isEmpty()) {
			System.out.println("username retrieved from DAOImpl");
			return list.get(0);
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<User> list() {
		// TODO Auto-generated method stub
		String hql = " from User";
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();

	}

	@Transactional
	public User isValidUser(String email, String password) {
		// TODO Auto-generated method stub
		String hql = "from User where email = '" + email + "' and password='" + password + "'";
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) query.list();

		if (list != null && !list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Transactional
	public void setOnline(int userID) {
		logger.debug("Starting of method setOnline");
		String hql="UPDATE User SET isOnline='Y' where user_id=" + userID;
		logger.debug("hql: " + hql);
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.executeUpdate();
		logger.debug("Ending of method setOnline");
	}


	@Transactional
	public void setOffline(int userID) {
		logger.debug("Starting of method setOffline");
		String hql="UPDATE User SET isOnline='N' where user_id=" + userID;
		logger.debug("hql: " + hql);
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.executeUpdate();
		logger.debug("Ending of method setOffline");
	}

	
	}
