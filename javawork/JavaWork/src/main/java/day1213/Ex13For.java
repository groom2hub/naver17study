package day1213;

import java.util.Scanner;

public class Ex13For {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 문제 2
		 * 5명의 나이를 입력 후
		 * 40세 이상과 40세 미만이 각각 몇명인지 출력하고
		 * 평균 나이도 같이 출력하시오.
		 * (for문 사용)
		 * */
		
		Scanner sc = new Scanner(System.in);
		int n, under_40 = 0, ageSum = 0;
		
		
		for (int i = 0; i < 5; i++) {
			System.out.print((i + 1) + "번째 나이를 입력하시오. ");
			n = sc.nextInt();
			// 0~100 세를 벗어나는 경우 다시 입력(인원 수 제외)
			if (n < 0 || n > 100) {
				i--;
				continue;
			}
			under_40 += n < 40 ? 1 : 0;
			ageSum += n;			
		}

		System.out.printf("40세 이상 : %d명, 40세 미만 : %d명\n", 5 - under_40, under_40);
		System.out.printf("평균 나이 : %.1f세\n", ageSum / 5.0);
			
	}

}
