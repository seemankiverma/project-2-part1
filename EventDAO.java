package daos;

import java.util.List;

import models.Event;

public interface EventDAO {

public boolean save(Event event); 
	
	public boolean update(Event event);
	
	public boolean delete(Event event);
	
	public Event get(int eventID);
	
	public Event getName(String name);
	
	public List<Event> list();
	


}

