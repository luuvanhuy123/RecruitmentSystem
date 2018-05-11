package recruitment.system.interfaceinf;

import java.util.List;

import recruitment.system.entities.JobPost;
import recruitment.system.entities.JobPostInf;
import recruitment.system.entities.JobSeeker;
import recruitment.system.entities.JobseekerHi;
import recruitment.system.entities.JobseekerHis;
import recruitment.system.function.SearchJob;

public interface InterfaceUser {
	//create new jobPost
	public abstract int jobPost(JobPost jobpost);//constructor full
	//Search JobPost By AnyThing | example: id,date,location... you can consult constructor below
	public abstract List<JobPostInf>searchJobpost(SearchJob jobpost); //constructor(id),(date),(location),(position),(job_name),(job_name,job_positon,location)
	//Change Status Of JobPost And Update DateTime 
	public abstract boolean changeStatus_Jobpost(JobPost jobpost);//constructor(id);
	//Download CV
	public abstract boolean downloadCV(String jobseeker);
	// registry jonPost
	public abstract boolean registryJobPost(String email, int potsid);
	//get history
	public abstract List<JobPost> getHistoryPost(String username);
	//get history regis
	public abstract List<JobseekerHis> getHistoryRegis(String username);
	// job detail
	public abstract JobPostInf jobDetail(int postId);
	// danh sach bai chua duoc duyet
	public abstract List<JobPostInf> getListJobConfirm();
	public abstract boolean confirm(int postid, String username);
	public abstract List<JobseekerHis> getListRegis(int id);
	public abstract boolean connect(String username, int postid, String feedback);
}
