package day1219;

import java.util.Scanner;

class Orange {
	private String name;
	private String color;
	private int age;

	Orange() {
//		this.name = "default";
//		this.color = "orange";
//		this.age = 30;
		
		this("이말자","노랑");
	}
	
	Orange(String name, String color) {
		this.name = name;
		this.color = color;
		this.age = 30;
	}
	
	public void printMember() {
		System.out.println("name: " + name + ", color: " + color + ", age: " + age);
	}
	
	public void printMember(int n) {
		if (n == 1) {
			System.out.println("*".repeat(50));
			System.out.println("이름: " + name);
			System.out.println("좋아하는 색상: " + color);
			System.out.println("나이: " + age);
			System.out.println("*".repeat(50));
		} else if (n == 2) {
			System.out.println(name + "님은 " + color + "색상을 좋아합니다.");
		} else {
			System.out.println("1 or 2만 가능합니다.");
		}
	}

}

public class Ex4Constructor {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Orange a1 = new Orange();
		a1.printMember();
		Orange a2 = new Orange("고민시", "파랑");
		a2.printMember();
		a2.printMember(1);
		a2.printMember(2);
		a2.printMember(4);
		
	}

}
