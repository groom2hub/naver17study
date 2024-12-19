package day1218;

import java.util.Random;
import java.util.Scanner;

public class Ex6Object {
	// static 변수는 인스턴스 변수 없이도 접근 가능
	static int x =10;
	static int y =20;
			
	public static void showTitle() {
		System.out.println("클래스 공부 중...");
	}
	
	
	
	public static void main(String[] args) {

		System.out.println("x = " + Ex6Object.x); // static 변수는 클래스명으로 접근
		System.out.println("x = " + x); // 같은 클래스의 멤버일 경우 클래스명 생략 가능
		
		int sum = x + y;
		System.out.println("sum = " + sum);
		
		Ex6Object.showTitle();
		showTitle();
		
	}

}
