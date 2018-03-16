package recruitment.system.interfaceinf;

import recruitment.system.entities.Admin;
import recruitment.system.entities.JobSeeker;
import recruitment.system.entities.Recruiter;
import recruitment.system.entities.User;

public interface SignInterface {
	//Check Login Website
	public abstract int login(User user);
	//Create New Account Of Job Seeker
	public abstract boolean signInJob_Seeker(JobSeeker jobSeeker);
	//Create New Account Of Recruiter
	public abstract boolean signInRecruiter(Recruiter recruiter);
	//Create New Account Of Manager
	public abstract boolean signInManager(Admin admin);//I think you should move this abtracts methor to interface manager
}
