package veiw;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Choose extends JFrame {
	JButton bt1;
	JButton bt2;
	JButton bt3;
	JButton bt4;
	JPanel panel;
	JPanel panel2;
	JLabel label;
	Choose() {
		this.setSize(900, 700);
		this.setTitle("��ѡ������Ҫ�Ĳ���");
		this.setLayout(null);
		this.setLocation(400, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bt1 = new JButton("��ѯʳƷ��Ϣ");
		bt1.setSize(150, 50);
		bt1.setLocation(150, 400);
		bt1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new FoodFindVeiw().run();
			}
			
		});
		
		bt2 = new JButton("ɾ��ʳƷ��Ϣ");
		bt2.setSize(150, 50);
		bt2.setLocation(150, 500);
		bt2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new FoodDeleteVeiw().run();
			}
			
		});
		
		

		bt3 = new JButton("���ʳƷ��Ϣ");
		bt3.setSize(150, 50);
		bt3.setLocation(550, 400);
		bt3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
				new FoodAddVeiw().run();
				
			}
			
		});
		
		bt4 = new JButton("�޸�ʳƷ��Ϣ");
		bt4.setSize(150, 50);
		bt4.setLocation(550, 500);
		bt4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new FoodUpdateVeiw().run();
			}
			
		});
		
		

		this.add(bt1);
		this.add(bt2);
		this.add(bt3);
		this.add(bt4);

		panel = new JPanel();
		panel.setLocation(100, 20);
		panel.setLayout(null);
		panel.setBackground(Color.GRAY);
		this.add(panel);

		panel2 = new JPanel();
		panel2.setSize(650, 350);
		panel2.setLocation(100, 20);
		panel2.setLayout(null);
		panel2.setBackground(Color.lightGray);

		label = new JLabel();
		label.setText("��ӭ��½ʳƷ����ϵͳ");
		label.setLocation(165, 60);
		label.setSize(500, 200);
		panel2.add(label);
		label.setFont((new Font("����", Font.BOLD, 30)));
		this.add(panel2);
		panel2.setVisible(true);

		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Choose();
	}

}
