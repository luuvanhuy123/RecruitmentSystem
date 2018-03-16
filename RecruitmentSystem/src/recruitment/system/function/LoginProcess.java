package recruitment.system.function;

import java.sql.ResultSet;

import recruitment.system.entities.Admin;
import recruitment.system.entities.JobSeeker;
import recruitment.system.entities.Recruiter;
import recruitment.system.entities.User;
import recruitment.system.interfaceinf.SignInterface;

public class LoginProcess extends ConnectDataBase implements SignInterface{
	public LoginProcess() {
		super();
	}
	@Override
	public int login(User user) {
		try {
			resultset = statement.executeQuery("select * from user");
			String _username = "";
			String _password = "";
			while(resultset.next()) {
				_username = resultset.getString("username");
				_password = resultset.getString("password");
				if(user.getUsername().equals(_username) && user.getPassword().equals(_password)) {
					ResultSet re = statement.executeQuery("select * from user_role where username = '" + user.getUsername() + "'");
					int roleId = 0;
					while(re.next()) {
						return roleId = re.getInt("roleId");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			finallyConnect();
		}
		return -1;
	}

	@Override
	public boolean signInJob_Seeker(JobSeeker jobSeeker, int type) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean signInRecruiter(Recruiter recruiter, int type) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean signInManager(Admin admin, int type) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
