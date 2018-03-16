package recruitment.function.test;

import recruitment.system.entities.Admin;
import recruitment.system.entities.User;
import recruitment.system.function.LoginProcess;

public class Test {
public static void main(String[] args) {
	LoginProcess test=new LoginProcess();
	User user=new User("khanhtuan623@gmail.com", "123456");
//	Admin admin=new Admin("khanhtuan623@gmail.com","District 7","TKT","0961655697","M",user);
//	System.out.println(test.signInManager(admin));
	System.out.println(test.login(user));
}
}
