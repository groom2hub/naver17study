package day1217;

import java.util.Scanner;

public class Ex8ArrayAlpha {

	public static void main(String[] args) {
		/*
		 * 영어 문장을 입력하면 알파벳을 분석하여 각 알파벳의 갯수를 구하시오.
		 */
		
		Scanner sc = new Scanner(System.in);
		
		String message;
		int []alpha = new int[26];
		

		System.out.print("문장을 입력하시오.");
		message = sc.nextLine();
		
		for (int i = 0; i < message.length(); i++) {
			char ch = message.charAt(i);
			
			if (ch >= 'A' && ch <= 'Z') {
				alpha[ch - 'A']++;
			}
			else if (ch >= 'a' && ch <= 'z') {
				alpha[ch - 'a']++;
			}
			
		}
		
		
		for (int i = 0; i < alpha.length; i++) {
//			System.out.printf("%c: %d개\t", 'A' + i, alpha[i]);
			System.out.printf((char)('A' + i) + ": " + alpha[i] + "개\t");
			if (i % 4 == 3) {
				System.out.println();
			}
		}
		
	}

}
