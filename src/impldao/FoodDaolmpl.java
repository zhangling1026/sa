package impldao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import dao.FoodDao;
import poji.FoodPoji;
import service.Database;

public class FoodDaolmpl implements FoodDao {
	// 连接数据库
	Connection util = new Database().connDatabase();

	// 添加食品
	
	public boolean add(FoodPoji food) {
		// TODO Auto-generated method stub
		String insert = "insert into food(fid,fname,ftype,fprice,fnumber)values(?,?,?,?,?)";
		PreparedStatement stmt=null;
		try {
			 stmt = util.prepareStatement(insert);
			stmt.setInt(1, food.getFoodid());
			stmt.setString(2, food.getName());
			stmt.setString(3, food.getType());
			stmt.setFloat(4, food.getPrice());
			stmt.setInt(5, food.getNumber());
			int row=stmt.executeUpdate();
			if(row>0) {
				return true;
			}
			
			

		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			try {
				stmt.close();
				util.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	return false;
		
	}


	// 修改食品
	@Override
	public boolean update(FoodPoji food) {
		// TODO Auto-generated method stub
		String update = "update food set fname=?,ftype=?,fprice=?,fnumber=? where fid=?";
		PreparedStatement stmt=null;
		try {
			stmt = util.prepareStatement(update);
			stmt.setInt(1, food.getFoodid());
			stmt.setString(2, food.getName());
			stmt.setString(3, food.getType());
			stmt.setFloat(4, food.getPrice());
			stmt.setString(5, food.getType());
			int row=stmt.executeUpdate();
			if(row>0) {
				return true;
			}
			
			

		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			try {
				stmt.close();
				util.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	return false;
		
	}



	// 通过食品编号查找

	public boolean delete(int m) {
		// TODO Auto-generated method stub
		String del = "delete from food where fid=?";
		try {
			// 获取PreparedStatement
			PreparedStatement stmt = util.prepareStatement(del);
			// 填充占位符
			stmt.setInt(1, m);
			// 执行数据库
			stmt.execute();
			stmt.close();
			util.close();
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return false;

	}
	@Override
	public FoodPoji comparename(String name) {
		// TODO Auto-generated method stub
		FoodPoji foodrt = null;
		String sql = "select * from food where fname='" + name + "'";
		ResultSet rs;
		Statement stmt = null;
		try {
			stmt = util.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				foodrt = new FoodPoji();
				foodrt.setName(rs.getString("fname"));
				foodrt.setFoodid(rs.getInt("fid"));
				foodrt.setPrice(rs.getFloat("fprice"));
				foodrt.setType(rs.getString("ftype"));
				foodrt.setNumber(rs.getInt("fnumber"));

			} else {
				JOptionPane.showInternalMessageDialog(null, "食品不存在，请重新输入！");
			}
			rs.close();
			stmt.close();
			util.close();

		} catch (

		SQLException e) {
			e.printStackTrace();
		}
		return foodrt;
	}


}
	