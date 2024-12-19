package day1219;

import java.util.Scanner;

public class Ex1ObjectArray {
	static Student[] stuArray = new Student[3];
	
	public void inputData() {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < stuArray.length; i++) {
			stuArray[i] = new Student();
			
			System.out.print("학생 이름: ");
			String name = sc.nextLine();
			System.out.print("혈액형: ");
			String blood = sc.nextLine();
			System.out.print("태어난 년도: ");
			int birthYear = Integer.parseInt(sc.nextLine());
			System.out.print("점수: ");
			int score = Integer.parseInt(sc.nextLine());
			
			stuArray[i].setStuName(name);
			stuArray[i].setStuBlood(blood);
			stuArray[i].setStuBirthYear(birthYear);
			stuArray[i].setStuScore(score);
			
		}
	}
	
	public static void showTitle() {
		System.out.println("이름\t혈액형\t나이\t점수\t학점");
		System.out.println("=".repeat(60));
	}
	
	public void pringDataArray() {
		for (Student s : stuArray) {
			System.out.printf("%s\t%s형\t%d세\t%d점\t%s\n", 
					s.getStuName(), s.getStuBlood().toUpperCase(), s.getAge(), s.getStuScore(), s.getScoreGrade());
		}
	}

	public static void main(String[] args) {
		Ex1ObjectArray ex1 = new Ex1ObjectArray();
		
		ex1.inputData();
		showTitle();
		ex1.pringDataArray();
		
	}

}
