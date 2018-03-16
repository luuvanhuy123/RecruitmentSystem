package recruitment.system.function;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;


public class ConnectDataBase {
	private final String classname = "com.mysql.jdbc.Driver";
	private final String urlDataBase = "jdbc:mysql://localhost:3306/recruitmentsystem";
	private final String usernameDB = "root";
	private final String passwordDB = "";
	protected Connection connection = null;
	protected Statement statement = null;
	protected ResultSet resultset = null;
	public ConnectDataBase() {
		connect();
	}
	protected void connect() {
		try {
			Class.forName(classname);
			connection = DriverManager.getConnection(urlDataBase,usernameDB,passwordDB);
			statement = connection.createStatement();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void finallyConnect() {
		try {
			if(resultset!=null)
				resultset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(statement !=null)
				statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(connection!=null)
				connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
