package day1226;

import java.awt.SystemTray;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ex2JTable extends JFrame {
	JTable table;
	
	public Ex2JTable() {
		super("JTable 공부");
		this.setBounds(300, 100, 300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.initDesign();
		this.setVisible(true);
	}
	
	public void initDesign() {
		String[] title = {"이름", "혈액형", "나이"};
		String[][] data =  {
				{"이미자", "AB", "23"},
				{"손기자", "A", "34"},
				{"박민영", "B", "19"}
		};
		
//		Vector<String> title = new Vector<String>();
//		title.add("이름");
//		title.add("혈액형");
//		title.add("나이");
//		
//		Vector<String> data1 = new Vector<String>(); 
//		data1.add("이미자");
//		data1.add("AB");
//		data1.add("23");
//		
//		Vector<Vector<String>> data = new Vector<Vector<String>>();
//		data.add(data1);

		table = new JTable(data, title);
		this.add("North", new JLabel("데이터 출력 테이블", JLabel.CENTER));
		this.add("Center", new JScrollPane(table));
	}
	
	public static void main(String[] args) {
		Ex2JTable ex2 = new Ex2JTable();
	}

}
