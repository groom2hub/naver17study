package day1219;

import java.util.Scanner;

/*
 * 생성자란?
 * 1. 객체 생성 시 자동 호출
 * 2. 리턴 타입이 없음
 * 3. 오버로딩이 가능
 * 4. 생성자에서는 주로 멤버변수 초기화를 담당
 */
class Apple {
	Apple() {
		System.out.println("디폴트 생성자");
	}

	Apple(String name) {
		System.out.println("인자로 " + name + " 받음");
	}
	
	Apple(int age) {
		System.out.println("인자로 " + age + " 받음");
	}
	
	Apple(String name, int age) {
		System.out.println("인자로 " + name + ", " + age + " 받음");
	}
	
}

public class Ex3Constructor {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Apple a1 = new Apple();
		Apple a2 = new Apple("banana");
		Apple a3 = new Apple(13);
		Apple a4 = new Apple("kiwi", 10);
		
		
	}

}
