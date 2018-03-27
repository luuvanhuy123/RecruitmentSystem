package recruitment.system.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the job_posts database table.
 * 
 */
@Entity
@Table(name="job_posts")
@NamedQuery(name="JobPost.findAll", query="SELECT j FROM JobPost j")
public class JobPost implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="posts_id")
	private int postsId;

	@Lob
	private String benefit;

	@Lob
	@Column(name="job_description")
	private String jobDescription;

	@Lob
	@Column(name="job_name")
	private String jobName;

	@Lob
	@Column(name="job_position")
	private String jobPosition;

	@Lob
	@Column(name="job_recruitment")
	private String jobRecruitment;

	@Lob
	private String location;

	@Lob
	@Column(name="other_information")
	private String otherInformation;

	@Lob
	@Column(name="`post date`")
	private String post_date;

	@Column(name="posts_status")
	private int postsStatus;

	@Column(name="posts_type")
	private String postsType;

	@Lob
	private String salary;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="username")
	private User user;

	//bi-directional many-to-many association to Career
	@ManyToMany
	@JoinTable(
		name="posts_career"
		, joinColumns={
			@JoinColumn(name="posts_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="career_id")
			}
		)
	private List<Career> careers;

	//bi-directional many-to-one association to RecruiteregistrationHistory
	@OneToMany(mappedBy="jobPost")
	private List<RecruiteregistrationHistory> recruiteregistrationHistories;

	public JobPost() {
	}

	public JobPost(User user) {
		super();
		this.user = user;
	}

	public JobPost(int postsId, int postsStatus) {
		super();
		this.postsId = postsId;
		this.postsStatus = postsStatus;
	}

	public JobPost(int postsId,String benefit, String jobDescription, String jobName, String jobPosition,
			String jobRecruitment, String location, String otherInformation, String post_date, int postsStatus,
			String postsType, String salary, User user, List<Career> careers) {
		super();
		this.postsId=postsId;
		this.benefit = benefit;
		this.jobDescription = jobDescription;
		this.jobName = jobName;
		this.jobPosition = jobPosition;
		this.jobRecruitment = jobRecruitment;
		this.location = location;
		this.otherInformation = otherInformation;
		this.post_date = post_date;
		this.postsStatus = postsStatus;
		this.postsType = postsType;
		this.salary = salary;
		this.user = user;
		this.careers = careers;
	}

	public JobPost(int postsId, String benefit, String jobDescription, String jobName, String jobPosition,
			String jobRecruitment, String location, String otherInformation, String post_date, int postsStatus,
			String postsType, String salary, User user, List<Career> careers,
			List<RecruiteregistrationHistory> recruiteregistrationHistories) {
		super();
		this.postsId = postsId;
		this.benefit = benefit;
		this.jobDescription = jobDescription;
		this.jobName = jobName;
		this.jobPosition = jobPosition;
		this.jobRecruitment = jobRecruitment;
		this.location = location;
		this.otherInformation = otherInformation;
		this.post_date = post_date;
		this.postsStatus = postsStatus;
		this.postsType = postsType;
		this.salary = salary;
		this.user = user;
		this.careers = careers;
		this.recruiteregistrationHistories = recruiteregistrationHistories;
	}

	public int getPostsId() {
		return this.postsId;
	}

	public void setPostsId(int postsId) {
		this.postsId = postsId;
	}

	public String getBenefit() {
		return this.benefit;
	}

	public void setBenefit(String benefit) {
		this.benefit = benefit;
	}

	public String getJobDescription() {
		return this.jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getJobName() {
		return this.jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobPosition() {
		return this.jobPosition;
	}

	public void setJobPosition(String jobPosition) {
		this.jobPosition = jobPosition;
	}

	public String getJobRecruitment() {
		return this.jobRecruitment;
	}

	public void setJobRecruitment(String jobRecruitment) {
		this.jobRecruitment = jobRecruitment;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getOtherInformation() {
		return this.otherInformation;
	}

	public void setOtherInformation(String otherInformation) {
		this.otherInformation = otherInformation;
	}

	public String getPost_date() {
		return this.post_date;
	}

	public void setPost_date(String post_date) {
		this.post_date = post_date;
	}

	public int getPostsStatus() {
		return this.postsStatus;
	}

	public void setPostsStatus(int postsStatus) {
		this.postsStatus = postsStatus;
	}

	public String getPostsType() {
		return this.postsType;
	}

	public void setPostsType(String postsType) {
		this.postsType = postsType;
	}

	public String getSalary() {
		return this.salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Career> getCareers() {
		return this.careers;
	}

	public void setCareers(List<Career> careers) {
		this.careers = careers;
	}

	public List<RecruiteregistrationHistory> getRecruiteregistrationHistories() {
		return this.recruiteregistrationHistories;
	}

	public void setRecruiteregistrationHistories(List<RecruiteregistrationHistory> recruiteregistrationHistories) {
		this.recruiteregistrationHistories = recruiteregistrationHistories;
	}

	public RecruiteregistrationHistory addRecruiteregistrationHistory(RecruiteregistrationHistory recruiteregistrationHistory) {
		getRecruiteregistrationHistories().add(recruiteregistrationHistory);
		recruiteregistrationHistory.setJobPost(this);

		return recruiteregistrationHistory;
	}

	public RecruiteregistrationHistory removeRecruiteregistrationHistory(RecruiteregistrationHistory recruiteregistrationHistory) {
		getRecruiteregistrationHistories().remove(recruiteregistrationHistory);
		recruiteregistrationHistory.setJobPost(null);

		return recruiteregistrationHistory;
	}

	@Override
	public String toString() {
		return "JobPost [postsId=" + postsId + ", benefit=" + benefit + ", jobDescription=" + jobDescription
				+ ", jobName=" + jobName + ", jobPosition=" + jobPosition + ", jobRecruitment=" + jobRecruitment
				+ ", location=" + location + ", otherInformation=" + otherInformation + ", post_date=" + post_date
				+ ", postsStatus=" + postsStatus + ", postsType=" + postsType + ", salary=" + salary + ", user=" + user.UserJobPost()
				+ ", careers=" + careers + "]";
	}

}