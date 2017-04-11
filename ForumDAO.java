package daos;

import java.util.List;

import models.Forum;

public interface ForumDAO {

public boolean save(Forum forum); 
	
	public boolean update(Forum forum);
	
	public boolean delete(int forumID);
	
	public Forum get(int forumID);
	
	public Forum getName(String name);
	
	public List<Forum> list();


}

