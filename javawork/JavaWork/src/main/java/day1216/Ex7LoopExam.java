package day1216;

import java.util.Scanner;

public class Ex7LoopExam {
	public static void main(String[] args) {
		/*
		 * 1. 지수승 구하기 2. 팩토리얼 구하기
		 * 3. 원의 넓이 구하기
		 * 4. 종료
		 * 
		 * while문에서 위의 메뉴가 나오면 번호를 입력하고 해당 데이터를 입력 후 결과값을 출력하시오.
		 * 
		 * 1번: 두 수 x, y를 입력 후 x의 y승(for문)을 구하여 출력하시오.
		 * 2번: 숫자 n을 입력 후 n!값을 구하시오. (for문)
		 * 3번: 반지름 r을 입력하면 원의 넓이를 구해서 출력하시오. (반지름 * 반지름 * Math.PI)
		 * 그 이외의 값이 들아오면 "종료합니다." 출력 후 프로그램을 종료하시오.
		 */
		
		Scanner sc = new Scanner(System.in);
		int x, y, result;
		int n, fact;
		int r;
		double area;
		int menu;
		
		Loop:
		while(true) {
			System.out.println("1. 지수승 구하기 2. 팩토리얼 구하기 3. 원의 넓이 구하기 4. 종료");
			menu = sc.nextInt();
			switch(menu) {
			case 1:
				System.out.print("x: ");
				x = sc.nextInt();
				System.out.print("y: ");
				y = sc.nextInt();
				result = 1;
				for (int i = 0; i < y; i++) {
					result *= x;
				}
				System.out.printf("%d^%d = %d\n", x, y, result);
				break;
				
			case 2:
				System.out.print("n: ");
				n = sc.nextInt();
				fact = 1;
				for (int i = 1; i <= n; i++) {
					fact *= i;
				}
				System.out.println(n + "! = " + fact);
				break;
				
			case 3:
				System.out.print("r: ");
				r = sc.nextInt();
				area = r * r * Math.PI;
				System.out.printf("반지름 %d인 원의 넓이 = %.2f\n", r, area);
				break;
				
			default:
				System.out.println("프로그램을 종료합니다.");
				break Loop;
			}
		}
		
	}
	
}
