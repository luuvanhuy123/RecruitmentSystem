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
}
