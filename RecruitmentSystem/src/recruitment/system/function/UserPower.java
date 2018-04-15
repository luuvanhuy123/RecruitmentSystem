package recruitment.system.function;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import database.query.method.Query;
import recruitment.system.entities.JobPost;
import recruitment.system.entities.Recruiter;
import recruitment.system.entities.RecruiterHi;
import recruitment.system.entities.User;
import recruitment.system.interfaceinf.InterfaceUser;

public class UserPower extends ConnectDataBase implements InterfaceUser {
	Query query = new Query();
	private List<JobPost> listAllJobPost;
	private List<JobPost> listSearchJobpost;

	public UserPower() {
		super();
	}

	@Override
	public int jobPost(JobPost jobpost) {
		try {
			PreparedStatement ps = null;
			String sql = "INSERT INTO job_posts"
					+ "(job_name, job_position, job_description,job_recruitment,"
					+ "salary,benafit,other_infor,date,status,carrerid,locationid,email) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, jobpost.getJobName());
			ps.setString(2, jobpost.getJobPosition());
			ps.setString(3, jobpost.getJobDescription());
			ps.setString(4, jobpost.getJobRecruitment());
			ps.setString(5, jobpost.getSalary());
			ps.setString(6, jobpost.getBenefit());
			ps.setString(7, jobpost.getOtherInfor());
			ps.setString(8, jobpost.getDate());
			ps.setInt(9, jobpost.getStatus());
			ps.setInt(10, jobpost.getCareerid());
			ps.setInt(11, jobpost.getLocationid());
			ps.setString(12, jobpost.getUsername());
			ps.execute();
			resultset = ps.getGeneratedKeys();
			int key = 0;
			if(resultset.next())
				key = resultset.getInt(1);
			return key;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			finallyConnect(resultset);
		}
		return 0;
	}

