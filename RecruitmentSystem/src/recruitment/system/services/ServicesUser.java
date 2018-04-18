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
import recruitment.system.entities.JobPostInf;
import recruitment.system.entities.JobseekerHis;
import recruitment.system.function.ManagerPower;
import recruitment.system.function.SearchJob;
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
	@Path("/jobdetail")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public JobPostInf jobDetail(@FormParam("postformId") String postid) {
		System.out.println(postid);
		UserPower listJ=new UserPower();
		return listJ.jobDetail(Integer.parseInt(postid));
	}
	@POST
	@Path("/registryJobpost")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean registryJobPost(@FormParam("postId") String postid,@FormParam("username") String username) {
		System.out.println(postid + username);
		UserPower listJ=new UserPower();
		return listJ.registryJobPost(username, Integer.parseInt(postid));
	}
	@POST
	@Path("/seach")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public List<JobPostInf> seacher(@FormParam("carrer") String carrer, @FormParam("dist") String dist, @FormParam("findbox") String findbox) {
		UserPower listJ=new UserPower();
		System.out.println(carrer + "---" + dist + "---" + findbox);
		return listJ.searchJobpost(new SearchJob(findbox,Integer.parseInt(carrer),Integer.parseInt(dist)));
	}
	@POST
	@Path("/joobseekerhis")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public List<JobseekerHis> jobseekerhis(@FormParam("username") String username) {
		UserPower listJ=new UserPower();
		return listJ.getHistoryRegis(username);
	}
	@POST
	@Path("/adminconfirm")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public List<JobPostInf> jobseekerhis() {
		UserPower listJ=new UserPower();
		return listJ.getListJobConfirm();
	}
	@POST
	@Path("/confirm")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean confirm(@FormParam("username") String username, @FormParam("postId") String postid) {
		UserPower listJ=new UserPower();
		return listJ.confirm(Integer.parseInt(postid), username);
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
