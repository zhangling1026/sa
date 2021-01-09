package veiw;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import impldao.FoodDaolmpl;
import poji.FoodPoji;

public class FoodUpdateVeiw {
	JFrame frame = new JFrame("食品信息修改");

	public void run() {

		// 设置窗体颜色
		frame.getContentPane().setBackground(Color.WHITE);
		// 设置窗体高度
		frame.setSize(450, 400);
		// 设置窗体位置，距离显示屏的位置
		Point point = new Point(300, 200);
		frame.setLocation(point);
		// 设置窗体可见性
		frame.setVisible(true);
		// 单击窗口的关闭按钮时执行
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		// 生成一个面板
		JPanel panel = new JPanel();
		frame.add(panel);
		FoodVeiw(panel);
	}
	private void FoodVeiw(JPanel panel) {
		panel.setLayout(null);// 布局分布
		Font fnt = new Font("宋体", Font.BOLD, 13);
		Font fnt1 = new Font("宋体",Font.ITALIC,13);
		
		//提示信息
		JLabel tips = new JLabel("请输入要操作的食品编号！");
		tips.setBounds(150,20,200,25);
		panel.add(tips);
		tips.setFont(fnt1);
		// 食品编号
		JLabel numlab = new JLabel("食品编号：");
		numlab.setBounds(80, 50, 70, 25);
		panel.add(numlab);
		numlab.setFont(fnt);

		JTextField numtext = new JTextField();
		numtext.setBounds(150, 50, 170, 25);
		panel.add(numtext);

		// 食品名
		JLabel namelab = new JLabel("食品名：");
		namelab.setBounds(80, 100, 60, 25);
		panel.add(namelab);
		namelab.setFont(fnt);

		JTextField nametext = new JTextField();
		nametext.setBounds(150, 100, 200, 25);
		panel.add(nametext);

		// 食品类型
		JLabel typelab = new JLabel("食品类型：");
		typelab.setBounds(80, 150, 70, 25);
		panel.add(typelab);
		typelab.setFont(fnt);

		JTextField typetext = new JTextField();
		typetext.setBounds(150, 150, 200, 25);
		panel.add(typetext);

		// 食品价格
		JLabel pricelab = new JLabel("食品价格：");
		pricelab.setBounds(80, 200, 70, 25);
		panel.add(pricelab);
		pricelab.setFont(fnt);

		JTextField pricetext = new JTextField();
		pricetext.setBounds(150, 200, 200, 25);
		panel.add(pricetext);

		// 食品库存
		JLabel numberlab = new JLabel("食品库存：");
		numberlab.setBounds(80, 250, 70, 25);
		panel.add(numberlab);
		numberlab.setFont(fnt);

		JTextField numbertext = new JTextField();
		numbertext.setBounds(150, 250, 200, 25);
		panel.add(numbertext);
		
		//确认要修改的食品编号
		JButton apply1 = new JButton("确定");
		apply1.setBounds(330, 50, 60, 25);
		apply1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int id = Integer.parseInt(numtext.getText());
				FoodPoji foodrt = new FoodDaolmpl().compare(id);
				if(foodrt != null) {
					nametext.setText(foodrt.getName());
					pricetext.setText(String.valueOf(foodrt.getPrice()));
					typetext.setText(foodrt.getType());
					numbertext.setText(String.valueOf(foodrt.getNumber()));
					JOptionPane.showMessageDialog(null, "已找到该食品,请开始修改！");
				}
			}
			
		});
		JButton apply = new JButton("修改");
		apply.setBounds(300, 290, 60, 25);
		apply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						FoodPoji food = new FoodPoji();
						food.setFoodid(Integer.parseInt(numtext.getText()));
						food.setName(nametext.getText());
						float prices =Float.parseFloat(pricetext.getText());
						System.out.println(pricetext.getText());
					
						food.setPrice(prices);
						food.setType(typetext.getText());
						String nums =numbertext.getText();
					
						food.setNumber(Integer.parseInt(nums));
						
						boolean a=new FoodDaolmpl().update(food);
						if(a) {
							JOptionPane.showMessageDialog(null, "修改食品信息成功");
						}else {
							JOptionPane.showMessageDialog(null, "修改食品信息失败");
						}
			}
			
			
		

	});
	panel.add(apply1);
	panel.add(apply);
	panel.setBackground(Color.LIGHT_GRAY);

}
						
	public static void main(String[] args) {
		new FoodUpdateVeiw().run();
	}


	
}

