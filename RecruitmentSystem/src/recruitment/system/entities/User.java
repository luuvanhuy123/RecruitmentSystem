package recruitment.system.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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

	//bi-directional one-to-one association to Admin
	@OneToOne(mappedBy="user")
	private Admin admin;

	//bi-directional many-to-one association to JobPost
	@OneToMany(mappedBy="user")
	private List<JobPost> jobPosts;

	//bi-directional one-to-one association to JobSeeker
	@OneToOne(mappedBy="user")
	private JobSeeker jobSeeker;

	//bi-directional one-to-one association to Recruiter
	@OneToOne(mappedBy="user")
	private Recruiter recruiter;

	//bi-directional many-to-one association to RecruiteregistrationHistory
	@OneToMany(mappedBy="user")
	private List<RecruiteregistrationHistory> recruiteregistrationHistories;

	//bi-directional many-to-many association to Role
	@ManyToMany
	@JoinTable(
		name="user_role"
		, joinColumns={
			@JoinColumn(name="username")
			}
		, inverseJoinColumns={
			@JoinColumn(name="rolenid")
			}
		)
	private List<Role> roles;

	public User() {
	}
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	public User(String username, String password, Admin admin, List<JobPost> jobPosts, JobSeeker jobSeeker,
			Recruiter recruiter, List<RecruiteregistrationHistory> recruiteregistrationHistories, List<Role> roles) {
		super();
		this.username = username;
		this.password = password;
		this.admin = admin;
		this.jobPosts = jobPosts;
		this.jobSeeker = jobSeeker;
		this.recruiter = recruiter;
		this.recruiteregistrationHistories = recruiteregistrationHistories;
		this.roles = roles;
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

	public Admin getAdmin() {
		return this.admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public List<JobPost> getJobPosts() {
		return this.jobPosts;
	}

	public void setJobPosts(List<JobPost> jobPosts) {
		this.jobPosts = jobPosts;
	}

	public JobPost addJobPost(JobPost jobPost) {
		getJobPosts().add(jobPost);
		jobPost.setUser(this);

		return jobPost;
	}

	public JobPost removeJobPost(JobPost jobPost) {
		getJobPosts().remove(jobPost);
		jobPost.setUser(null);

		return jobPost;
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

	public List<RecruiteregistrationHistory> getRecruiteregistrationHistories() {
		return this.recruiteregistrationHistories;
	}

	public void setRecruiteregistrationHistories(List<RecruiteregistrationHistory> recruiteregistrationHistories) {
		this.recruiteregistrationHistories = recruiteregistrationHistories;
	}

	public RecruiteregistrationHistory addRecruiteregistrationHistory(RecruiteregistrationHistory recruiteregistrationHistory) {
		getRecruiteregistrationHistories().add(recruiteregistrationHistory);
		recruiteregistrationHistory.setUser(this);

		return recruiteregistrationHistory;
	}

	public RecruiteregistrationHistory removeRecruiteregistrationHistory(RecruiteregistrationHistory recruiteregistrationHistory) {
		getRecruiteregistrationHistories().remove(recruiteregistrationHistory);
		recruiteregistrationHistory.setUser(null);

		return recruiteregistrationHistory;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}