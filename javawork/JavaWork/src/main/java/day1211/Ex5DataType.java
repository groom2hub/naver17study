package day1211;

public class Ex5DataType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char ch1 = 'A';
		char ch2 = '가';
		
		System.out.println("ch1 = " + ch1);
		System.out.println("ch1 = " + ch1);
		
		System.out.printf("ch1 = %c\tch2 = %c\n", ch1, ch2);
		System.out.printf("ch1 = %d\tch2 = %d\n", (int)ch1, (int)ch2); // ascii code로 변환
		
		int a = 65;
		System.out.println(a); // 65
		System.out.println(a+32); // 97
		System.out.println((char)a); // A
		System.out.println((char)(a+32)); // a
		
		System.out.printf("%c, %c, %c, %c\n", a, a+2, a+33, a+40);
		System.out.printf("%c, %c, %c, %c\n", 65, 68, 74, 83);

	}

}
