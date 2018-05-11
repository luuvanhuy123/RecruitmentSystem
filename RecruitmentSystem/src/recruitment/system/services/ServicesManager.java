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
public class ServicesManager  {
	public ServicesManager() {
		super();
	}

	@POST
	@Path("/listmanagers")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Admin> getListManagers() {
		ManagerPower listM=new ManagerPower();
		return listM.getAllManager();
	}

	@POST
	@Path("/listjobseekers")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public List<JobSeeker> getListJobSeekers() {
		ManagerPower listJ=new ManagerPower();
		return listJ.getAllJobSeeker();
	}

	@POST
	@Path("/listrecruiters")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Recruiter> getListRecruiters() {
		ManagerPower listR=new  ManagerPower();
		return listR.getAllRecruiter();
	}
	
	@POST
	@Path("/statisticsRecruiter")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public int statisticsRecruiter() {
		ManagerPower listR=new  ManagerPower();
		return listR.statisticsRecruiter();
	}
	@POST
	@Path("/statisticsAdmin")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public int statisticsAdmin() {
		ManagerPower listR=new  ManagerPower();
		return listR.statisticsAdmin();
	}
	@POST
	@Path("/statisticsJobSeeker")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public int statisticsJobSeeker() {
		ManagerPower listR=new  ManagerPower();
		return listR.statisticsJobSeeker();
	}
	@POST
	@Path("/statisticsUser")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public int statisticsUser() {
		ManagerPower listR=new  ManagerPower();
		return listR.statisticsUser();
	}
}
