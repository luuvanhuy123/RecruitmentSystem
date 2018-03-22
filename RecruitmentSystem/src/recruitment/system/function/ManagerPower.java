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
	ArrayList<Admin> listAllManager = new ArrayList<Admin>();;
	ArrayList<JobSeeker> listAllJobSeeker = new ArrayList<JobSeeker>();
	ArrayList<Recruiter> listAllRecruiter = new ArrayList<Recruiter>();;
	Query query = new Query();

	public ManagerPower() {
		super();
	}

	@Override
	public List<Admin> getAllManager() {
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
		ResultSet resultSetM = null;
		try {
			resultSetM = resultset(query);
			while (resultSetM.next()) {
				email = resultSetM.getString("email");
				name = resultSetM.getString("name");
				sex = resultSetM.getString("sex");
				address = resultSetM.getString("address");
				phoneNumber = resultSetM.getString("phone_number");
				username = resultSetM.getString("username");
				password = resultSetM.getString("password");
				roleName = resultSetM.getString("role_name");
				roleId = resultSetM.getInt("roleid");
				Role roleList = new Role(roleId, roleName);
				listRoles = new ArrayList<>();
				listRoles.add(roleList);
				User user = new User(username, password, listRoles);
				for (int i = 0; i < listAllManager.size(); i++) {
					if (listAllManager.get(i).getEmail().equals(email)) {
						if (listAllManager.get(i).getUser().getRoles().size() < 2) {
							Role roleAdd = new Role(listAllManager.get(i).getUser().getRoles().get(i).getRoleId(),
									listAllManager.get(i).getUser().getRoles().get(i).getRoleName());
							listRoles.add(roleAdd);
						} else {
							for (int j = listAllManager.get(i).getUser().getRoles().size() - 1; j >= 0; j--) {
								Role roleAdd = new Role(listAllManager.get(i).getUser().getRoles().get(j).getRoleId(),
										listAllManager.get(i).getUser().getRoles().get(j).getRoleName());
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
			finallyConnect(resultSetM);
		}
		return listAllManager;
	}

	@Override
	public List<JobSeeker> getAllJobSeeker() {
		String queryJobSeeker = "SELECT  job_seeker.email,job_seeker.name, job_seeker.CV, USER.password FROM job_seeker, USER WHERE job_seeker.email = USER.username";
		String username, name, password;
		ResultSet resultSetJS = null;
		try {
			resultSetJS = resultset(queryJobSeeker);
			while (resultSetJS.next()) {
				username = resultSetJS.getString("email");
				name = resultSetJS.getString("name");
				password = resultSetJS.getString("password");
				User user = new User();
				user.setPassword(password);
				JobSeeker js = new JobSeeker(username, name, user);
				listAllJobSeeker.add(js);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			finallyConnect(resultSetJS);
		}
		return listAllJobSeeker;
	}

	@Override
	public List<Recruiter> getAllRecruiter() {
		String queryRecruiter = "SELECT recruiter.name, recruiter.sex, recruiter.address, recruiter.company_name, recruiter.company_phone, recruiter.company_information, recruiter.company_address, USER.password,USER.username FROM recruiter, USER WHERE recruiter.email = USER.username";
		String name, sex, address, companyName, companyPhone, companyInfo, companyAddress, username, password;
		ResultSet resultSetR = null;
		try {
			resultSetR = resultset(queryRecruiter);
			while (resultSetR.next()) {
				name = resultSetR.getString("name");
				sex = resultSetR.getString("sex");
				address = resultSetR.getString("address");
				companyName = resultSetR.getString("company_name");
				companyPhone = resultSetR.getString("company_phone");
				companyInfo = resultSetR.getString("company_information");
				companyAddress = resultSetR.getString("company_address");
				username = resultSetR.getString("username");
				password = resultSetR.getString("password");
				User user = new User(username, password);
				Recruiter recruiter = new Recruiter(address, companyAddress, companyInfo, companyName, companyPhone,
						username, sex, user);
				listAllRecruiter.add(recruiter);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			finallyConnect(resultSetR);
		}
		return listAllRecruiter;
	}

	@Override
	public List<Admin> searchManager(Admin admin) {
		getAllManager();
		List<Admin> listSearchManagerAdmin = new ArrayList<>();
		try {
			for (int i = 0; i < listAllManager.size(); i++) {
				if (listAllManager.get(i).getEmail().equals(admin.getEmail())) {
					listSearchManagerAdmin.add(listAllManager.get(i));
				} else if (listAllManager.get(i).getAddress().equals(admin.getAddress())) {
					listSearchManagerAdmin.add(listAllManager.get(i));
				} else if (listAllManager.get(i).getName().equals(admin.getName())) {
					listSearchManagerAdmin.add(listAllManager.get(i));
				} else if (listAllManager.get(i).getSex().equals(admin.getSex())) {
					listSearchManagerAdmin.add(listAllManager.get(i));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listSearchManagerAdmin;
	}

	@Override
	public List<JobSeeker> searchJobSeeker(JobSeeker jobseek) {
		getAllJobSeeker();
		List<JobSeeker> listSearchJobSeeker = new ArrayList<>();
		try {
			for (int i = 0; i < listAllJobSeeker.size(); i++) {
				if (listAllJobSeeker.get(i).getName().equals(jobseek.getName())) {
					listSearchJobSeeker.add(listAllJobSeeker.get(i));
				} else if (listAllJobSeeker.get(i).getEmail().equals(jobseek.getEmail())) {
					listSearchJobSeeker.add(listAllJobSeeker.get(i));
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listSearchJobSeeker;
	}

	@Override
	public List<Recruiter> searchRecruiter(Recruiter recruiter) {
		getAllRecruiter();
		List<Recruiter> listSearchRecruiter = new ArrayList<>();
		try {
			for (int i = 0; i < listAllRecruiter.size(); i++) {
				if (listAllRecruiter.get(i).getEmail().equals(recruiter.getEmail())) {
					listAllRecruiter.add(listAllRecruiter.get(i));
				} else if (listAllRecruiter.get(i).getName().equals(recruiter.getName())) {
					listSearchRecruiter.add(listSearchRecruiter.get(i));
				} else if (listAllRecruiter.get(i).getAddress().equals(recruiter.getAddress())) {
					listSearchRecruiter.add(listSearchRecruiter.get(i));
				} else if (listAllRecruiter.get(i).getCompanyAddress().equals(recruiter.getCompanyAddress())) {
					listSearchRecruiter.add(listSearchRecruiter.get(i));
				} else if (listAllRecruiter.get(i).getCompanyName().equals(recruiter.getCompanyName())) {
					listSearchRecruiter.add(listSearchRecruiter.get(i));
				} else if (listAllRecruiter.get(i).getCompanyPhone().equals(recruiter.getCompanyPhone())) {
					listSearchRecruiter.add(listSearchRecruiter.get(i));
				} else if (listAllRecruiter.get(i).getSex().equals(recruiter.getSex())) {
					listSearchRecruiter.add(listSearchRecruiter.get(i));
				} else if (listAllRecruiter.get(i).getCompanyInformation().equals(recruiter.getCompanyInformation())) {
					listSearchRecruiter.add(listSearchRecruiter.get(i));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listSearchRecruiter;
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
		String queryCount = "SELECT COUNT(*) FROM user";
		int count = 0;
		ResultSet resultSetCount = null;
		try {
			resultSetCount = resultset(queryCount);
			while (resultSetCount.next()) {
				count = resultSetCount.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return count;
	}

	
	@Override
	public int statisticsJobpost(JobPost jobpost) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	@Override
	public int statisticsAdmin() {
		getAllManager();
		return listAllManager.size();
	}

	
	@Override
	public int statisticsJobSeeker() {
		getAllJobSeeker();
		return listAllJobSeeker.size();
	}

	
	@Override
	public int statisticsRecruiter() {
		getAllRecruiter();
		return listAllRecruiter.size();
	}

}
