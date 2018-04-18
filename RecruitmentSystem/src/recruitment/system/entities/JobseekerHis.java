package recruitment.system.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the jobseeker_his database table.
 * 
 */
public class JobseekerHis implements Serializable {
	private static final long serialVersionUID = 1L;
	private String email;
	private int postid;
	private String status;
	private String feedback;
	public JobseekerHis(String email, int postid, String status, String feedback) {
		super();
		this.email = email;
		this.postid = postid;
		this.status = status;
		this.feedback = feedback;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPostid() {
		return postid;
	}
	public void setPostid(int postid) {
		this.postid = postid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}