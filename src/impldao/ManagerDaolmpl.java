package impldao;

import java.sql.Connection;

import poji.FoodPoji;
import poji.ManagerPoji;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import dao.ManagerDao;
import poji.ManagerPoji;
import service.Database;
import impldao.ManagerDaolmpl;


public class ManagerDaolmpl implements ManagerDao {
	//连接数据库
	
	
	 public boolean Sure(String name2,String pass2) {
		 Connection util = new Database().connDatabase();
			ResultSet rs;
		boolean success=false;
		try {
			Statement stmt=util.createStatement();
			rs=stmt.executeQuery("select * from user where username="+name2+" and password="+pass2);
			if(rs.next())
				success=true;
			else
				success=false;
		}catch(SQLException e) {
			e.printStackTrace();
		}		
return success;
	}
	// 连接数据库
}