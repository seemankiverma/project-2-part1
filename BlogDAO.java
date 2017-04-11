package daos;

import java.util.List;

import models.Blog;

public interface BlogDAO {

	public boolean save(Blog blog); 
	
	public boolean update(Blog blog);
	
	public boolean delete(Blog blog);
	
	public Blog get(int blogID);
	
	public Blog getName(String name);
	
	public List<Blog> list();
	

}
