package veiw;

import javax.swing.*;

import service.Database;

import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Register extends JFrame {
	// 标签
	static String nameRe;
	static String passwordRe;
	PreparedStatement stmt;
	private JLabel lable1;
	private JLabel lable2;
	// 文本框
	private JTextField text1;
	private JTextField text2;
	// 按钮
	private JButton bt1;
	private JButton bt2;
	private JFrame frame = new JFrame("食品管理系统");

	public void run() {
		frame.setSize(500, 400);
		frame.setVisible(true);
		frame.setTitle("注册界面");
		frame.setLayout(null);
		frame.setLocation(700, 300);

		lable1 = new JLabel("输入姓名");
		lable1.setSize(100, 70);
		lable1.setLocation(100, 80);
		frame.add(lable1);
		lable2 = new JLabel("输入密码 ");
		lable2.setSize(100, 70);
		lable2.setLocation(100, 130);
		frame.add(lable2);

		text1 = new JTextField();
		text1.setSize(150, 30);
		text1.setLocation(160, 100);
		frame.add(text1);
		text2 = new JTextField();
		text2.setSize(150, 30);
		text2.setLocation(160, 150);
		frame.add(text2);

		bt1 = new JButton("注册");
		bt1.setSize(70, 30);
		bt1.setLocation(140, 195);
		bt1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				nameRe = text1.getText();
				passwordRe = text2.getText();
				Database util = new Database();
				try {
					stmt = util.connDatabase().prepareStatement("insert into user values(?,?");
					stmt.setString(1, nameRe);
					stmt.setString(2, passwordRe);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				boolean m = new Login().Sure(nameRe, passwordRe);
				if (m == true) {
					JOptionPane.showMessageDialog(null, "该用户已注册,");
					frame.dispose();
					new Register().run();
				} else {
					try {
						stmt.executeUpdate();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "该用户注册成功");
					frame.dispose();
				}

			}

		});
		frame.add(bt1);
		bt2 = new JButton("退出");
		bt2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Login().run();
				JOptionPane.showMessageDialog(null, "退出注册");
			}
			
		});
		bt2.setSize(70, 30);
		bt2.setLocation(250, 195);
		frame.add(bt2);
		frame.setBackground(Color.blue);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Register().run();
	}
}
