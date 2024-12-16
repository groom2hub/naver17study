package day1216;

import java.util.Scanner;

public class Ex8LoopExam {
	public static void main(String[] args) {
		/*
		 * 이름을 입력하면 그 중 "김"씨 성을 가진 사람의 인원수
		 * "이"씨 성을 가진 사람의 인원수
		 * 그 이외의 인원수를 각각 구하여 출력하시오.
		 * while문 빠져나가는 코드는 "끝"
		 * 
		 * 사용할 문자열 메소드 startsWith, equals
		 */
		
		Scanner sc = new Scanner(System.in);
		
		String name;
		int kimCount = 0, leeCount = 0, otherCount = 0;
		
		
		while(true) {
			System.out.print("이름: ");
			name = sc.nextLine();
			
			if (name.equals("끝")) {
				break;
			}
			else if (name.startsWith("김")) {
				kimCount++;
			}
			else if (name.startsWith("이")) {
				leeCount++;
			}
			else {
				otherCount++;
			}
		}

		System.out.printf("김씨: %d명, 이씨: %d명, 그외: %d명", kimCount, leeCount, otherCount);
		
	}
	
}
