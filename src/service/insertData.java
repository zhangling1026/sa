package service;
import impldao.FoodDaolmpl;
import poji.FoodPoji;

//����һ��������
public class insertData {
	public void run() {
		for (int i = 0; i < 1000; i++) {
			FoodPoji food = new FoodPoji();
			food.setFoodid(1000 + i);
			food.setName("ƻ��" + i);
			food.setNumber(190);
			food.setPrice(Float.parseFloat("10.0"));
			food.setType("�߹���");
			new FoodDaolmpl().add(food);
		}
		for (int i = 0; i < 1000; i++) {
			FoodPoji food = new FoodPoji();
			food.setFoodid(2000 + i);
			food.setName("����" + i);
			food.setNumber(180);
			food.setPrice(Float.parseFloat("35.0"));
			food.setType("�����");
			new FoodDaolmpl().add(food);
			
		}
		for (int i = 0; i < 2000; i++) {
			FoodPoji food = new FoodPoji();
			food.setFoodid(3000 + i);
			food.setName("�㽶" + i);
			food.setNumber(190);
			food.setPrice(Float.parseFloat("9.9"));
			food.setType("�߹���");
			new FoodDaolmpl().add(food);
			
		}
		for (int i = 0; i < 2000; i++) {
			FoodPoji food = new FoodPoji();
			food.setFoodid(5000 + i);
			food.setName("С�ײ�" + i);
			food.setNumber(190);
			food.setPrice(Float.parseFloat("3.5"));
			food.setType("�߹���");
			new FoodDaolmpl().add(food);
			
		}
		for (int i = 0; i < 2000; i++) {
			FoodPoji food = new FoodPoji();
			food.setFoodid(7000 + i);
			food.setName("����" + i);
			food.setNumber(190);
			food.setPrice(Float.parseFloat("10.0"));
			food.setType("��Ʒ��");
			new FoodDaolmpl().add(food);
			
		}
		for (int i = 0; i < 1000; i++) {
			FoodPoji food = new FoodPoji();
			food.setFoodid(9000 + i);
			food.setName("С��" + i);
			food.setNumber(190);
			food.setPrice(Float.parseFloat("55.0"));
			food.setType("��ʳ��");
			new FoodDaolmpl().add(food);
			
		}
	}
	public static void main(String[] args) {
		new insertData().run();
	}

}
