package day1212;

public class Ex4operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 관계 연산자(>, <, >=, <=, ==), 논리 연산자
		int kor = 89, eng = 100, mat = 89;
		boolean f = false;
		
		System.out.println(kor > eng);
		System.out.println(kor < eng);
		System.out.println(kor == eng);
		System.out.println(kor != eng);
		System.out.println(kor > eng && eng > mat);
		System.out.println(kor > eng || eng > mat);
		System.out.println(!(kor > eng));
		System.out.println(!f);
			
	}

}
