package recruitment.system.function;

import java.sql.ResultSet;

import database.query.method.Query;
import recruitment.system.entities.Admin;
import recruitment.system.entities.JobSeeker;
import recruitment.system.entities.Recruiter;
import recruitment.system.entities.User;
import recruitment.system.interfaceinf.SignInterface;

public class LoginProcess extends ConnectDataBase implements SignInterface{
	Query query;
	public LoginProcess() {
		super();
	}
	@Override
	public int login(User user) {
		query=new Query();
		try {
			resultset=resultset(query.selectAll("user"));
			String _username = "";
			String _password = "";
			while(resultset.next()) {
				_username = resultset.getString("username");
				_password = resultset.getString("password");
				if(user.getUsername().equals(_username) && user.getPassword().equals(_password)) {
					ResultSet re = statement.executeQuery("select * from user where username = '" + user.getUsername() + "'");
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
			finallyConnect(resultset);
		}
		return -1;
	}


	@Override
	public boolean signInJob_Seeker(JobSeeker jobSeeker) {
		query=new Query();
		try {
			resultset=resultset(query.selectAll("user"));
			while(resultset.next()) {
				if(resultset.getString("username").equals(jobSeeker.getEmail()))
					return false;
				else {
					statement.executeUpdate("insert into user values ('" + jobSeeker.getEmail() + "','" + jobSeeker.getUser().getPassword()+"')");
					statement.executeUpdate("insert into user_role values ('"+ jobSeeker.getEmail() + "',3)");
					statement.executeUpdate("insert into job_seeker (email,name) values ('"+jobSeeker.getEmail() + "','" + jobSeeker.getName() +"')");
					return true;
					}
				}
			statement.executeUpdate("insert into user values ('" + jobSeeker.getEmail() + "','" + jobSeeker.getUser().getPassword()+"')");
			statement.executeUpdate("insert into user_role values ('"+ jobSeeker.getEmail() + "',3)");
			statement.executeUpdate("insert into job_seeker (email,name) values ('"+jobSeeker.getEmail() + "','" + jobSeeker.getName() +"')");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			finallyConnect(resultset);
		}
		return false;
	}
	@Override
	public boolean signInRecruiter(Recruiter recruiter) {
		query=new Query();
		String username = recruiter.getEmail();
		String password = recruiter.getUser().getPassword();
		String name = recruiter.getName();
		String sex = recruiter.getSex();
		String address = recruiter.getAddress();
		String company_name = recruiter.getCompanyName();
		String company_address = recruiter.getCompanyAddress();
		String company_phone = recruiter.getCompanyPhone();
		String company_information = recruiter.getCompanyInformation();
		try {
			resultset=resultset(query.selectAll("user"));
			while(resultset.next()) {
				if(resultset.getString("username").equals(username))
					return false;
				else {
					statement.executeUpdate("insert into user values ('" + username + "','" + password+"')");
					statement.executeUpdate("insert into user_role values ('"+ username + "',4)");
					statement.executeUpdate("insert into recruiter values ('"+username + "','" + name +"','" + sex + "','" + address +"','" + company_name + "','"  + company_phone+"','" + company_information + "','"+ company_address + "')");
					return true;
					}
				}
			statement.executeUpdate("insert into user values ('" + username + "','" + password+"')");
			statement.executeUpdate("insert into user_role values ('"+ username + "',4)");
			statement.executeUpdate("insert into recruiter values ('"+username + "','" + name +"','" + sex + "','" + address +"','" + company_name + "','"  + company_phone+"','" + company_information + "','"+ company_address + "')");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			finallyConnect(resultset);
		}
		return false;
	}
	@Override
	public boolean signInManager(Admin admin) {
		query=new Query();
		String username = admin.getEmail();
		String password = admin.getUser().getPassword();
		String name = admin.getName();
		String sex = admin.getSex();
		String address = admin.getAddress();
		String phone_number = admin.getPhoneNumber();
		try {
			resultset=resultset(query.selectAll("user"));
			while(resultset.next()) {
				if(resultset.getString("username").equals(username))
					return false;
				else {
					statement.executeUpdate("insert into user values ('" + username + "','" + password+"')");
					statement.executeUpdate("insert into user_role values ('"+ username + "',1)");
					statement.executeUpdate("insert into admin values ('"+username + "','" + name +"','" + sex + "','" + address +"','" + phone_number + "')");
					return true;
					}
				}
			statement.executeUpdate("insert into user values ('" + username + "','" + password+"')");
			statement.executeUpdate("insert into user_role values ('"+ username + "',1)");
			statement.executeUpdate("insert into admin values ('"+username + "','" + name +"','" + sex + "','" + address +"','" + phone_number + "')");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			finallyConnect(resultset);
		}
		return false;
	}

	
}
