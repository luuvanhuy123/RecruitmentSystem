package recruitment.system.services;

import java.util.List;
import recruitment.system.function.*;
import recruitment.system.entities.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import recruitment.system.entities.Admin;

@Path("/services")
public class Services {
	@POST
	@Path("/login/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public int login(@FormParam("username") String username, @FormParam("password") String password) {
		return new LoginProcess().login(new User(username,password));
	}
	@POST
	@Path("/regsistryJobseeker/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean RegistryJobseeker(@FormParam("username") String username, @FormParam("password") String password , @FormParam("name") String name) {
		JobSeeker j = new JobSeeker(username, name, new User(username, password));
		if(new LoginProcess().signInJob_Seeker(j) == true)
			return true;
		return false;
	}
}
