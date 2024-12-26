package day1226;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex1EmployeeArrayList {
	List<Employee> employeeList = new ArrayList<Employee>();
	static final String employeeFILE = "/Users/choijunhyeok/Desktop/네이버클라우드캠프/study/javawork/JavaWork/src/main/java/day1226/myEmployee.txt";

	public Ex1EmployeeArrayList() {
		this.employeeFileRead();
	}

	public void employeeFileRead() {
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(employeeFILE);
			br = new BufferedReader(fr);

			while(true) {
				String employeeInfo = br.readLine();
				if(employeeInfo == null)
					break;

				String[] e = employeeInfo.split("\\|");
				Employee employee = new Employee();
				employee.setEmployeeName(e[0]);
				employee.setAge(Integer.parseInt(e[1]));
				employee.setHp(e[2]);
				employee.setAddress(e[3]);

				//List 에 추가
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

	public void employeeFileSave() {
		FileWriter fw = null;
		try {
			fw = new FileWriter(employeeFILE);

			for(Employee employee:employeeList)
			{
				String s = employee.getEmployeeName() + "|" + employee.getAge() + "|" + 
						employee.getHp() + "|" + employee.getAddress() + "\n";
				//파일에 추가
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

	public void addEmployee(Employee employee) {
		employeeList.add(employee);
		System.out.println(employee.getEmployeeName()+" 님의 정보를 추가했습니다.");
	}

	public int getSearchName(String name) {
		int idx=-1;
		for (int i = 0; i < employeeList.size(); i++) {
			Employee employee = employeeList.get(i);
			if (employee.getEmployeeName().equals(name)) {
				idx = i;
				break;
			}
		}
		return idx;
	}

	public void deleteEmployee(String name) {
		int idx = this.getSearchName(name);
		if(idx == -1) {
			System.out.println(name + " 사원은 존재하지 않습니다.");
		} else {
			employeeList.remove(idx);
			System.out.println(name + "사원의 정보를 삭제했습니다.");
		}
	}

	public void searchEmployee(String name) {
		int idx = this.getSearchName(name);
		if (idx == -1) {
			System.out.println(name + "님은 사원 명단에 없습니다.");
		} else {
			System.out.println("** " + name + "님의 개인 정보 **");
			Employee employee = employeeList.get(idx);
			System.out.println("나이: " + employee.getAge());
			System.out.println("핸드폰: " + employee.getHp());
			System.out.println("주소: " + employee.getAddress());
		}
	}

	public void writeEmployeeList() {
		System.out.println("\t\t[전체 사원 정보]\n");
		System.out.println("번호\t사원명\t나이\t핸드폰\t\t주소");
		System.out.println("=".repeat(60));

		int n = 0;
		for(Employee e : employeeList) {
			System.out.println(++n + "\t" + e.getEmployeeName() + "\t" + e.getAge() + "세\t" + 
					e.getHp() + "\t" + e.getAddress());
		}

	}

	public static void main(String[] args) {
		Ex1EmployeeArrayList ex1 = new Ex1EmployeeArrayList();
		Scanner sc = new Scanner(System.in);
		int menu = 0;

		while (true) {
			System.out.println("*** 사원관리 메뉴 ***");
			System.out.println("1. 사원정보추가");
			System.out.println("2. 사원정보검색");
			System.out.println("3. 사원삭제");
			System.out.println("4. 전체사원출력");
			System.out.println("5. 저장후 종료");
			System.out.print("번호를 선택하세요:");

			try {
				menu = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				menu = 4;
			}

			switch (menu) {
			case 1-> {
				System.out.println("사원명은?");
				String name = sc.nextLine();
				System.out.println("나이는?");
				int age = Integer.parseInt(sc.nextLine());
				System.out.println("핸드폰은?");
				String hp = sc.nextLine();
				System.out.println("주소는?");
				String addr = sc.nextLine();

				Employee employee = new Employee(name, age, hp, addr);
				ex1.addEmployee(employee);
			}
			case 2 -> {
				System.out.println("검색할 사원의 이름을 입력하세요");
				String name = sc.nextLine();
				ex1.searchEmployee(name);
			}
			case 3 -> {
				System.out.println("삭제할 사원의 이름을 입력하세요");
				String name = sc.nextLine();
				ex1.deleteEmployee(name);
			}
			case 4 -> {
				ex1.writeEmployeeList();
			}
			default -> {
				ex1.employeeFileSave();
				System.out.println("사원정보를 파일에 저장후 종료합니다");
				System.exit(0);
			}
			}

			System.out.println("-".repeat(40));

		}

	}

}
