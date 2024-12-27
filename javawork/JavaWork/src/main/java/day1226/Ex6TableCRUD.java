package day1226;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Ex6TableCRUD extends JFrame {
	static final String studentFILE = "/Users/choijunhyeok/Desktop/네이버클라우드캠프/study/javawork/JavaWork/src/main/java/day1226/student.txt";
	List<Student> studentList = new Vector<Student>();
	JTable table;
	DefaultTableModel tableModel;
	JTextField tfName,tfKor,tfEng;
	JButton btnAdd;

	public Ex6TableCRUD() {
		super("학생관리");
		this.setBounds(300, 100, 400, 400);
		this.initDesign();
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				saveFile();
				System.exit(0);
				super.windowClosing(e);
			}
		});
	}

	public void studentFileRead() {
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(studentFILE);
			br = new BufferedReader(fr);

			while (true) {
				String studentInfo = br.readLine();
				if(studentInfo == null) {
					break;
				}

				String[] s =  studentInfo.split("\\|");
				Student student = new Student();
				student.setName(s[0]);
				student.setKor(Integer.parseInt(s[1]));
				student.setEng(Integer.parseInt(s[2]));

				studentList.add(student);
			}
			System.out.println("총 " + studentList.size() + "명 읽음");
		} catch (FileNotFoundException e) {
			System.out.println("저장된 학생 정보가 없습니다");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException|NullPointerException e) {

			}
		}
	}

	public void writeTableData() {
		//기존의 테이블에 출력된 데이타를 삭제후 다시 추가
		tableModel.setRowCount(0);		
	
		for (Student stu : studentList) {
			Vector<String> data=new Vector<String>();
			
			int kor=stu.getKor();
			int eng=stu.getEng();
			int sum=kor+eng;
			double avg=sum/2.0;
			
			data.add(stu.getName());
			data.add(String.valueOf(kor));
			data.add(String.valueOf(eng));
			data.add(String.valueOf(sum));
			data.add(String.valueOf(avg));
			
			//table 에 추가(추가하는 메서드도 모델이 갖구있음)
			tableModel.addRow(data);
		}
		
	}
	
	private void initDesign() {
		this.studentFileRead();

		String[] title = {"이름", "국어", "영어", "총점", "평균"};
		tableModel = new DefaultTableModel(title, 0);
		table = new JTable(tableModel);

		this.writeTableData();
		this.add("Center", new JScrollPane(table));

		JPanel panel = new JPanel();
		tfName = new JTextField(5);
		tfKor = new JTextField(4);
		tfEng = new JTextField(4);

		btnAdd=new JButton("추가");
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = tfName.getText();
				int kor = Integer.parseInt(tfKor.getText());
				int eng = Integer.parseInt(tfEng.getText());

				Student stu = new Student(name, kor, eng);
				studentList.add(stu);

				writeTableData();

				tfName.setText("");
				tfKor.setText("");
				tfEng.setText("");

			}
		});

		panel.add(new JLabel("이름"));
		panel.add(tfName);
		panel.add(new JLabel("국어"));
		panel.add(tfKor);
		panel.add(new JLabel("영어"));
		panel.add(tfEng);
		panel.add(btnAdd);
		this.add("North", panel);

	}
	
	private void saveFile() {
		FileWriter fw = null;
		
		try {
			fw = new FileWriter(studentFILE);
			
			for (Student stu : studentList) {
				String s = stu.getName() + "|" + stu.getKor() + "|" + stu.getEng() + "\n";
				fw.write(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}

	public static void main(String[] args) {
		Ex6TableCRUD ex6 = new Ex6TableCRUD();
	}

}
