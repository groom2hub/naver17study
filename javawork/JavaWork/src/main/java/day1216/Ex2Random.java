package day1216;

import java.util.Random;
import java.util.Scanner;

public class Ex2Random {
	public static void main(String[] args) {
		/* 
		 * 1~100 사이의 임의의 수 rnd를 발생 후
		 * 숫자 알아 맞추기
		 * ex)
		 * 1회 : 50
		 * 		50보다 큽니다.
		 * 2회 : 80
		 * 		80보다 작습니다.
		 * 		"
		 * 		"
		 * 		"
		 * 맞출 경우 -> 정답입니다. 
		 */
		Scanner sc = new Scanner(System.in);
		int n, rnd, cnt;
		
		rnd = (int)(Math.random() * 100) + 1;
		cnt = 0;
		
		while(true) {
			System.out.print((++cnt) + "번쨰 시도: ");
			n = sc.nextInt();
			
			if (n < rnd) {
				System.out.println(">> " + n + "보다 큽니다.");
			}
			else if (n > rnd) {
				System.out.println(">> " + n + "보다 작습니다.");
			}
			else {
				System.out.println("정답입니다. (시도 횟수: " + (cnt) + ")");
				break;
			}
		}
		
	}
	
}
