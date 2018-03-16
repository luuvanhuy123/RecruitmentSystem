package recruitment.system.interfaceinf;

import recruitment.system.entities.Admin;
import recruitment.system.entities.JobSeeker;
import recruitment.system.entities.Recruiter;
import recruitment.system.entities.User;

public interface SignInterface {
	int login(User user);
	boolean signInJob_Seeker(JobSeeker jobSeeker,String password,int type);
	boolean signInRecruiter(Recruiter recruiter,String password,int type);
	boolean signInManager(Admin admin,String password,int type);
}
