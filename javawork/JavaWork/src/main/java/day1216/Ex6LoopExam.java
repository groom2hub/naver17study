package day1216;

import java.util.Scanner;

public class Ex6LoopExam {
	public static void main(String[] args) {
		/*
		 * 문자열 str을 입력 후 엔터를 누르면
		 * 문자열을 분석해서 대문자, 소문자, 숫자 각각의 갯수를 구해서 출력하시오.
		 * 사용할 문자 메소드: length(), charAt(인덱스)
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열을 입력하시오. ");
		String str = sc.nextLine();
		int upperCnt = 0, lowerCnt = 0, intCnt = 0;
		
		for (int i = 0; i < str.length(); i++) {
			char char_str = str.charAt(i);
			if (char_str >= 'A' && char_str <= 'Z') {
				upperCnt++;
			}
			else if (char_str >= 'a' && char_str < 'z') {
				lowerCnt++;
				}
			else if (char_str >= '0' && char_str <= '9') {
				intCnt++;
			}
		}
		
		System.out.println("대문자: " + upperCnt + "개, 소문자: " + lowerCnt + "개, 숫자: " + intCnt + "개");
			
	}
	
}
