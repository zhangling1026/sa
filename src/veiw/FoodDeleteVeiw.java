package veiw;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import impldao.FoodDaolmpl;
import impldao.FoodDaolmpl;
import poji.FoodPoji;
//����ʳƷ
public class FoodDeleteVeiw {
	// ����
	JFrame frame = new JFrame("ɾ��ʳƷ��Ϣ");

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
		panel.setLayout(null);// ���ֲַ�
		Font fnt = new Font("����", Font.BOLD, 13);
		Font fnt1 = new Font("����", Font.ITALIC, 13);

		JLabel tips = new JLabel("������Ҫɾ����ʳƷ���!");
		tips.setBounds(150, 20, 200, 25);
		panel.add(tips);
		tips.setFont(fnt1);

		JLabel numlab = new JLabel("ʳƷ��ţ�");
		numlab.setBounds(80, 100, 70, 25);
		panel.add(numlab);
		numlab.setFont(fnt);

		JTextField numtext = new JTextField();
		numtext.setBounds(150, 100, 200, 25);
		panel.add(numtext);

		
		JButton del = new JButton("ɾ��");
		del.setBounds(200, 150, 70, 25);
		del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String num= numtext.getText();
			int n=Integer.parseInt(num);
			boolean foodrt = new FoodDaolmpl().delete(n);
			
				JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
			
			}
		});

		panel.add(del);
		panel.setBackground(Color.LIGHT_GRAY);

	}
	public static void main(String[] args) {
		new FoodDeleteVeiw().run();
	}

}
