package recruitment.system.function;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.query.method.Query;
import recruitment.system.entities.Admin;
import recruitment.system.entities.JobPost;
import recruitment.system.entities.JobSeeker;
import recruitment.system.entities.Recruiter;
import recruitment.system.entities.Role;
import recruitment.system.entities.User;
import recruitment.system.interfaceinf.interfaceManager;

public class ManagerPower extends ConnectDataBase implements interfaceManager {
	Query query = new Query();

	public ManagerPower() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Admin> getAllManager() {
		ArrayList<Admin> listAllManager = new ArrayList<>();
		String queryAdmin = query.selectAll("admin");
		String queryUser = query.selectAll("user");
		String queryUserRole = query.selectAll("user_role");
		String queryRole = query.selectAll("role");
		ResultSet result = null;
		ResultSet r1 = null;
		ResultSet r2 = null;
		ResultSet r3 = null;
		int roleIdTableUser_Role;
		User user = new User();
		Admin manager;
		try {
			result = resultset(queryAdmin);
			r1 = resultset(queryUser);
			r2 = resultset(queryUserRole);
			r3 = resultset(queryRole);
			while (result.next()) {
				String email = result.getString("email");
				String name = result.getString("name");
				String address = result.getString("address");
				String sex = result.getString("sex");
				String phoneNumber = result.getString("phone_number");
				while (r1.next()) {
					String username = r1.getString("username");
					String password = r1.getString("password");
					if (email.equals(username)) {
						user.setUsername(username);
						user.setPassword(password);
					}
					while (r2.next()) {
						roleIdTableUser_Role = r2.getInt("roleid");
						while (r3.next()) {
							int roleIdTableRole = r3.getInt("roleid");
							String roleName = r3.getString("role_name");
							if (roleIdTableUser_Role == roleIdTableRole) {
								Role roles = new Role();
								List<Role> listRoleName = new ArrayList<>();
								roles.setRoleName(roleName);
								listRoleName.add(roles);
								user.setRoles(listRoleName);
							}
						}
					}
					manager = new Admin(email, address, username, phoneNumber, sex, user);
					listAllManager.add(manager);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			finallyConnect(result);
			finallyConnect(r1);
			finallyConnect(r2);
			finallyConnect(r3);
		}
		return listAllManager;
	}

	@Override
	public List<JobSeeker> getAllJobSeeker() {
		List<JobSeeker> listAllJobSeeker = new ArrayList<>();
		String queryJobSeeker = query.selectAll("job_seeker");
		return listAllJobSeeker;
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
