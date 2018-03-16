package recruitment.system.function;

import java.sql.ResultSet;

public class LoginProcess extends ConnectDataBase{
	public LoginProcess() {
		super();
	}
	public int Login(String username, String password) {
		try {
			resultset = statement.executeQuery("select * from user");
			String _username = "";
			String _password = "";
			while(resultset.next()) {
				_username = resultset.getString("username");
				_password = resultset.getString("password");
				if(username.equals(_username) && password.equals(_password)) {
					ResultSet re = statement.executeQuery("select * from user_role where username = '" + username + "'");
					int roleId = 0;
					while(re.next()) {
						return roleId = re.getInt("roleId");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			finallyConnect();
		}
		return -1;
	}
}
