package recruitment.system.function;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import recruitment.system.entities.Career;
import recruitment.system.entities.JobPost;
import recruitment.system.entities.RecruiteregistrationHistory;
import recruitment.system.interfaceinf.InterfaceUser;

public class UserPower extends ConnectDataBase implements InterfaceUser{

	public UserPower() {
		super();
	}
	@Override
	public boolean jobPost(JobPost jobpost) {
		
		return false;
	}

	@Override
	public List<JobPost> searchJobpost(JobPost jobpost) {
		ArrayList<JobPost>listJobPost=new ArrayList<>();
		ArrayList<Career>listCareer=new ArrayList<>();
		ArrayList<RecruiteregistrationHistory>listRecruiterregistrationHistory=new ArrayList<>();
		try {
			/*Query Table Job Post And Get Data*/
			resultset = statement.executeQuery("select * from job_posts");
			String postsId=resultset.getString("posts_id");
			String jobName=resultset.getString("job_name");
			String benefit=resultset.getString("benefit");
			String jobDescription=resultset.getString("job_description");
			String jobPosition=resultset.getString("job_position");
			String jobRecruitment=resultset.getString("job_recruitment");
			String location=resultset.getString("location");
			String otherInformation=resultset.getString("other_information");
			String post_date=resultset.getString("post_date");
			byte postsStatus=resultset.getByte("posts_status");
			String postsType=resultset.getString("posts_type");
			String salary=resultset.getString("salary");
			int carrer=resultset.getInt("carrer");
			String username=resultset.getString("username");
			/*Query Table Career And Get Data*/
			ResultSet queryCarrer=statement.executeQuery("select * from carrer");
			int careerID=queryCarrer.getInt("careerId");
			String careerName=queryCarrer.getString("career_name");
			Career car=new Career();
			car.setCareerName(careerName);
			while(queryCarrer.next()){
				if(carrer==careerID){
					listCareer.add(car);
				}
			}
			/*Query Table RecruiterregistrationHistory*/
			ResultSet queryRecruiterregistrationHistory=statement.executeQuery("select * from recruiterregistration_history");
			int postIDInHistory=queryRecruiterregistrationHistory.getInt("posts_id");
			String noties=queryRecruiterregistrationHistory.getString("noties");
			String status=queryRecruiterregistrationHistory.getString("status");
			int type=queryRecruiterregistrationHistory.getInt("type");
			RecruiteregistrationHistory history=new RecruiteregistrationHistory(noties, status, type);
			while(queryRecruiterregistrationHistory.next()){
				if(postsId.equals(postIDInHistory)){
					listRecruiterregistrationHistory.add(history);
				}
			}
//			JobPost jp=new JobPost(postsId, benefit, jobDescription, jobName, jobPosition, jobRecruitment, location, otherInformation, post_date, postsStatus, postsType, salary, username, listCareer, listRecruiterregistrationHistory);
			while(resultset.next()) {
				if(jobpost.getUser().getUsername().equals(username)) {
//					listJobPost.add(jp);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			finallyConnect();
		}
		return listJobPost;
	}

	@Override
	public boolean changeStatus_Jobpost(JobPost jobpost) {
		int postsID=Integer.parseInt(jobpost.getPostsId());
		int newStatus=jobpost.getPostsStatus();
		try {
			resultset=statement.executeQuery("select * from job_posts");
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			finallyConnect();
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
