package models;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="CHAT")
@Component

public class Chat {
	
	private int chat_id;
	private int user_id;
	

}
