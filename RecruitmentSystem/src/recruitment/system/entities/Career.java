package recruitment.system.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the career database table.
 * 
 */
@Entity
@NamedQuery(name="Career.findAll", query="SELECT c FROM Career c")
public class Career implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int careerId;

	@Lob
	@Column(name="career_name")
	private String careerName;

	//bi-directional many-to-many association to JobPost
	@ManyToMany(mappedBy="careers")
	private List<JobPost> jobPosts;

	public Career() {
	}

	public Career(int careerId, String careerName, List<JobPost> jobPosts) {
		super();
		this.careerId = careerId;
		this.careerName = careerName;
		this.jobPosts = jobPosts;
	}

	public int getCareerId() {
		return this.careerId;
	}

	public void setCareerId(int careerId) {
		this.careerId = careerId;
	}

	public String getCareerName() {
		return this.careerName;
	}

	public void setCareerName(String careerName) {
		this.careerName = careerName;
	}

	public List<JobPost> getJobPosts() {
		return this.jobPosts;
	}

	public void setJobPosts(List<JobPost> jobPosts) {
		this.jobPosts = jobPosts;
	}

}