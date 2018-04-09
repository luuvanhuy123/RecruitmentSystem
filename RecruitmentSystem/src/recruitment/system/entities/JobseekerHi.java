package recruitment.system.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the jobseeker_his database table.
 * 
 */
@Entity
@Table(name="jobseeker_his")
@NamedQuery(name="JobseekerHi.findAll", query="SELECT j FROM JobseekerHi j")
public class JobseekerHi implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private JobseekerHiPK id;

	@Lob
	private String feedback;

	@Lob
	private String status;

	//bi-directional many-to-one association to JobPost
	@ManyToOne
	@JoinColumn(name="postid")
	private JobPost jobPost;

	//bi-directional many-to-one association to JobSeeker
	@ManyToOne
	@JoinColumn(name="email")
	private JobSeeker jobSeeker;

	public JobseekerHi() {
	}

	public JobseekerHiPK getId() {
		return this.id;
	}

	public void setId(JobseekerHiPK id) {
		this.id = id;
	}

	public String getFeedback() {
		return this.feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public JobPost getJobPost() {
		return this.jobPost;
	}

	public void setJobPost(JobPost jobPost) {
		this.jobPost = jobPost;
	}

	public JobSeeker getJobSeeker() {
		return this.jobSeeker;
	}

	public void setJobSeeker(JobSeeker jobSeeker) {
		this.jobSeeker = jobSeeker;
	}

}