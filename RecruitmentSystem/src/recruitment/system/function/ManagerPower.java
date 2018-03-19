package recruitment.system.function;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
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
		ArrayList<Role> listRoles = null;
		String query = "SELECT admin.email, admin.name, admin.sex, admin.address, admin.phone_number, USER.username, USER.password, user_role.roleid, role.role_name FROM admin, USER, user_role, role WHERE admin.email = USER.username AND USER.username = user_role.username AND user_role.roleid = role.roleId";
		String email = null;
		String name = null;
		String address = null;
		String sex = null;
		String phoneNumber = null;
		String username = null;
		String password = null;
		int roleId;
		String roleName;
		int i;
		ResultSet resultSet = null;
		try {
			resultSet = resultset(query);
			while (resultSet.next()) {
				email = resultSet.getString("email");
				name = resultSet.getString("name");
				sex = resultSet.getString("sex");
				address = resultSet.getString("address");
				phoneNumber = resultSet.getString("phone_number");
				username = resultSet.getString("username");
				password = resultSet.getString("password");
				roleName = resultSet.getString("role_name");
				roleId = resultSet.getInt("roleid");
				Role roleList = new Role(roleId, roleName);
				listRoles = new ArrayList<>();
				listRoles.add(roleList);
				User user = new User(username, password, listRoles);
				for (i = 0; i < listAllManager.size(); i++) {
					if (listAllManager.get(i).getEmail().equals(email)) {
						if(listAllManager.get(i).getUser().getRoles().size()<2){
							 Role roleAdd = new Role(listAllManager.get(i).getUser().getRoles().get(i).getRoleId(),listAllManager.get(i).getUser().getRoles().get(i).getRoleName());
							listRoles.add(roleAdd);
						}
						else{
							for(int j=listAllManager.get(i).getUser().getRoles().size()-1;j>=0;j--){
								Role roleAdd = new Role(listAllManager.get(i).getUser().getRoles().get(j).getRoleId(),listAllManager.get(i).getUser().getRoles().get(j).getRoleName());
								listRoles.add(roleAdd);
							}
						}
						listAllManager.remove(i);

					}

				}
				Admin manager = new Admin(email, address, name, phoneNumber, sex, user);
				listAllManager.add(manager);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			finallyConnect(resultSet);
			// finallyConnect(r1);
			// finallyConnect(r2);
			// finallyConnect(r3);
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
		return getAllManager().size();
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
