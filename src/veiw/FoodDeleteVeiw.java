package veiw;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import impldao.FoodDaolmpl;
import impldao.FoodDaolmpl;
import poji.FoodPoji;
//查找食品
public class FoodDeleteVeiw {
	// 创建
	JFrame frame = new JFrame("删除食品信息");

	public void run() {

		frame.getContentPane().setBackground(Color.WHITE);
		
		frame.setSize(450, 400);
		Point point = new Point(300, 200);
		frame.setLocation(point);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		frame.add(panel);
		panel.setLayout(null);// 布局分布
		Font fnt = new Font("宋体", Font.BOLD, 13);
		Font fnt1 = new Font("宋体", Font.ITALIC, 13);

		JLabel tips = new JLabel("请输入要删除的食品编号!");
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

		
		JButton del = new JButton("删除");
		del.setBounds(200, 150, 70, 25);
		del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String num= numtext.getText();
			int n=Integer.parseInt(num);
			boolean foodrt = new FoodDaolmpl().delete(n);
			
				JOptionPane.showMessageDialog(null, "删除成功");
			
			}
		});

		panel.add(del);
		panel.setBackground(Color.LIGHT_GRAY);

	}
	public static void main(String[] args) {
		new FoodDeleteVeiw().run();
	}

}
