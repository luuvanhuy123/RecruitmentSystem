package recruitment.system.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the recruiteregistration_history database table.
 * 
 */
@Entity
@Table(name="recruiteregistration_history")
@NamedQuery(name="RecruiteregistrationHistory.findAll", query="SELECT r FROM RecruiteregistrationHistory r")
public class RecruiteregistrationHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RecruiteregistrationHistoryPK id;

	@Lob
	private String noties;

	private String status;

	private int type;

	//bi-directional many-to-one association to JobPost
	@ManyToOne
	@JoinColumn(name="posts_id")
	private JobPost jobPost;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="username")
	private User user;

	public RecruiteregistrationHistory() {
	}

	public RecruiteregistrationHistory(String noties, String status, int type) {
		super();
		this.noties = noties;
		this.status = status;
		this.type = type;
	}

	public RecruiteregistrationHistory(RecruiteregistrationHistoryPK id, String noties, String status, int type,
			JobPost jobPost, User user) {
		super();
		this.id = id;
		this.noties = noties;
		this.status = status;
		this.type = type;
		this.jobPost = jobPost;
		this.user = user;
	}

	public RecruiteregistrationHistoryPK getId() {
		return this.id;
	}

	public void setId(RecruiteregistrationHistoryPK id) {
		this.id = id;
	}

	public String getNoties() {
		return this.noties;
	}

	public void setNoties(String noties) {
		this.noties = noties;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public JobPost getJobPost() {
		return this.jobPost;
	}

	public void setJobPost(JobPost jobPost) {
		this.jobPost = jobPost;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}