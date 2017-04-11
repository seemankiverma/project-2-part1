package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="JOB")
@Component
public class Job extends BaseDomain {
	
	@Id
	@GeneratedValue(generator="InvSeq") 
    @SequenceGenerator(name="InvSeq",sequenceName="JOB_SEQ", allocationSize=1)
	private int job_id;
	private int user_id;
	private String job_title;
	private String company;
	private Date creation_date;
	private String expiry_date;
	private String details;
	//private char status;
	
	public int getJob_id() {
		return job_id;
	}
	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getJob_title() {
		return job_title;
	}
	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Date getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}
	public String getExpiry_date() {
		return expiry_date;
	}
	public void setExpiry_date(String expiry_date) {
		this.expiry_date = expiry_date;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	/*public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	*/
}
