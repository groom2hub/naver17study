package day1212;

import java.util.Date;
import java.util.Scanner;

public class Ex14If {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int score;
		String grade;
		
		System.out.println("점수를 입력하시오.");
		score = sc.nextInt();
		
//		if (!(score <= 100 && score >= 0)) {
		if (score > 100 || score < 0) {
			System.out.println("값의 범위를 벗어났습니다.");
			return;
			
		}
		
		if (score >= 90)
			grade = "A";
		else if (score >= 80)
			grade = "B";
		else if (score >= 70)
			grade = "C";
		else if (score >= 60)
			grade = "D";
		else
			grade = "F";
		
		System.out.printf("%d점의 학점은 %s학점입니다.\n", score, grade);
			
	}

}
