package day1217;

import java.util.Scanner;

public class Ex9ArrayAge {

	public static void main(String[] args) {
		/*
		 * 아래의 데이터를 분석하여 10대부터 40대까지 각각의 인원수를 구하시오.
		 * 0번지에는 10대 인원수 ...
		 * 
		 * 출력 양식
		 * 10대: 1명
		 * 20대: 3명...
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int []data = {12, 34, 54, 20, 33, 59, 41, 44, 27, 21};
		int []ageNum = new int[5];

		System.out.println("인원수: " + data.length);
		for (int age : data) {
			ageNum[age / 10 - 1]++;
		}

		for (int i = 0; i < ageNum.length; i++) {
			System.out.println(((i+1) * 10) + "대: " + ageNum[i] + "명");
		}
		
	}

}
