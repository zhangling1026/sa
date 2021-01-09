package dao;

import java.util.List;

import poji.FoodPoji;

public interface FoodDao {
	//食品添加
public boolean add(FoodPoji food);
	
	
	
	public FoodPoji comparename(String name);
	 
	// 修改食品
	public boolean update(FoodPoji food);
	
	//删除食品
	public boolean delete(int id);
	public FoodPoji compare(int id);
	
}
