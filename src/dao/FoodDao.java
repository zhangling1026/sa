package dao;

import java.util.List;

import poji.FoodPoji;

public interface FoodDao {
	//ʳƷ���
public boolean add(FoodPoji food);
	
	
	
	public FoodPoji comparename(String name);
	 
	// �޸�ʳƷ
	public boolean update(FoodPoji food);
	
	//ɾ��ʳƷ
	public boolean delete(int id);
	public FoodPoji compare(int id);
	
}
