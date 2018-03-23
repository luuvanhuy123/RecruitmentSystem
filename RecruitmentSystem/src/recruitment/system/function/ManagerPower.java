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
	List<Admin> listAllManager;
	List<JobSeeker> listAllJobSeeker;
	ArrayList<Recruiter> listAllRecruiter;
	List<Admin> listSearchManagerAdmin;
	Query query;

	public ManagerPower() {
		super();
	}

	@Override
	public List<Admin> getAllManager() {
		listAllManager = new ArrayList<Admin>();
		query = new Query();
		ArrayList<Role> listRoles = null;
		String email, name, address, sex, phoneNumber, username, password, roleName;
		int roleId;
		try {
			resultset = callableStatement(query.getAllManager());
			while (resultset.next()) {
				email = resultset.getString("email");
				name = resultset.getString("name");
				sex = resultset.getString("sex");
				address = resultset.getString("address");
				phoneNumber = resultset.getString("phone_number");
				username = resultset.getString("username");
				password = resultset.getString("password");
				roleName = resultset.getString("role_name");
				roleId = resultset.getInt("roleid");
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
			finallyConnect(resultset);
		}
		return listAllManager;
	}

	@Override
	public List<JobSeeker> getAllJobSeeker() {
		listAllJobSeeker = new ArrayList<JobSeeker>();
		query = new Query();
		String username, name, password;
		try {
			resultset = callableStatement(query.getAllJobSeeker());
			while (resultset.next()) {
				username = resultset.getString("email");
				name = resultset.getString("name");
				password = resultset.getString("password");
				User user = new User();
				user.setPassword(password);
				JobSeeker js = new JobSeeker(username, name, user);
				listAllJobSeeker.add(js);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			finallyConnect(resultset);
		}
		return listAllJobSeeker;
	}

	@Override
	public List<Recruiter> getAllRecruiter() {
		listAllRecruiter = new ArrayList<Recruiter>();
		query = new Query();
		String name, sex, address, companyName, companyPhone, companyInfo, companyAddress, username, password;
		try {
			resultset = callableStatement(query.getAllRecruiter());
			while (resultset.next()) {
				name = resultset.getString("name");
				sex = resultset.getString("sex");
				address = resultset.getString("address");
				companyName = resultset.getString("company_name");
				companyPhone = resultset.getString("company_phone");
				companyInfo = resultset.getString("company_information");
				companyAddress = resultset.getString("company_address");
				username = resultset.getString("username");
				password = resultset.getString("password");
				User user = new User(username, password);
				Recruiter recruiter = new Recruiter(address, companyAddress, companyInfo, companyName, companyPhone,
						username, sex, user);
				listAllRecruiter.add(recruiter);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			finallyConnect(resultset);
		}
		return listAllRecruiter;
	}

	@Override
	public List<Admin> searchManager(Admin admin) {
		this.getAllManager();
		listSearchManagerAdmin = new ArrayList<>();
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
		this.getAllJobSeeker();
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
		this.getAllRecruiter();
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
		query = new Query();
		String email=admin.getEmail();
		try {
			resultset=callableStatementDelete(query.deleteAdmin(), email);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			finallyConnect(resultset);
		}
		return false;
	}

	@Override
	public boolean deleteJobSeeker(JobSeeker jobseeker) {
		query = new Query();
		String email=jobseeker.getEmail();
		try {
			resultset=callableStatementDelete(query.deleteJobSeeker(), email);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			finallyConnect(resultset);
		}
		return false;
	}

	@Override
	public boolean deleteRecruiter(Recruiter recruiter) {
		query = new Query();
		String email=recruiter.getEmail();
		try {
			resultset=callableStatementDelete(query.deleteRecruiter(), email);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			finallyConnect(resultset);
		}
		return false;
	}

	@Override
	public boolean deleteJobPost(JobPost jobpost) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int statisticsUser() {
		query = new Query();
		int count = 0;
		try {
			resultset = callableStatement(query.countUser());
			while (resultset.next()) {
				count = resultset.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			finallyConnect(resultset);
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
		this.getAllManager();
		return listAllManager.size();
	}

	@Override
	public int statisticsJobSeeker() {
		this.getAllJobSeeker();
		return listAllJobSeeker.size();
	}

	@Override
	public int statisticsRecruiter() {
		this.getAllRecruiter();
		return listAllRecruiter.size();
	}

}
