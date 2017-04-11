package daos;

import java.util.List;

import models.Friend;

public interface FriendDAO {
	
public boolean save(Friend friend); 
	
	public boolean update(Friend friend);
	
	public boolean delete(int userID,int friendID);
	
	public List<Friend> getMyFriends(int userID);
	
	public Friend getName(String name);
	
	public List<Friend> getMyNewFriendRequest(int userID);

	public void setOnline(int userID);
	
	public void setOffline(int userID);

    public Friend get(int userID,int friendID);
     
}

