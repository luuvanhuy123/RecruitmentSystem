package recruitment.system.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the jobseeker_his database table.
 * 
 */
@Embeddable
public class JobseekerHiPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String email;

	@Column(insertable=false, updatable=false)
	private String postid;

	public JobseekerHiPK() {
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPostid() {
		return this.postid;
	}
	public void setPostid(String postid) {
		this.postid = postid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof JobseekerHiPK)) {
			return false;
		}
		JobseekerHiPK castOther = (JobseekerHiPK)other;
		return 
			this.email.equals(castOther.email)
			&& this.postid.equals(castOther.postid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.email.hashCode();
		hash = hash * prime + this.postid.hashCode();
		
		return hash;
	}
}