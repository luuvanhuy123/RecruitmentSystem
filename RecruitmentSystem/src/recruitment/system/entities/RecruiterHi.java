package recruitment.system.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the recruiter_his database table.
 * 
 */
@Entity
@Table(name="recruiter_his")
@NamedQuery(name="RecruiterHi.findAll", query="SELECT r FROM RecruiterHi r")
public class RecruiterHi implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RecruiterHiPK id;

	private int status;

	//bi-directional many-to-one association to JobPost
	@ManyToOne
	@JoinColumn(name="postid")
	private JobPost jobPost;

	//bi-directional many-to-one association to Recruiter
	@ManyToOne
	@JoinColumn(name="email")
	private Recruiter recruiter;

	public RecruiterHi() {
	}

	public RecruiterHi(RecruiterHiPK id, int status, JobPost jobPost, Recruiter recruiter) {
		super();
		this.id = id;
		this.status = status;
		this.jobPost = jobPost;
		this.recruiter = recruiter;
	}

	public RecruiterHi(int status, Recruiter recruiter) {
		super();
		this.status = status;
		this.recruiter = recruiter;
	}

	public RecruiterHiPK getId() {
		return this.id;
	}

	public void setId(RecruiterHiPK id) {
		this.id = id;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public JobPost getJobPost() {
		return this.jobPost;
	}

	public void setJobPost(JobPost jobPost) {
		this.jobPost = jobPost;
	}

	public Recruiter getRecruiter() {
		return this.recruiter;
	}

	public void setRecruiter(Recruiter recruiter) {
		this.recruiter = recruiter;
	}

	@Override
	public String toString() {
		return recruiter.toStringJobpost()+ ", "+"status=" + status;
	}

}