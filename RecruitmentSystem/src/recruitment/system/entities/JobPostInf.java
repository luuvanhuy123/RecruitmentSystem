package recruitment.system.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Lob;

public class JobPostInf {
	private int postsId;
	private String benefit;
	private int careerid;
	private String date;
	private String jobDescription;
	private String jobName;
	private String jobPosition;
	private String jobRecruitment;
	private int locationid;
	private String otherInfor;
	private String salary;
	private String username;
	private int status;
	private String company_name;
	private String company_addres;
	private String company_phone;
	public JobPostInf(int postsId, String benefit, int careerid, String date, String jobDescription, String jobName,
			String jobPosition, String jobRecruitment, int locationid, String otherInfor, String salary,
			String username, int status, String company_name, String company_addres, String company_phone) {
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
		this.username = username;
		this.status = status;
		this.company_name = company_name;
		this.company_addres = company_addres;
		this.company_phone = company_phone;
	}
	public int getPostsId() {
		return postsId;
	}
	public void setPostsId(int postsId) {
		this.postsId = postsId;
	}
	public String getBenefit() {
		return benefit;
	}
	public void setBenefit(String benefit) {
		this.benefit = benefit;
	}
	public int getCareerid() {
		return careerid;
	}
	public void setCareerid(int careerid) {
		this.careerid = careerid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getJobPosition() {
		return jobPosition;
	}
	public void setJobPosition(String jobPosition) {
		this.jobPosition = jobPosition;
	}
	public String getJobRecruitment() {
		return jobRecruitment;
	}
	public void setJobRecruitment(String jobRecruitment) {
		this.jobRecruitment = jobRecruitment;
	}
	public int getLocationid() {
		return locationid;
	}
	public void setLocationid(int locationid) {
		this.locationid = locationid;
	}
	public String getOtherInfor() {
		return otherInfor;
	}
	public void setOtherInfor(String otherInfor) {
		this.otherInfor = otherInfor;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getCompany_addres() {
		return company_addres;
	}
	public void setCompany_addres(String company_addres) {
		this.company_addres = company_addres;
	}
	public String getCompany_phone() {
		return company_phone;
	}
	public void setCompany_phone(String company_phone) {
		this.company_phone = company_phone;
	}
	
}
