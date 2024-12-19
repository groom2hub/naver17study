package day1219;

import java.util.Scanner;

public class Ex7VarArgs {
	
	public static void writeColor(String color1) {
		System.out.println("color1 = " + color1);
	}
	public static void writeColor(String color1, String color2) {
		System.out.println("color1 = " + color1 + ", color2 = " + color2);
		}
	public static void writeColor(String color1, String color2, String color3) {
		System.out.println("color1 = " + color1 + ", color2 = " + color2 + ", color3 = " + color3);
	}
	
	public static void writeName(String ...name) {
		if (name.length == 0) {
			System.out.println("멤버가 없습니다.");
		} else {
			System.out.println("***** 멤버 목록 *****");
			for (String n:name) {
				System.out.println("\t" + n);
			}
			System.out.println("*".repeat(20));
			System.out.println();
		}
	}

	public static void main(String[] args) {
		writeColor("red");
		writeColor("yellow", "green");
		writeColor("white", "orange", "black");
		
		System.out.println();
		System.out.println("Variavble Arguments 기능을 이용해서 인자로 여러 문자열 보내보자.");
		writeName();
		writeName("이미자");
		writeName("손예진", "한고은");
		writeName("캔디", "마이클", "캐서린", "아담스");
		
	}

}
