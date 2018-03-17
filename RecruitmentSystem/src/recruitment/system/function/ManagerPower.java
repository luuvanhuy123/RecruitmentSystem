package recruitment.system.function;

import java.util.List;

import recruitment.system.entities.Admin;
import recruitment.system.entities.JobPost;
import recruitment.system.entities.JobSeeker;
import recruitment.system.entities.Recruiter;
import recruitment.system.interfaceinf.interfaceManager;

public class ManagerPower extends ConnectDataBase implements interfaceManager {

	@Override
	public List<Admin> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobSeeker> getAllJobSeeker() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Recruiter> getAllRecruiter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Admin> searchManager(Admin admin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobSeeker> searchJobSeeker(JobSeeker jobseek) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Recruiter> searchRecruiter(Recruiter recruiter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteManager(Admin admin) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteJobSeeker(JobSeeker jobseeker) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteRecruiter(Recruiter recruiter) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteJobPost(JobPost jobpost) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int statisticsUser() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int statisticsJobpost(JobPost jobpost) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int statisticsAdmin() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int statisticsJobSeeker() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int statisticsRecruiter() {
		// TODO Auto-generated method stub
		return 0;
	}

}
