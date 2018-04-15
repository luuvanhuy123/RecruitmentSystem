package recruitment.system.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import recruitment.system.entities.Admin;
import recruitment.system.entities.JobPost;
import recruitment.system.function.ManagerPower;
import recruitment.system.function.UserPower;

@Path("/user")
public class ServicesUser extends UserPower {
	public ServicesUser(){
		super();
	}
	@POST
	@Path("/post/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean postJob(@FormParam("job_name") String jobname ,@FormParam("job_position") String job_position,@FormParam("job_description") String job_description
			,@FormParam("job_recruitment") String job_recruitment,@FormParam("salary") String salary, @FormParam("benafit") String benafit, @FormParam("other_inf") String other_inf
			,@FormParam("date")String date, @FormParam("carrer") String carrer, @FormParam("location") String location, @FormParam("username") String username) {
		JobPost jobpost = new JobPost(jobname, job_position, job_description, job_recruitment, salary, benafit, other_inf, date,1, Integer.parseInt(carrer), Integer.parseInt(location), username);
		int key = new UserPower().jobPost(jobpost);
		if(key == 0)
			return false;
		return true;
	}
	@POST
	@Path("/recruiter_history/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public List<JobPost> getRecruiterHistory(@FormParam("username") String username) {
		return new UserPower().getHistoryPost(username);
	}
	
	@POST
	@Path("/listjobposts")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public List<JobPost> getListJobPosts() {
		UserPower listJ=new UserPower();
		return listJ.getAllJobPost();
	}
	
	@GET
	@Path("/downloads/{id}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean downloadsCV(@PathParam("id") String id ){
		if(downloadCV(id)==true){
			return true;
		};
		return false;
	}
	

}
