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
	JFrame frame = new JFrame("ʳƷ��Ϣ�޸�");

	public void run() {

		// ���ô�����ɫ
		frame.getContentPane().setBackground(Color.WHITE);
		// ���ô���߶�
		frame.setSize(450, 400);
		// ���ô���λ�ã�������ʾ����λ��
		Point point = new Point(300, 200);
		frame.setLocation(point);
		// ���ô���ɼ���
		frame.setVisible(true);
		// �������ڵĹرհ�ťʱִ��
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		// ����һ�����
		JPanel panel = new JPanel();
		frame.add(panel);
		FoodVeiw(panel);
	}
	private void FoodVeiw(JPanel panel) {
		panel.setLayout(null);// ���ֲַ�
		Font fnt = new Font("����", Font.BOLD, 13);
		Font fnt1 = new Font("����",Font.ITALIC,13);
		
		//��ʾ��Ϣ
		JLabel tips = new JLabel("������Ҫ������ʳƷ��ţ�");
		tips.setBounds(150,20,200,25);
		panel.add(tips);
		tips.setFont(fnt1);
		// ʳƷ���
		JLabel numlab = new JLabel("ʳƷ��ţ�");
		numlab.setBounds(80, 50, 70, 25);
		panel.add(numlab);
		numlab.setFont(fnt);

		JTextField numtext = new JTextField();
		numtext.setBounds(150, 50, 170, 25);
		panel.add(numtext);

		// ʳƷ��
		JLabel namelab = new JLabel("ʳƷ����");
		namelab.setBounds(80, 100, 60, 25);
		panel.add(namelab);
		namelab.setFont(fnt);

		JTextField nametext = new JTextField();
		nametext.setBounds(150, 100, 200, 25);
		panel.add(nametext);

		// ʳƷ����
		JLabel typelab = new JLabel("ʳƷ���ͣ�");
		typelab.setBounds(80, 150, 70, 25);
		panel.add(typelab);
		typelab.setFont(fnt);

		JTextField typetext = new JTextField();
		typetext.setBounds(150, 150, 200, 25);
		panel.add(typetext);

		// ʳƷ�۸�
		JLabel pricelab = new JLabel("ʳƷ�۸�");
		pricelab.setBounds(80, 200, 70, 25);
		panel.add(pricelab);
		pricelab.setFont(fnt);

		JTextField pricetext = new JTextField();
		pricetext.setBounds(150, 200, 200, 25);
		panel.add(pricetext);

		// ʳƷ���
		JLabel numberlab = new JLabel("ʳƷ��棺");
		numberlab.setBounds(80, 250, 70, 25);
		panel.add(numberlab);
		numberlab.setFont(fnt);

		JTextField numbertext = new JTextField();
		numbertext.setBounds(150, 250, 200, 25);
		panel.add(numbertext);
		
		//ȷ��Ҫ�޸ĵ�ʳƷ���
		JButton apply1 = new JButton("ȷ��");
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
					JOptionPane.showMessageDialog(null, "���ҵ���ʳƷ,�뿪ʼ�޸ģ�");
				}
			}
			
		});
		JButton apply = new JButton("�޸�");
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
							JOptionPane.showMessageDialog(null, "�޸�ʳƷ��Ϣ�ɹ�");
						}else {
							JOptionPane.showMessageDialog(null, "�޸�ʳƷ��Ϣʧ��");
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

