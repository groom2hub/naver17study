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

public class Ex4TableEmployee extends JFrame {
	static final String employeeFILE = "/Users/choijunhyeok/Desktop/네이버클라우드캠프/study/javawork/JavaWork/src/main/java/day1226/myEmployee.txt";
	List<Employee> employeeList = new Vector<Employee>();
	JTable table;

	public Ex4TableEmployee() {
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
		String[] title = {"사원명", "나이", "핸드폰", "주소"};
		String[][] data = new String[employeeList.size()][4];

		int i = 0;
		for (Employee e : employeeList) {
			data[i][0] = e.getEmployeeName();
			data[i][1] = String.valueOf(e.getAge());
			data[i][2] = e.getHp();
			data[i][3] = e.getAddress();
			i++;
		}

		table = new JTable(data, title); 
		this.add("Center", new JScrollPane(table));

	}

	public static void main(String[] args) {
		Ex4TableEmployee ex4 = new Ex4TableEmployee();
	}

}
