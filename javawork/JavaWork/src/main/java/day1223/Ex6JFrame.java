package day1223;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

class MyFrame extends JFrame {
	JButton btn1 = new JButton();
	
	public MyFrame() {
		super("Hello");
		
		this.setBounds(300, 100, 300, 100);
		this.setLayout(null);
		btn1.setBounds(30, 30, 100, 30);
		btn1.addActionListener(new ActionListener() {
			private Component  MyFrame;
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(this.MyFrame, "버튼 이벤트입니다.");
				
			}
		});
		this.add(btn1);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}

public class Ex6JFrame {

	public static void main(String[] args) {
		MyFrame my = new MyFrame();
		
		
	}

}