	@Override
	public List<JobPost> getAllJobPost() {
		listAllJobPost = new ArrayList<>();
		query = new Query();
		String jobName, jobPosition, jobDescription, jobRecruitment, salary, benefit, otherInformation, postDate,
				companyName, username, companyAddress, companyPhone;
		int postsId, postsStatus, careerId, location;
		try {
			resultset = callableStatement(query.getAllJobPost());
			while (resultset.next()) {
				postsId = resultset.getInt("posts_id");
				jobName = resultset.getString("job_name");
				jobPosition = resultset.getString("job_position");
				jobDescription = resultset.getString("job_description");
				jobRecruitment = resultset.getString("job_recruitment");
				salary = resultset.getString("salary");
				benefit = resultset.getString("benefit");
				otherInformation = resultset.getString("other_infor");
				location = resultset.getInt("locationid");
				postDate = resultset.getString("date");
				companyName = resultset.getString("company_name");
				companyAddress = resultset.getString("company_address");
				companyPhone = resultset.getString("company_phone");
				postsStatus = resultset.getInt("status");
				username = resultset.getString("email");
				careerId = resultset.getInt("careerid");
				Recruiter recruiter = new Recruiter();
				recruiter.setEmail(username);
				recruiter.setCompanyAddress(companyAddress);
				recruiter.setCompanyName(companyName);
				recruiter.setCompanyPhone(companyPhone);
				RecruiterHi reHis = new RecruiterHi(postsStatus, recruiter);
				ArrayList<RecruiterHi> listRe = new ArrayList<>();
				listRe.add(reHis);
				JobPost jPost = new JobPost(postsId, benefit, careerId, postDate, jobDescription, jobName, jobPosition,
						jobRecruitment, location, otherInformation, salary, listRe);
				listAllJobPost.add(jPost);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			finallyConnect(resultset);
		}
		return this.listAllJobPost;
	}

	@Override
	public List<JobPost> searchJobpost(SearchJob jobpost) {
		this.getAllJobPost();
		listSearchJobpost = new ArrayList<JobPost>();
		try {
			if (jobpost.getJobName() == null) {
				for (int i = 0; i <listAllJobPost.size(); i++) {
					if (listAllJobPost.get(i).getCareerid() == jobpost.getCareer()&&listAllJobPost.get(i).getLocationid()==jobpost.getLocation()) {
						listSearchJobpost.add(listAllJobPost.get(i));
					}
					else if(listAllJobPost.get(i).getCareerid() == jobpost.getCareer() && jobpost.getLocation()==0){
						listSearchJobpost.add(listAllJobPost.get(i));
					}
					else if(jobpost.getCareer()==0&&listAllJobPost.get(i).getLocationid()==jobpost.getLocation()){
						listSearchJobpost.add(listAllJobPost.get(i));
					}
				}
			}
			else{
				for(int i=0;i<listAllJobPost.size();i++){
					if(jobpost.getJobName().equals(listAllJobPost.get(i).getJobName())){
						if(jobpost.getCareer()==0 && jobpost.getLocation()==listAllJobPost.get(i).getLocationid()){
							listSearchJobpost.add(listAllJobPost.get(i));	
						}
						else if(jobpost.getCareer()==listAllJobPost.get(i).getCareerid()&&jobpost.getLocation()==0){
							listSearchJobpost.add(listAllJobPost.get(i));
						}
						else if(jobpost.getCareer()==0&&jobpost.getLocation()==0){
							listSearchJobpost.add(listAllJobPost.get(i));
						}
						else if(jobpost.getCareer()==listAllJobPost.get(i).getCareerid()&&jobpost.getLocation()==listAllJobPost.get(i).getLocationid()){
							listSearchJobpost.add(listAllJobPost.get(i));
						}
					}
					else{
						if (listAllJobPost.get(i).getCareerid() == jobpost.getCareer() && listAllJobPost.get(i).getLocationid()==jobpost.getLocation()) {
							listSearchJobpost.add(listAllJobPost.get(i));
						}
						else if(listAllJobPost.get(i).getCareerid() == jobpost.getCareer() && jobpost.getLocation()==0){
							listSearchJobpost.add(listAllJobPost.get(i));
						}
						else if(jobpost.getCareer()==0 && listAllJobPost.get(i).getLocationid()==jobpost.getLocation()){
							listSearchJobpost.add(listAllJobPost.get(i));
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

		}
		return listSearchJobpost;

	}

	@Override
	public boolean changeStatus_Jobpost(JobPost jobpost) {
		// int postsID = jobpost.getPostsId();
		// int newStatus = jobpost.getStatus();
		// String queryTableJobpost = query.selectAll("job_posts");
		// ResultSet resultSet = null;
		// try {
		// resultSet = resultset(queryTableJobpost);
		// while (resultset.next()) {
		// int postsIDdatabase = resultset.getInt("posts_id");
		// if (postsID == postsIDdatabase) {
		// String updateStatus = "UPDATE job_posts SET posts_status =" +
		// newStatus + " WHERE posts_id ="
		// + postsID;
		// String updateDate = "UPDATE job_posts SET post_date ='" + getNow() +
		// "' WHERE posts_id =" + postsID;
		// statement.executeUpdate(updateStatus);
		// statement.executeUpdate(updateDate);
		// return true;
		// }
		// }
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } finally {
		// finallyConnect(resultset);
		// }
		return false;
	}

	@Override
	public boolean downloadCV(String IdJobseeker) {
		query = new Query();
		String home = System.getProperty("user.home");
		File file = new File(home + "/Downloads/" + IdJobseeker + "-CV");
		try {
			resultset = preparedStatement(query.selectAll("job_seeker"));
			while (resultset.next()) {
				String emailDatabase = resultset.getString("email");
				Blob cv = resultset.getBlob("CV");
				if (IdJobseeker.equals(emailDatabase)) {
					byte[] b = cv.getBytes(1, (int) cv.length());
					FileOutputStream fos = new FileOutputStream(file);
					fos.write(b);
					fos.close();
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			finallyConnect(resultset);
		}
		return false;
	}

	private String getNow() {
		Date date = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
		String d = (String) ft.format(date.getTime());
		return d;
	}

	@Override
	public boolean registryJobPost(String email, int potsid) {
		String test = "SELECT * FROM jobseeker_his WHERE email = '" + email +"' AND postsid = " +potsid ;
		String sql = "INSERT INTO jobseeker_his(email,postid,status) VALUES('" + email + "'," + potsid + ",'DANG DUYET')" ;
		try {
			resultset = resultset(test);
			if(resultset != null)
				return false;
			executeUpdate(sql);
		}
		catch (Exception e) {
		}
		finally {
			finallyConnect(resultset);
		}
		return true;
	}

	@Override
	public List<JobPost> getHistoryPost(String username) {
		// TODO Auto-generated method stub
		List<JobPost> list = new ArrayList<>();
		String jobName, jobPosition, jobDescription, jobRecruitment, salary, benefit, otherInformation, postDate;
		int postsId, postsStatus, careerId, location;
		String sql = "SELECT * FROM job_posts where email = '" + username +"'";
		resultset = resultset(sql);
		try {
			while(resultset.next()) {
				postsId = resultset.getInt("posts_id");
				jobName = resultset.getString("job_name");
				jobPosition = resultset.getString("job_position");
				jobDescription = resultset.getString("job_description");
				jobRecruitment = resultset.getString("job_recruitment");
				salary = resultset.getString("salary");
				benefit = resultset.getString("benafit");
				otherInformation = resultset.getString("other_infor");
				location = resultset.getInt("locationid");
				postDate = resultset.getString("date");
				postsStatus = resultset.getInt("status");
				username = resultset.getString("email");
				careerId = resultset.getInt("carrerid");
				list.add(new JobPost(postsId, jobName, jobPosition, jobDescription, jobRecruitment, salary
						, benefit, otherInformation, postDate, postsStatus, careerId,username));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
