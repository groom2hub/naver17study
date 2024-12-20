package day1219;

import java.util.Scanner;

public class Ex12EmployeeArray {

	public static void showTitle() {
		System.out.println("=".repeat(60));
		System.out.println("사원명\t직급\t기본급\t수당\t가족수당\t세금\t실수령액");
		System.out.println("=".repeat(60));
	}
	public static void printEmployee(Employee e) {
		System.out.println(e.getEmployeeName() + "\t" + e.getPosition() + "\t" + e.getDefaultSalary() + "\t" + 
				e.getAdditionalAllowance() + "\t" + e.getFamliyAllowance() +"\t" + e.getTax() + "\t" + e.getActualSalary());
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("사원 수: ");
		int employNum = Integer.parseInt(sc.nextLine());
		System.out.println();
		Employee[] eArray = new Employee[employNum];
		
		for (int i = 0; i < employNum; i++) {
			System.out.print("사원명: ");
			String employeName = sc.nextLine();

			System.out.print("직급: ");
			String position = sc.nextLine();

			System.out.print("가족수: ");
			int familyNum = Integer.parseInt(sc.nextLine());

			eArray[i] = new Employee();
			eArray[i].setEmployeeName(employeName);
			eArray[i].setPosition(position);
			eArray[i].setFamilyNum(familyNum);
			System.out.println();
		}
		
		System.out.println();
		showTitle();
		for (Employee e : eArray) {
			printEmployee(e);
		}

	}

}
