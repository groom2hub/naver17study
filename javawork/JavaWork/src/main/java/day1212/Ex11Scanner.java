package day1212;

import java.util.Date;
import java.util.Scanner;

public class Ex11Scanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		/*
		 * 년(year), 월(month), 일(day)를 입력 후
		 * 해당 날짜에 대한 Date 클래스를 생성 후(myDate)
		 * myDate를 이용해서 년도, 월, 일, 요일(week)을 구해서 출력하시오.
		 * 요일을 요일 숫자(weekNum)를 먼저 얻은 후 요일을 구해서 출력
		 *  
		 * */
		
		
		int year, month, date;
		System.out.println("년도를 입력하시오. ");
		year = sc.nextInt();
		System.out.println("월을 입력하시오. ");
		month = sc.nextInt();
		System.out.println("일을 입력하시오. ");
		date = sc.nextInt();
		
		Date dateInput = new Date(year - 1900, month - 1, date);
		
		int weekNum = dateInput.getDay();
		String weekString = weekNum == 0 ? "일" : weekNum == 1 ? "월" : weekNum == 2 ? "화" : weekNum == 3 ? "수" : 
			weekNum == 4 ? "목" : weekNum == 5 ? "금" : "토";
		System.out.printf("%d년 %d월 %d일은 %s요일입니다.\n", year, month, date, weekString);
		
	}

}
