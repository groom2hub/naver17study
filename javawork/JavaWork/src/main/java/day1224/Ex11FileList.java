package day1224;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Ex11FileList {

	static final String FILENAME = "/Users/choijunhyeok/Desktop/네이버클라우드캠프/study/javawork/JavaWork/src/main/java/day1224/employee.txt";
	List<String> employeeList = new Vector<String>();

	public Ex11FileList() {
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			while (true) {
				String s = br.readLine();
				if (s == null) {
					break;
				}
				employeeList.add(s);
			}

		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException|NullPointerException e) {
				e.printStackTrace();
			}
		}
	}

	public void employeeMemberList() {
		System.out.println("총 " + employeeList.size() + "명의 사원이 있습니다");
		System.out.println();
		System.out.println("번호\t사원명");
		int n = 0;
		for (String name : employeeList) {
			System.out.println(++n+"\t"+name);
		}
		System.out.println();		
	}

	public int getSearchName(String name) {
		int idx = -1;
		for(int i = 0; i < employeeList.size() ; i++) {
			String listName = employeeList.get(i);
			if (listName.equals(name)) {
				idx = i;
				break;
			}
		}
		return idx;
	}

	public void deleteEmployee(String name) {
		int idx = this.getSearchName(name);
		if(idx == -1) {
			System.out.println(name + "님은 사원명단에 없습니다");
		} else {
			employeeList.remove(idx);
			System.out.println(name + "님을 사원명단에서 삭제했습니다");
		}
	}


	public void searchName(String name) {
		int idx = this.getSearchName(name);
		if(idx == -1) {
			System.out.println(name+" 님은 사원 명단에 없습니다");
		} else {
			System.out.println(name+" 님은 " + (idx + 1) + " 번째에 있습니다");
		}
	}

	public void employeeFileSave() {
		FileWriter fw=null;
		try {
			fw = new FileWriter(FILENAME);
			for (String name : employeeList) {
				fw.write(name + "\n");
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

	public void addEmployee(String name) {
		int idx = this.getSearchName(name);
		if (idx != -1) {
			System.out.println(name+" 님은 이미 존재합니다");
		} else {
			employeeList.add(name);
			System.out.println("추가되었습니다");
		}
	}

	public static void main(String[] args) {
		Ex11FileList ex11=new Ex11FileList();
		Scanner sc=new Scanner(System.in);
		int menu = 0;

		while(true) {
			System.out.println("1.사원추가  2.사원삭제  3.사원검색 4.전체목록  5.저장후종료");
			System.out.println("=".repeat(40));
			try {
				menu = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				menu = 4;
			}

			switch (menu) {
			case 1 -> {
				System.out.println("추가할 사원명을 입력하세요");
				String name = sc.nextLine();
				ex11.addEmployee(name);
			}
			case 2 -> {
				System.out.println("삭제할 사원명을 입력하세요");
				String name = sc.nextLine();
				ex11.deleteEmployee(name);
			}
			case 3 -> {
				System.out.println("검색할 사원명을 입력하세요");
				String name = sc.nextLine();
				ex11.searchName(name);
			}
			case 4-> ex11.employeeMemberList();
			default -> {
				System.out.println("** 저장후 종료합니다 **");
				ex11.employeeFileSave();
				System.exit(0);
			}
			}
		}

	}

}
