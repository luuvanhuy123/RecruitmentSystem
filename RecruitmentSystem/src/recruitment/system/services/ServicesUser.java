package recruitment.system.services;

import java.util.List;

import javax.ws.rs.Consumes;
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
