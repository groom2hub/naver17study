package day1216;

import java.util.Random;

public class Ex1Random {
	public static void main(String[] args) {
		/* 
		 * 난수를 구하는 방법
		 * 1. Math.random()
		 * 2. Random
		 */
		
		System.out.println("Math.random()은 0.0보다 크거나 같고, 1.0보다 작은 난수 발생");
		for (int i = 1; i <= 5; i++) {
			System.out.println(Math.random());
		}

		System.out.println();
		System.out.println("0~9 사이의 난수");
		for (int i = 1; i <= 5; i++) {
			int n = (int)(Math.random() * 10);
			System.out.print(n + " ");
		}
		System.out.println();

		System.out.println();
		System.out.println("0~99 사이의 난수");
		for (int i = 1; i <= 5; i++) {
			int n = (int)(Math.random() * 100);
			System.out.print(n + " ");
		}
		System.out.println();

		System.out.println();
		System.out.println("1~10 사이의 난수");
		for (int i = 1; i <= 5; i++) {
			int n = (int)(Math.random() * 10) + 1;
			System.out.print(n + " ");
		}
		System.out.println();
		

		System.out.println();
		System.out.println("Random 클래스를 이영하여 난수 구하기");
		Random r = new Random();
		System.out.println("0~9 사이의 난수");
		for (int i = 1; i <= 5; i++) {
			int n = r.nextInt(10);
			System.out.print(n + " ");
		}
		System.out.println();

		System.out.println();
		System.out.println("1~10 사이의 난수");
		for (int i = 1; i <= 5; i++) {
			int n = r.nextInt(10) + 1;
			System.out.print(n + " ");
		}
		System.out.println();
		
		System.out.println();
		System.out.println("A~Z 사이의 난수");
		for (int i = 1; i <= 5; i++) {
			int n = r.nextInt(26) + 65;
			System.out.print((char)n + " ");
		}
		System.out.println();
		
		System.out.println();
		System.out.println("a~z 사이의 난수");
		for (int i = 1; i <= 5; i++) {
			int n = r.nextInt(26) + 97;
			System.out.print((char)n + " ");
		}
		System.out.println();
		
	}
	
}
