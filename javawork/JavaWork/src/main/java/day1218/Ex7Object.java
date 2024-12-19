package day1218;

import java.util.Scanner;

class Apple {
	static String message = "Hello";
	static final String EMP = "비트캠프";
	String name = "캔디";
}

public class Ex7Object {
	
	public static void main(String[] args) {

		System.out.println("메세지: " + Apple.message); // static 변수는 클래스명으로 접근
		System.out.println("EMP: " + Apple.EMP); // 같은 클래스의 멤버일 경우 클래스명 생략 가능
		
		Apple.message = "Happy Day";
		
		System.out.println(Apple.message); // static 변수는 클래스명으로 접근
		// Apple.EMP = "삼성전자"; // 오류 > final 산수는 값 변경 불가
		
		Apple a = new Apple();
		System.out.println("이름: " + a.name); 
//		System.out.println("이름: " + Apple.name); // 오류 발생
		a.name = "미라";
		System.out.println("이름: " + a.name);
		
		Apple b = new Apple();
		b.name = "영자";
		System.out.println("이름: " + b.name);
		
	}

}
