package day1217;

import java.util.Scanner;
import java.util.Date;

public class Ex1Calendar {

	public static void main(String[] args) {
		/*
		 * 년도와 월을 입력하면 해당 월의 달력을 출력하시오.
		 * 달력이 제대로 나오게하려면
		 * 1. 그 월의 1일이 무슨 요일인가?
		 * 2. 그 월이 몇일까지 있는가?
		 */
		
		Scanner sc = new Scanner(System.in);
		int inputYear, inputMonth;
		int endDay = 0;
		int weekDay;
		boolean leapYear;
		
		System.out.print("년도를 입력하시오. >> ");
		inputYear = sc.nextInt();
		System.out.print("월을 입력하시오. >> ");
		inputMonth = sc.nextInt();
		
		if (inputYear % 4 == 0) {
			System.out.println(inputYear+ "년은 평년입니다.");
			
			leapYear = true;
		}
		else {
			System.out.println(inputYear+ "년은 평년입니다.");
			leapYear = false;
		}
		
		// 1~12월이 아닌 경우 프로그램 종료
		if (inputMonth < 1 || inputMonth > 12) {
			System.out.println("잘못된 월입니다.");
			return;
		}
		
		// 입력한 년도와 일의 1일에 대한 Date클래스 생성
		Date inputDate = new Date(inputYear - 1900, inputMonth - 1, 1);
		weekDay = inputDate.getDay();
		
		// 해당월이 먗일까지 있는지 구하기
		switch (inputMonth) {
		case 2:
			endDay = leapYear ? 29 : 28;
			break;
		case 1, 3, 5, 7, 8, 10, 12:
			endDay = 31;
			break;
		case 4, 6, 9, 11:
			endDay = 30;
			break;
		}
		
		System.out.println("=".repeat(54));
		System.out.println("\t\t\t[" + inputYear + "년 " + inputMonth + "월]");
		System.out.println("=".repeat(54));
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		System.out.println("=".repeat(54));
		
		for (int i = 1; i <= weekDay; i++) {
			System.out.print("\t");
		}
		
		for (int i = 1; i <= endDay; i++) {
			++weekDay;
			System.out.printf("%2d\t", i);
			if (weekDay % 7 == 0) {
				System.out.println();
			}
		}
		
	}

}
