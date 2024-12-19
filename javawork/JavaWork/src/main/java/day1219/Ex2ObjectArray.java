package day1219;

import java.util.Scanner;

public class Ex2ObjectArray {
	
	public static void inputData(Student s) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름: ");
		String name = sc.nextLine();
		System.out.print("주소: ");
		String addr = sc.nextLine();
		System.out.print("혈액형: ");
		String blood = sc.nextLine();
		System.out.println();
		
		s.changeStudent(name, addr, blood);
	}
	
	public static void showTitle() {
		System.out.println("이름\t혈액형\t주소");
		System.out.println("=".repeat(60));
	}
	
	public static void pringDataArray(Student s) {
		System.out.printf("%s\t%s형\t%s\n", 
				s.getStuName(), s.getStuBlood().toUpperCase(), s.getStuAddress());
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		Student[] stuArray;
		
		System.out.print("인원수: ");
		num = Integer.parseInt(sc.nextLine());
		stuArray = new Student[num];
		
		for (int i = 0; i < num; i++) {
			stuArray[i] = new Student();
			inputData(stuArray[i]);
		}
		
		showTitle();
		for (int i = 0; i < num; i++) {
			pringDataArray(stuArray[i]);
		}
		
		
	}

}
