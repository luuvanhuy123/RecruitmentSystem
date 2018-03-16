package recruitment.system.function;

import java.util.List;

import recruitment.system.entities.JobPost;
import recruitment.system.interfaceinf.InterfaceUser;

public class UserPower extends ConnectDataBase implements InterfaceUser{

	@Override
	public boolean jobPost(JobPost jobpost) {
		
		return false;
	}

	@Override
	public List<JobPost> searchJobpost(JobPost jobpost) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean changeStatus_Jobpost(JobPost jobpost) {
		// TODO Auto-generated method stub
		return false;
	}

}
