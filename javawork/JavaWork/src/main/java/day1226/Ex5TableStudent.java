package day1226;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ex5TableStudent extends JFrame {
	static final String studentFILE = "/Users/choijunhyeok/Desktop/네이버클라우드캠프/study/javawork/JavaWork/src/main/java/day1226/student.txt";
	List<Student> studentList = new Vector<Student>();
	JTable table;

	public Ex5TableStudent() {
		super("학생 파일 읽기");
		this.setBounds(300, 100, 300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.initDesign();
		this.setVisible(true);
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

				//List 에 추가
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

	private void initDesign() {
		this.studentFileRead();

		Vector<String> title = new Vector<String>();
		title.add("이름");
		title.add("국어 점수");
		title.add("영어 점수");
		title.add("총점");
		title.add("평균 점수");

		Vector<Vector<String>> data = new Vector<Vector<String>>();

		for (Student s : studentList) {
			Vector<String> stduent = new Vector<String>();
			stduent.add(s.getName());
			stduent.add(String.valueOf(s.getKor()));
			stduent.add(String.valueOf(s.getEng()));
			stduent.add(String.valueOf(s.getKor() + s.getEng()));
			stduent.add(String.valueOf((s.getKor() + s.getEng()) / 2.0));

			data.add(stduent);
		}

		table = new JTable(data, title); 
		this.add("Center", new JScrollPane(table));

	}

	public static void main(String[] args) {
		Ex5TableStudent ex5 = new Ex5TableStudent();
	}

}
