package veiw;
import javax.swing.*;

import service.Database;

import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
public class Login extends JFrame {
	static String name;
	static String pass;
	private JLabel lable1;
	private JLabel lable2;
	private JTextField text1;
	private JTextField text2;
	private JButton bt1;
	private JButton bt2;
	private JFrame frame = new JFrame();

	public void run() {
		frame.setSize(500, 400);
		frame.setVisible(true);
		frame.setTitle("ʳƷ����ϵͳ");
		frame.setLayout(null);
		frame.setLocation(700, 300);
		lable1 = new JLabel("�û���");
		lable1.setSize(100, 70);
		lable1.setLocation(100, 80);
		frame.add(lable1);
		lable2 = new JLabel("��    ��");
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

		bt1 = new JButton("��¼");
		bt1.setSize(70, 30);
		bt1.setLocation(140, 195);
		frame.add(bt1);
		bt1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				name = text1.getText();
				pass = text2.getText();
				boolean b = Sure(name, pass);
				if (b == true) {
					JOptionPane.showMessageDialog(null, "��¼�ɹ�,��ѡ������Ҫ�Ĳ���");
					frame.dispose();
					new Choose();
				} else {
					JOptionPane.showMessageDialog(null, "��¼ʧ��,����������");
					frame.dispose();
				}

			}
		});

		bt2 = new JButton("ע��");
		bt2.setSize(70, 30);
		bt2.setLocation(250, 195);
		frame.add(bt2);
		bt2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODOn Auto-generated method stub
				new Register().run();
			}
			
		});
		frame.setBackground(Color.blue);
		// ���õ����رհ�ťʱ��Ĭ�ϲ���
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public boolean Sure(String name2, String pass2) {
		ResultSet rs;
		boolean success = false;
		try {
			Connection util = new Database().connDatabase();
			Statement stmt = util.createStatement();

			rs = stmt.executeQuery("select * from users where username='" + name2 + "' and password='" + pass2 + "'");
			if (rs.next())
				success = true;
			else
				success = false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;
	}

	public static void main(String[] args) {
		new Login().run();
	}
}