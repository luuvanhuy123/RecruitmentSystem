package recruitment.system.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String username;

	private String password;

	private int roleId;

	//bi-directional one-to-one association to Admin
	@OneToOne(mappedBy="user")
	private Admin admin;

	//bi-directional one-to-one association to JobSeeker
	@OneToOne(mappedBy="user")
	private JobSeeker jobSeeker;

	//bi-directional one-to-one association to Recruiter
	@OneToOne(mappedBy="user")
	private Recruiter recruiter;

	public User() {
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public Admin getAdmin() {
		return this.admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public JobSeeker getJobSeeker() {
		return this.jobSeeker;
	}

	public void setJobSeeker(JobSeeker jobSeeker) {
		this.jobSeeker = jobSeeker;
	}

	public Recruiter getRecruiter() {
		return this.recruiter;
	}

	public void setRecruiter(Recruiter recruiter) {
		this.recruiter = recruiter;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", roleId=" + roleId + "]";
	}
	public String toStringPassword(){
		return "password="+password;
	}

}