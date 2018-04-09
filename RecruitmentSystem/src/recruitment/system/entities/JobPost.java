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

	private int careerid;

	@Lob
	private String date;

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

	private int locationid;

	@Lob
	@Column(name="other_infor")
	private String otherInfor;

	@Lob
	private String salary;

//	private int status;

	//bi-directional many-to-many association to Admin
	@ManyToMany
	@JoinTable(
		name="admin_his"
		, joinColumns={
			@JoinColumn(name="postid")
			}
		, inverseJoinColumns={
			@JoinColumn(name="email")
			}
		)
	private List<Admin> admins;

	//bi-directional many-to-one association to JobseekerHi
	@OneToMany(mappedBy="jobPost")
	private List<JobseekerHi> jobseekerHis;

	//bi-directional many-to-one association to RecruiterHi
	@OneToMany(mappedBy="jobPost")
	private List<RecruiterHi> recruiterHis;

	public JobPost() {
	}

	

	public JobPost(int postsId, String benefit, int careerid, String date, String jobDescription, String jobName,
			String jobPosition, String jobRecruitment, int locationid, String otherInfor, String salary) {
		super();
		this.postsId = postsId;
		this.benefit = benefit;
		this.careerid = careerid;
		this.date = date;
		this.jobDescription = jobDescription;
		this.jobName = jobName;
		this.jobPosition = jobPosition;
		this.jobRecruitment = jobRecruitment;
		this.locationid = locationid;
		this.otherInfor = otherInfor;
		this.salary = salary;
	}



	public JobPost(int postsId, String benefit, int careerid, String date, String jobDescription, String jobName,
			String jobPosition, String jobRecruitment, int locationid, String otherInfor, String salary,
			List<RecruiterHi> recruiterHis) {
		super();
		this.postsId = postsId;
		this.benefit = benefit;
		this.careerid = careerid;
		this.date = date;
		this.jobDescription = jobDescription;
		this.jobName = jobName;
		this.jobPosition = jobPosition;
		this.jobRecruitment = jobRecruitment;
		this.locationid = locationid;
		this.otherInfor = otherInfor;
		this.salary = salary;
		this.recruiterHis = recruiterHis;
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

	public int getCareerid() {
		return this.careerid;
	}

	public void setCareerid(int careerid) {
		this.careerid = careerid;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
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

	public int getLocationid() {
		return this.locationid;
	}

	public void setLocationid(int locationid) {
		this.locationid = locationid;
	}

	public String getOtherInfor() {
		return this.otherInfor;
	}

	public void setOtherInfor(String otherInfor) {
		this.otherInfor = otherInfor;
	}

	public String getSalary() {
		return this.salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

//	public int getStatus() {
//		return this.status;
//	}
//
//	public void setStatus(int status) {
//		this.status = status;
//	}

	public List<Admin> getAdmins() {
		return this.admins;
	}

	public void setAdmins(List<Admin> admins) {
		this.admins = admins;
	}

	public List<JobseekerHi> getJobseekerHis() {
		return this.jobseekerHis;
	}

	public void setJobseekerHis(List<JobseekerHi> jobseekerHis) {
		this.jobseekerHis = jobseekerHis;
	}

	public JobseekerHi addJobseekerHi(JobseekerHi jobseekerHi) {
		getJobseekerHis().add(jobseekerHi);
		jobseekerHi.setJobPost(this);
		return jobseekerHi;
	}

	public JobseekerHi removeJobseekerHi(JobseekerHi jobseekerHi) {
		getJobseekerHis().remove(jobseekerHi);
		jobseekerHi.setJobPost(null);

		return jobseekerHi;
	}

	public List<RecruiterHi> getRecruiterHis() {
		return this.recruiterHis;
	}

	public void setRecruiterHis(List<RecruiterHi> recruiterHis) {
		this.recruiterHis = recruiterHis;
	}

	public RecruiterHi addRecruiterHi(RecruiterHi recruiterHi) {
		getRecruiterHis().add(recruiterHi);
		recruiterHi.setJobPost(this);
		return recruiterHi;
	}

	public RecruiterHi removeRecruiterHi(RecruiterHi recruiterHi) {
		getRecruiterHis().remove(recruiterHi);
		recruiterHi.setJobPost(null);

		return recruiterHi;
	}

	@Override
	public String toString() {
		return "JobPost [postsId=" + postsId + ", benefit=" + benefit + ", careerid=" + careerid + ", date=" + date
				+ ", jobDescription=" + jobDescription + ", jobName=" + jobName + ", jobPosition=" + jobPosition
				+ ", jobRecruitment=" + jobRecruitment + ", locationid=" + locationid + ", otherInfor=" + otherInfor
				+ ", salary=" + salary + ", " + recruiterHis + "]";
	}

	

}