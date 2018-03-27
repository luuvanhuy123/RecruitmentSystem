package recruitment.system.function;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Id;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Blob;

import database.query.method.Query;
import recruitment.system.entities.Admin;
import recruitment.system.entities.Career;
import recruitment.system.entities.JobPost;
import recruitment.system.entities.JobSeeker;
import recruitment.system.entities.Role;
import recruitment.system.entities.User;
import recruitment.system.interfaceinf.InterfaceUser;

public class UserPower extends ConnectDataBase implements InterfaceUser{	
		Query query=new Query();
		List<JobPost>listAllJobPost;
	public UserPower() {
		super();
	}
	@Override
	public boolean jobPost(JobPost jobpost) {
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			finallyConnect(resultset);
		}
		return false;
	}
	@Override
	public List<JobPost> getAllJobPost() {
		listAllJobPost=new ArrayList<>();
		query = new Query();
		ArrayList<Career> listCareer = null;
		String  jobName, jobPosition, jobDescription, jobRecruitment, salary, benefit, otherInformation,location,postDate,postsType,username,careerName;
		int postsId,postsStatus,careerId;
		try {
			resultset = callableStatement(query.getAllJobPost());
			while (resultset.next()) {
				postsId=resultset.getInt("posts_id");
				jobName = resultset.getString("job_name");
				jobPosition = resultset.getString("job_position");
				jobDescription = resultset.getString("job_description");
				jobRecruitment = resultset.getString("job_recruitment");
				salary = resultset.getString("salary");
				benefit = resultset.getString("benefit");
				otherInformation = resultset.getString("other_information");
				location = resultset.getString("location");
				postDate = resultset.getString("post_date");
				postsType=resultset.getString("posts_type");
				postsStatus=resultset.getInt("posts_status");
				username=resultset.getString("username");
				careerId=resultset.getInt("careerId");
				careerName=resultset.getString("career_name");
				
				User user=new User();
				user.setUsername(username);
				Career career = new Career(careerId,careerName);
				listCareer = new ArrayList<>();
				listCareer.add(career);
				
				JobPost jPost = new JobPost(postsId,benefit, jobDescription, jobName, jobPosition, jobRecruitment, location, otherInformation, postDate, postsStatus, postsType, salary, user, listCareer);
				listAllJobPost.add(jPost);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			finallyConnect(resultset);
		}
		return listAllJobPost;
	}
	@Override
	public List<JobPost> searchJobpost(JobPost jobpost) {
		return null;
		
	}

	@Override
	public boolean changeStatus_Jobpost(JobPost jobpost) {
		int postsID=jobpost.getPostsId();
		int newStatus=jobpost.getPostsStatus();
		String queryTableJobpost=query.selectAll("job_posts");
		ResultSet resultSet=null;
		try {
			resultSet=resultset(queryTableJobpost);
			while(resultset.next()){
			int postsIDdatabase=resultset.getInt("posts_id");
			if(postsID==postsIDdatabase){
			String updateStatus="UPDATE job_posts SET posts_status ="+newStatus+" WHERE posts_id =" + postsID;
			String updateDate="UPDATE job_posts SET post_date ='"+getNow()+"' WHERE posts_id =" + postsID;
			statement.executeUpdate(updateStatus);
			statement.executeUpdate(updateDate);
			return true;
			}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			finallyConnect(resultset);
		}
		return false;
	}
	
	@Override
	public boolean downloadCV(String IdJobseeker) {
		query=new Query();
		String home = System.getProperty("user.home");
		File file=new File(home+"/Downloads/"+IdJobseeker+"-CV");
		try {
			resultset=preparedStatement(query.selectAll("job_seeker"));
			while(resultset.next()){
				String emailDatabase=resultset.getString("email");
				Blob cv=resultset.getBlob("CV");
				if(IdJobseeker.equals(emailDatabase)){
					byte[]b=cv.getBytes(1, (int) cv.length());
					FileOutputStream fos=new FileOutputStream(file);
					fos.write(b);
					fos.close();
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			finallyConnect(resultset);
		}
		return false;
	}
	private String getNow()
	{
		Date date=new Date();
        SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
        String d=(String)ft.format(date.getTime());
        return d;
	}
	
}
