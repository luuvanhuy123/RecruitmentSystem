package recruitment.system.entities;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.*;


/**
 * The persistent class for the job_seeker database table.
 * 
 */
@Entity
@Table(name="job_seeker")
@NamedQuery(name="JobSeeker.findAll", query="SELECT j FROM JobSeeker j")
public class JobSeeker implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String email;

	@Lob
	private byte[] cv;

	private String name;

	//bi-directional one-to-one association to User
	@OneToOne
	@JoinColumn(name="email")
	private User user;

	public JobSeeker() {
	}

	public JobSeeker(String email, byte[] cv, String name, User user) {
		super();
		this.email = email;
		this.cv = cv;
		this.name = name;
		this.user = user;
	}

	public JobSeeker(String email,String name, User user) {
		super();
		this.email=email;
		this.name = name;
		this.user = user;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte[] getCv() {
		return this.cv;
	}

	public void setCv(byte[] cv) {
		this.cv = cv;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "JobSeeker [email=" + email + ", name=" + name + ", user=" + user.User() + "]";
	}


	

}