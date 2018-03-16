package recruitment.system.interfaceinf;

import java.util.List;

import recruitment.system.entities.JobPost;

public interface InterfaceUser {
	//create new jobPost
	public abstract boolean jobPost(JobPost jobpost);//constructor full
	//Search JobPost By AnyThing | example: id,date,location... you can consult constructor below
	public abstract List<JobPost>searchJobpost(JobPost jobpost); //constructor(id),(date),(location),(position),(job_name),(job_name,job_positon,location)
	//Change Status Of JobPost And Update DateTime 
	public abstract boolean changeStatus_Jobpost(JobPost jobpost);//constructor(id);
}
