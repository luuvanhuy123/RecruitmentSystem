package recruitment.system.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import recruitment.system.function.ManagerPower;
import recruitment.system.entities.Admin;
import recruitment.system.entities.JobSeeker;
import recruitment.system.entities.Recruiter;

@Path("/manager")
public class ServicesManager extends ManagerPower {
	public ServicesManager() {
		super();
	}
	
	@POST
	@Path("/listmanagers")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Admin> getListManagers() {
		return getAllManager();
	}
	@POST
	@Path("/listjobseekers")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public List<JobSeeker> getListJobSeekers() {
		return getAllJobSeeker();
	}
	@POST
	@Path("/listrecruiters")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Recruiter> getListRecruiters() {
		return getAllRecruiter();
	}
	
	
}
