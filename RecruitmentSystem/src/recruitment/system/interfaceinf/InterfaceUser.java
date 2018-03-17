package recruitment.system.interfaceinf;

import java.util.ArrayList;

import recruitment.system.entities.JobPost;

public interface InterfaceUser {
	boolean jobPosts(JobPost jobPost);
	ArrayList<JobPost> getListRecruitment(int type);
}
