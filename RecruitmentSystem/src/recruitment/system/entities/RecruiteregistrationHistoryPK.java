package recruitment.system.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the recruiteregistration_history database table.
 * 
 */
@Embeddable
public class RecruiteregistrationHistoryPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="posts_id", insertable=false, updatable=false)
	private String postsId;

	@Column(insertable=false, updatable=false)
	private String username;

	public RecruiteregistrationHistoryPK() {
	}
	
	public RecruiteregistrationHistoryPK(String postsId, String username) {
		super();
		this.postsId = postsId;
		this.username = username;
	}

	public String getPostsId() {
		return this.postsId;
	}
	public void setPostsId(String postsId) {
		this.postsId = postsId;
	}
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RecruiteregistrationHistoryPK)) {
			return false;
		}
		RecruiteregistrationHistoryPK castOther = (RecruiteregistrationHistoryPK)other;
		return 
			this.postsId.equals(castOther.postsId)
			&& this.username.equals(castOther.username);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.postsId.hashCode();
		hash = hash * prime + this.username.hashCode();
		
		return hash;
	}
}