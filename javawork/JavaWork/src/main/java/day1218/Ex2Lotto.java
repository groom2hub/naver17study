package day1218;

import java.util.Random;
import java.util.Scanner;

public class Ex2Lotto {

	public static void main(String[] args) {
		/*
		 * 인원수를 입력 후 인원수만큼 이름과 자바, 스프링 두 점수를 입력 후
		 * 총합, 평균 등수, 등급을 구하시오.
		 */

		Scanner sc = new Scanner(System.in);
		
		int money;
		int []lotto = new int[6];
		Random r = new Random();

		
		System.out.print("금액: ");
		money = Integer.parseInt(sc.nextLine());
		if (money < 1000) {
			System.out.println("금액이 부족합니다.");
			return;
		}
		
		for (int n = 0; n < money/1000; n++) {
			System.out.printf("%3d회: ", n);
			for (int i = 0; i < lotto.length; i++) {
				lotto[i] = r.nextInt(45) + 1;
				for (int j = 0; j < lotto.length; j++) {
					if (lotto[i] == lotto[j]) {
						i--;
						break;
					}
				}
			}
			
			
			
			for (int i = 0; i < lotto.length; i++) {
				System.out.printf("%4d", lotto[i]);
			}
			System.out.println();
		}
				
	}

}
