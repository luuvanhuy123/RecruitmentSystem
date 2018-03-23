package recruitment.system.function;

import java.sql.DriverManager;
import java.sql.ResultSet;

import recruitment.system.entities.Admin;

import java.sql.*;


public class ConnectDataBase {
	private final String classname = "com.mysql.jdbc.Driver";
	private final String urlDataBase = "jdbc:mysql://localhost:3306/recruitmentsystem";
	private final String usernameDB = "root";
	private final String passwordDB = "";
	protected Connection connection = null;
	protected Statement statement = null;
	protected ResultSet resultset = null;
	protected CallableStatement callableStatement=null;
	public ConnectDataBase() {
		connect();
	}
	protected void connect() {
		try {
			Class.forName(classname);
			connection = DriverManager.getConnection(urlDataBase,usernameDB,passwordDB);
//			statement = connection.createStatement();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected ResultSet resultset(String sql){
		try {
			statement = connection.createStatement();
			resultset=statement.executeQuery(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return resultset;
	}
	protected ResultSet callableStatement(String sql){
		try {
			callableStatement=connection.prepareCall(sql);
			resultset=callableStatement.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return resultset;
		
	}
	protected ResultSet callableStatementDelete(String sql,String id){
		try {
			callableStatement=connection.prepareCall(sql);
			callableStatement.setString(1,id);
			resultset=callableStatement.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return resultset;
		
	}
	protected void finallyConnect(ResultSet resultset) {
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
