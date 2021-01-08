package veiw;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import impldao.FoodDaolmpl;
import impldao.FoodDaolmpl;
import poji.FoodPoji;
//查找食品
public class FoodAddVeiw {
	JFrame frame = new JFrame("增加食品信息");
	public void run() {

		frame.getContentPane().setBackground(Color.WHITE);
		
		frame.setSize(450, 400);
		Point point = new Point(300, 200);
		frame.setLocation(point);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		JPanel panel = new JPanel();
		frame.add(panel);
		FindView(panel);
		panel.setBackground(Color.LIGHT_GRAY);
	}

	private void FindView(JPanel panel) {
		panel.setLayout(null);// 布局分布
		Font fnt = new Font("宋体", Font.BOLD, 13);
		Font fnt1 = new Font("宋体", Font.ITALIC, 13);

		JLabel tips = new JLabel("请输入要增加的食品信息！");
		tips.setBounds(150, 20, 200, 25);
		panel.add(tips);
		tips.setFont(fnt1);

		JLabel numlab = new JLabel("食品编号：");
		numlab.setBounds(80, 100, 70, 25);
		panel.add(numlab);
		numlab.setFont(fnt);

		JTextField numtext = new JTextField();
		numtext.setBounds(150, 100, 200, 25);
		panel.add(numtext);

		// 食品名
		JLabel namelab = new JLabel("食品名：");
		namelab.setBounds(80, 50, 70, 25);
		panel.add(namelab);
		namelab.setFont(fnt);

		JTextField nametext = new JTextField();
		nametext.setBounds(150, 50, 170, 25);
		panel.add(nametext);

		// 食品类型
		JLabel typelab = new JLabel("食品类型：");
		typelab.setBounds(80, 150, 70, 25);
		panel.add(typelab);
		typelab.setFont(fnt);

		JTextField typetext = new JTextField();
		typetext.setBounds(150, 150, 200, 25);
		panel.add(typetext);
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

		JButton apply1 = new JButton("增加");
		apply1.setBounds(330, 50, 60, 25);
		apply1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FoodPoji food = new FoodPoji();
				food.setFoodid(Integer.parseInt(numtext.getText()));
				food.setName(nametext.getText());
				food.setPrice(Float.parseFloat(pricetext.getText()));
				food.setType(typetext.getText());
				food.setNumber(Integer.parseInt(numbertext.getText()));
				
				boolean a=new FoodDaolmpl().add(food);
				if(a) {
					JOptionPane.showMessageDialog(null, "增加信息成功");
				}else {
					JOptionPane.showMessageDialog(null, "增加信息失败");
				}
				
				
			}

		});
		panel.add(apply1);
		panel.setBackground(Color.LIGHT_GRAY);

	}
	public static void main(String[] args) {
		new FoodAddVeiw().run();
	}

}
