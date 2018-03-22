package recruitment.system.function;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import database.query.method.Query;
import recruitment.system.entities.JobPost;
import recruitment.system.interfaceinf.InterfaceUser;

public class UserPower extends ConnectDataBase implements InterfaceUser{	
		Query query=new Query();
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
	public List<JobPost> searchJobpost(JobPost jobpost) {
		ArrayList<JobPost>listJobPost=new ArrayList<>();
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			finallyConnect(resultset);
		}
		return listJobPost;
	}

	@Override
	public boolean changeStatus_Jobpost(JobPost jobpost) {
		int postsID=Integer.parseInt(jobpost.getPostsId());
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
	private String getNow()
	{
		Date date=new Date();
        SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
        String d=(String)ft.format(date.getTime());
        return d;
	}

}
