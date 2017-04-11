package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Table(name="BLOG_COMMENTS")
@Component
public class BlogComment extends BaseDomain {
	
	@Id
	@GeneratedValue(generator="InvSeq") 
    @SequenceGenerator(name="InvSeq",sequenceName="BLOG_COMMENT_SEQ", allocationSize=1)
	private int id;
	@NotEmpty(message="Please fill some comment")
	private String comments;
	@NotEmpty(message="Please fill the comment date")
	private String commentDate;
	private int user_id;
	private int blog_id;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getBlog_id() {
		return blog_id;
	}
	public void setBlog_id(int blog_id) {
		this.blog_id = blog_id;
	}
	
	
	
}
