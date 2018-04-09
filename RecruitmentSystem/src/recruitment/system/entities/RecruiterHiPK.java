package recruitment.system.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the recruiter_his database table.
 * 
 */
@Embeddable
public class RecruiterHiPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String postid;

	@Column(insertable=false, updatable=false)
	private String email;

	public RecruiterHiPK() {
	}
	public String getPostid() {
		return this.postid;
	}
	public void setPostid(String postid) {
		this.postid = postid;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RecruiterHiPK)) {
			return false;
		}
		RecruiterHiPK castOther = (RecruiterHiPK)other;
		return 
			this.postid.equals(castOther.postid)
			&& this.email.equals(castOther.email);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.postid.hashCode();
		hash = hash * prime + this.email.hashCode();
		
		return hash;
	}
}