package recruitment.system.test;
import recruitment.system.function.*;

import java.util.List;

import javax.enterprise.inject.New;

import recruitment.system.entities.*;
public class Main {

	public static void main(String[] args) {
		
//		 test functions of interface signinterface
//		JobSeeker jobSeeker = new JobSeeker("tuanTk","Tran Khanh Tuan", new User("khanhtuan623@gmail.com", "123"));
//		Recruiter recruiter = new Recruiter("recruiter", "recruiter", "abc", "xyz", "oop","main","ok","F", new User("admin","123"));
//		Admin admin = new Admin("admin", "q7", "tuan", "tuantk", "F", new User("admin", "admin"));
//		if(new LoginProcess().signInJob_Seeker(jobSeeker)==true)
//			System.out.println("jobseeker::true");
//		else
//			System.out.println("jobseeker::false");
//		if(new LoginProcess().signInRecruiter(recruiter)==true)
//			System.out.println("recruiter::true");
//		else
//			System.out.println("recruiter::false");
//		if(new LoginProcess().signInManager(admin)==true)
//			System.out.println("admin::true");
//		else
//			System.out.println("admin::false");
//		System.out.println("=================================================");
//		System.out.println(new LoginProcess().login(new User("admin","admin")));
//		System.out.println(new LoginProcess().login(new User("huyluu","huyluu")));
//		System.out.println(new LoginProcess().login(new User("luuvanhuy123@gmail.com","123")));
//		System.out.println(new LoginProcess().login(new User("0","0")));
//		new LoginProcess().signInManager(admin);
		 //end test functions of interface signinterface
//		/*Test function change Status jobpost*/
//		UserPower user=new UserPower();
//		JobPost jp=new JobPost("1",(byte)8);
//		System.out.println(user.changeStatus_Jobpost(jp));
////		/*test function get All List Admin,JobSeeker,Recruiter*/
//		System.out.println(new ManagerPower().getAllManager());
//		System.out.println(new ManagerPower().getAllJobSeeker());
//		System.out.println(new ManagerPower().getAllRecruiter());
		
//		Admin admin=new Admin();
//		admin.setEmail("admin");
//		System.out.println(new ManagerPower().searchManager(admin));
//
//		JobSeeker jp1=new JobSeeker();
//		jp1.setEmail("tuanTk");
//		System.out.println(new ManagerPower().searchJobSeeker(jp1));
//		Recruiter r1=new Recruiter();
//		r1.setEmail("recruiter");
//		System.out.println(new ManagerPower().searchRecruiter(r1));
//		admin.setEmail("khanhtuan623@gmail.com");
//		System.out.println(new ManagerPower().statisticsUser());
//		System.out.println(new ManagerPower().statisticsAdmin());
//		System.out.println(new ManagerPower().statisticsJobSeeker());
//		System.out.println(new ManagerPower().statisticsRecruiter());
//		System.out.println(new ManagerPower().deleteManager(admin));
//		JobSeeker job=new JobSeeker();
//		job.setEmail("khanhtuan623@gmail.com");
//		System.out.println(new ManagerPower().deleteJobSeeker(job));
//		Recruiter re=new Recruiter();
//		re.setEmail("tt");
//		System.out.println(new ManagerPower().deleteRecruiter(re));
//		JobSeeker jp=new JobSeeker();
//		String email="tuanTk";
//		System.out.println(new UserPower().downloadCV(email));
//		List<JobPostInf> l = new UserPower().getAllJobPost();
//		for(JobPostInf p : l) {
//			System.out.println(p);
//		}
////		SearchJob jp=new SearchJob();
////		jp.setJobName("TT");
////		jp.setLocation(1);
////		jp.setCareer(1);
////		System.out.println(jp.toString());
////		System.out.println(new UserPower().searchJobpost(jp));
////		System.out.println(new UserPower().searchJobpost(jp).size());
//		System.out.println(new UserPower().jobPost(new JobPost("java", "develop", "back-end", "java ee", "10tr - 20tr",
//				"thoa thuan", "none", "208", 0,1, 1,"admin")));
		//System.out.println(new UserPower().registryJobPost("admin", 4));
		System.out.println(new ManagerPower().statisticsRecruiter());
		System.out.println(new ManagerPower().statisticsAdmin());
		System.out.println(new ManagerPower().statisticsJobSeeker());
		System.out.println(new ManagerPower().statisticsUser());
	}

}
