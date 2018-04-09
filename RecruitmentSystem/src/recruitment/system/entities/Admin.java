package recruitment.system.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the admin database table.
 * 
 */
@Entity
@NamedQuery(name="Admin.findAll", query="SELECT a FROM Admin a")
public class Admin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String email;

	@Lob
	private String address;

	@Lob
	private String name;

	@Lob
	@Column(name="phone_number")
	private String phoneNumber;

	private String sex;

	//bi-directional one-to-one association to User
	@OneToOne
	@JoinColumn(name="email")
	private User user;

	//bi-directional many-to-many association to JobPost
	@ManyToMany(mappedBy="admins")
	private List<JobPost> jobPosts;

	public Admin() {
	}

	public Admin(String email, String address, String name, String phoneNumber, String sex, User user) {
		super();
		this.email = email;
		this.address = address;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.sex = sex;
		this.user = user;
	}

	public Admin(String email, String address, String name, String phoneNumber, String sex, User user,
			List<JobPost> jobPosts) {
		super();
		this.email = email;
		this.address = address;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.sex = sex;
		this.user = user;
		this.jobPosts = jobPosts;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<JobPost> getJobPosts() {
		return this.jobPosts;
	}

	public void setJobPosts(List<JobPost> jobPosts) {
		this.jobPosts = jobPosts;
	}

	@Override
	public String toString() {
		return "Admin [email=" + email + ", address=" + address + ", name=" + name + ", phoneNumber=" + phoneNumber
				+ ", sex=" + sex + "," + user.toStringPassword() + "]";
	}

}