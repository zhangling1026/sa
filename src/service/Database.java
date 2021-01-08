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
	private String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";   //����JDBC����  
	private String dbURL = "jdbc:sqlserver://localhost:1433; DatabaseName=test";   //���ӷ����������ݿ�sample  
	private String userName = "sa";   //��¼�û���  
	private String userPassword = "123456";   //��¼����  
	public Database(){
	}
	public Connection connDatabase(){
		try{
			Class.forName(driverName); 
			conn=DriverManager.getConnection(dbURL,userName,userPassword);
		}
		catch(Exception e){ 
			System.err.println("����ʧ��:"+e.getMessage());
		}
		return conn;
	}
	
	//�ر������ݿ�����
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
