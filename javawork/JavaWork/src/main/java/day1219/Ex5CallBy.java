package day1219;

import java.util.Scanner;

/*
 * 인자 전달 방식
 * CallByValue: 값만 전달(기본형, String)
 * CallByReference: 주소가 전달(모든 객체, 배열 타입)
 */
class Test {
	String message;
	int code;
}
public class Ex5CallBy {
	
	public static void changeInt(int n) {
		n = 200;
	}
	public static void changeString(String s) {
		s = "apple";
	}
	public static void changeTest(Test t) {
		t.message = "Happy";
		t.code = 100;
	}
	public static void changeArray(int[] a) {
		a[1] = 100;
	}
	public static int changeScore(int score) {
		if (score >= 80) {
			return score;
		} else {
			return 90;
		}
	}
	
	public static void main(String[] args) {
		int n = 100;
		changeInt(n);
		System.out.println("n = " + n);
		
		String s = "banana";
		changeString(s);
		System.out.println("s = " + s);
		
		Test t = new Test();
		System.out.println("message = " + t.message + ", code= " + t.code);
		changeTest(t);
		System.out.println("message = " + t.message + ", code= " + t.code);
		
		int[] a = {5, 8, 11};
		changeArray(a);
		for(int aa : a) {
			System.out.print(aa + " ");
		}
		System.out.println();
		
		int score = 70; // 메서드에서 변경된 값을 받으려면 return 사용
		score = changeScore(score);
		System.out.println("score = " + score);
		
	}

}
