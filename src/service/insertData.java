package service;
import impldao.FoodDaolmpl;
import poji.FoodPoji;

//生成一万条数据
public class insertData {
	public void run() {
		for (int i = 0; i < 1000; i++) {
			FoodPoji food = new FoodPoji();
			food.setFoodid(1000 + i);
			food.setName("苹果" + i);
			food.setNumber(190);
			food.setPrice(Float.parseFloat("10.0"));
			food.setType("蔬果类");
			new FoodDaolmpl().add(food);
		}
		for (int i = 0; i < 1000; i++) {
			FoodPoji food = new FoodPoji();
			food.setFoodid(2000 + i);
			food.setName("核桃" + i);
			food.setNumber(180);
			food.setPrice(Float.parseFloat("35.0"));
			food.setType("坚果类");
			new FoodDaolmpl().add(food);
			
		}
		for (int i = 0; i < 2000; i++) {
			FoodPoji food = new FoodPoji();
			food.setFoodid(3000 + i);
			food.setName("香蕉" + i);
			food.setNumber(190);
			food.setPrice(Float.parseFloat("9.9"));
			food.setType("蔬果类");
			new FoodDaolmpl().add(food);
			
		}
		for (int i = 0; i < 2000; i++) {
			FoodPoji food = new FoodPoji();
			food.setFoodid(5000 + i);
			food.setName("小白菜" + i);
			food.setNumber(190);
			food.setPrice(Float.parseFloat("3.5"));
			food.setType("蔬果类");
			new FoodDaolmpl().add(food);
			
		}
		for (int i = 0; i < 2000; i++) {
			FoodPoji food = new FoodPoji();
			food.setFoodid(7000 + i);
			food.setName("酸奶" + i);
			food.setNumber(190);
			food.setPrice(Float.parseFloat("10.0"));
			food.setType("饮品类");
			new FoodDaolmpl().add(food);
			
		}
		for (int i = 0; i < 1000; i++) {
			FoodPoji food = new FoodPoji();
			food.setFoodid(9000 + i);
			food.setName("小麦" + i);
			food.setNumber(190);
			food.setPrice(Float.parseFloat("55.0"));
			food.setType("主食类");
			new FoodDaolmpl().add(food);
			
		}
	}
	public static void main(String[] args) {
		new insertData().run();
	}

}
