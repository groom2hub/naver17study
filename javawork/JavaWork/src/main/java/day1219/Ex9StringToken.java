package day1219;

import java.util.StringTokenizer;

public class Ex9StringToken {

	public static void main(String[] args) {
		String msg = "red|green|yellow|white|black";
		String[] arr = msg.split("|");
//		for (String a : arr) {
//			System.out.println(a); // 잘 안됨
//		}
		
		StringTokenizer st = new StringTokenizer(msg, "|"); 
		System.out.println("분리할 총 토근 수: " + st.countTokens());
		
//		for (int i = 0; i < st.countTokens(); i++) {
//			System.out.print(st.nextToken() + " ");
//		}
		
		while (st.hasMoreTokens()) {
			System.out.print(st.nextToken() + " ");
		}
		System.out.println();
		
		String[] arr2 = msg.split("|");
		System.out.println("분리할 총 토근 수: " + arr2.length + "개");
		
		String[] arr3 = msg.split("\\|");
		System.out.println("분리할 총 토근 수: " + arr3.length + "개");
		for (String a : arr3) {
			System.out.print(a + " ");
		}
		System.out.println();
		
		String msg2 = "이미자.손태영.강호동.이영자.박진아";
		String[] arr4 = msg2.split("\\.");
		System.out.println("분리할 총 토근 수: " + arr4.length + "개");
		for (String a : arr4) {
			System.out.print(a + " ");
		}

		
	}

}
