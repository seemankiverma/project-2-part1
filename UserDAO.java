package daos;

import java.util.List;

import models.User;

public interface UserDAO {
	
	public boolean save(User user); 
	
	public boolean update(User user);
	
	public boolean delete(User user);
	
	public User get(int userID);
	
	public User getName(String name);
	
	public List<User> list();
	
	public User isValidUser(String email, String password);
	
	public void setOnline(int userID);
	
	public void setOffline(int userID);


}
