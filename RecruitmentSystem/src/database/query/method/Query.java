package database.query.method;

public class Query {
	public String selectAll(String table){
		String query="SELECT * FROM "+table;
		return query;
	}
	public String updateTable_byID(String table,String setPosition,String valueUpdate,String where,int id){
		String update="UPDATE "+table+" SET "+setPosition+" = "+valueUpdate+" WHERE "+where +" = " + id;
		return update;
	}
	public String getAllJobPost(){
		return "Select * from job_posts j join recruiter r on j.email = r.email where status  = 0";
	}
	public String getAllManager(){
		return "{Call getAllManager()}";
	}
	public String getAllJobSeeker(){
		return "{Call getAllJobSeeker()}";
	}
	public String getAllRecruiter(){
		return "{Call getAllRecruiter()}";
	}
	public String countUser(){
		return "{Call countUser()}";
	}
	public String deleteAdmin(){
		return "{Call deleteAdmin(?)}";
	}
	public String deleteJobSeeker(){
		return "{Call deleteJobSeeker(?)}";
	}
	public String deleteRecruiter(){
		return "{Call deleteRecruiter(?)}";
	}
	}
