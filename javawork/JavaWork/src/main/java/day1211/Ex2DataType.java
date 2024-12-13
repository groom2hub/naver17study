package day1211;

public class Ex2DataType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int kor = 90;
		int eng = 93;
		
		System.out.println("합계 = " + kor + eng); // 합계 = 9093
		System.out.println("합계 = " + (kor + eng));

		
		// 진법 변환
		int a = 056; // 8진수로 인식
		int b = 0x12a; // 16진수로 인식
		System.out.println("a = " + a); // 8진수를 10진수로 변경 > 5 * 8 + 6 * 1 = 46
		System.out.println("b = " + b); // 16진수를 10진수로 변경 > 1 * 16^2 + 2 * 16^1 + 10 * 16^0 = 298
		
		int c = 047;
		int d = 0xa9;
		System.out.println("c = " + c); // 4 * 8 + 7 * 1 = 39
		System.out.println("d = " + d); // 10 * 16^1 + 9 * 16^0 = 169

	}

}
