package recruitment.system.interfaceinf;

import recruitment.system.entities.Admin;
import recruitment.system.entities.JobSeeker;
import recruitment.system.entities.Recruiter;
import recruitment.system.entities.User;

public interface SignInterface {
	int login(User user);
	boolean signInJob_Seeker(JobSeeker jobSeeker,int type);
	boolean signInRecruiter(Recruiter recruiter,int type);
	boolean signInManager(Admin admin,int type);
}
