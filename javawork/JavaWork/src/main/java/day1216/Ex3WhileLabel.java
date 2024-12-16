package day1216;

import java.util.Random;
import java.util.Scanner;

public class Ex3WhileLabel {
	public static void main(String[] args) {
		/* 
		 * 1~100 사이의 임의의 수 rnd를 발생 후
		 * 숫자 알아 맞추기
		 * 맞출 경우 -> 계속하시겠습니까?
		 * 				y -> 새로운 난수 발생, 카운트 0으로 초기화
		 * 				y가 아닐 경우 종료  
		 */
		Scanner sc = new Scanner(System.in);
		int n, rnd, cnt;
		Game: // 레이블은 대소문자 상관없이 임의로 지정
			while(true) {
				rnd = (int)(Math.random() * 100) + 1;
				cnt = 0;
				
				
				while(true) {
					System.out.print((++cnt) + "번쨰 시도: ");
					n = Integer.parseInt(sc.nextLine());
					
					if (n < rnd) {
						System.out.println(">> " + n + "보다 큽니다.");
					}
					else if (n > rnd) {
						System.out.println(">> " + n + "보다 작습니다.");
					}
					else {
						System.out.println("정답입니다. (시도 횟수: " + (cnt) + ")");
						System.out.print("숫자 맞추기 게임을 계속하시겠습니까? \ny/n: ");
						char ch = sc.nextLine().charAt(0);
						if (ch == 'y' || ch == 'Y') {
							System.out.println("");
							System.out.println("새로운 난수를 생성합니다.");
//							break;
							continue Game;
						} 
						else {
							break Game;
						}
					}
				}
				
				
			}
		System.out.println("프로그램을 종료합니다.");
		
	}
	
}
