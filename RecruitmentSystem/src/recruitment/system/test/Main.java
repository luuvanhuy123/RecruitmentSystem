package recruitment.system.test;
import recruitment.system.function.*;
import recruitment.system.entities.*;
public class Main {

	public static void main(String[] args) {
		
		 //test functions of interface signinterface
//		JobSeeker jobSeeker = new JobSeeker("luuvanhuy123@gmail.com","luu van huy", new User("luuvanhuy123@gmail.com", "123"));
//		Recruiter recruiter = new Recruiter("admin", "admin", "admin", "admin", "admin","admin","admin","F", new User("admin","admin"));
//		Admin admin = new Admin("tuantran", "q7", "tuan", "tuantk", "F", new User("tuantk", "00123"));
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
//		UserPower user=new UserPower();
//		JobPost jp=new JobPost("1",(byte)8);
//		System.out.println(user.changeStatus_Jobpost(jp));
		ManagerPower mn=new ManagerPower();
		System.out.println(mn.getAllManager());
		//System.out.println(mn.statisticsAdmin());
	}

}
