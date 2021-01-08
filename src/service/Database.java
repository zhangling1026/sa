package service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
	private Connection conn=null;
	private PreparedStatement stmt=null;
	private ResultSet rs=null;
	private String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";   //加载JDBC驱动  
	private String dbURL = "jdbc:sqlserver://localhost:1433; DatabaseName=test";   //连接服务器和数据库sample  
	private String userName = "sa";   //登录用户名  
	private String userPassword = "123456";   //登录密码  
	public Database(){
	}
	public Connection connDatabase(){
		try{
			Class.forName(driverName); 
			conn=DriverManager.getConnection(dbURL,userName,userPassword);
		}
		catch(Exception e){ 
			System.err.println("连接失败:"+e.getMessage());
		}
		return conn;
	}
	
	//关闭与数据库连接
	public void closeConn(){
		if(conn != null) {
			try{
			conn.close();
			}
			catch(SQLException ex){
			ex.printStackTrace();
			}
		}
		if(rs != null) {
			try{
			rs.close();
			}
			catch(SQLException ex){
			ex.printStackTrace();
			}
		}
		if(stmt != null) {
			try{
			stmt.close();
			}
			catch(SQLException ex){
			ex.printStackTrace();
			}
		}
	}}
