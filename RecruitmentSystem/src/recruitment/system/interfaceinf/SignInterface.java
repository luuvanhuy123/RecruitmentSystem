package recruitment.system.interfaceinf;

import recruitment.system.entities.Admin;
import recruitment.system.entities.JobSeeker;
import recruitment.system.entities.Recruiter;
import recruitment.system.entities.User;

public interface SignInterface {
	int login(User user);
	boolean signInJob_Seeker(JobSeeker jobSeeker);
	boolean signInRecruiter(Recruiter recruiter);
	boolean signInManager(Admin admin);
}
