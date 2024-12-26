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

public class Ex3TableEmployee extends JFrame {
	static final String employeeFILE = "/Users/choijunhyeok/Desktop/네이버클라우드캠프/study/javawork/JavaWork/src/main/java/day1226/myEmployee.txt";
	List<Employee> employeeList = new Vector<Employee>();
	JTable table;

	public Ex3TableEmployee() {
		super("사원 파일 읽기");
		this.setBounds(300, 100, 300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.initDesign();
		this.setVisible(true);
	}

	public void employeeFileRead() {
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(employeeFILE);
			br = new BufferedReader(fr);

			while (true) {
				String employeeInfo = br.readLine();
				if(employeeInfo == null) {
					break;
				}

				String[] e = employeeInfo.split("\\|");
				Employee employee = new Employee();
				employee.setEmployeeName(e[0]);
				employee.setAge(Integer.parseInt(e[1]));
				employee.setHp(e[2]);
				employee.setAddress(e[3]);

				employeeList.add(employee);				
			}
			System.out.println("총 " + employeeList.size() + "명 읽음");
		} catch (FileNotFoundException e) {
			System.out.println("저장된 사원정보가 없습니다");
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
		this.employeeFileRead();

		Vector<String> title = new Vector<String>();
		title.add("사원명");
		title.add("나이");
		title.add("핸드폰");
		title.add("주소");

		Vector<Vector<String>> data = new Vector<Vector<String>>();

		for (Employee e : employeeList) {
			Vector<String> employee = new Vector<String>();
			employee.add(e.getEmployeeName());
			employee.add(String.valueOf(e.getAge()));
			employee.add(e.getHp());
			employee.add(e.getAddress());

			data.add(employee);
		}

		table = new JTable(data, title); 
		this.add("Center", new JScrollPane(table));

	}

	public static void main(String[] args) {
		Ex3TableEmployee ex3 = new Ex3TableEmployee();
	}

}
