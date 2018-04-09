package recruitment.system.function;

public class SearchJob {
	
	private String jobName;
	private int career;
	private int location;
	
	
	public SearchJob() {
		super();
	}
	public SearchJob(String jobName, int career, int location) {
		super();
		this.jobName = jobName;
		this.career = career;
		this.location = location;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public int getCareer() {
		return career;
	}
	public void setCareer(int career) {
		this.career = career;
	}
	public int getLocation() {
		return location;
	}
	public void setLocation(int location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "SearchJob [jobName=" + jobName + ", career=" + career + ", location=" + location + "]";
	}
	
	
	
}
