package recruitment.system.interfaceinf;

import java.util.List;

import recruitment.system.entities.Admin;
import recruitment.system.entities.JobPost;
import recruitment.system.entities.JobSeeker;
import recruitment.system.entities.Recruiter;

public interface interfaceManager {
	
	// Get All List Of Table DataBase Admin
	public abstract List<Admin> getAllManager();

	// Get All List Of Table Database Job Seeker
	public abstract List<JobSeeker> getAllJobSeeker();

	// Get All List Of Table DataBase Recruiter
	public abstract List<Recruiter> getAllRecruiter();

	// Search Manager By AnyThing | example: id,name,sex... I think you should
	// consult constructor below
	public abstract List<Admin> searchManager(Admin admin); // constructor(username),(name),(phone),(sex)
	// Search Job Seeker By UserName

	public abstract List<JobSeeker> searchJobSeeker(JobSeeker jobseek);

	// Search Recruiter By AnyThing | example:username,company_name,company_phone
	public abstract List<Recruiter> searchRecruiter(Recruiter recruiter);

	// Delete Admin By Username
	public abstract boolean deleteManager(Admin admin);

	// Delete Job Seeker By Username
	public abstract boolean deleteJobSeeker(JobSeeker jobseeker);

	// Delete Recruiter By Username
	public abstract boolean deleteRecruiter(Recruiter recruiter);

	// Delete JobPost By Id
	public abstract boolean deleteJobPost(JobPost jobpost);

	// Statistics Quantity User In Table DataBase User
	public abstract int statisticsUser();

	// Statistics Quantity Job Post By AnyThing In Table DataBase Job Post
	public abstract int statisticsJobpost(); //example: job_name,job_position,location,datetime,username,posts_type

	// Statistics Quantity Admin In Table DataBase Admin
	public abstract int statisticsAdmin();

	// Statistics Quantity Job Seeker In Table DataBase JobSeeker
	public abstract int statisticsJobSeeker();

	// Statistics Quantity Recruiter In Tabale DataBase Recruiter
	public abstract int statisticsRecruiter();
	

}
