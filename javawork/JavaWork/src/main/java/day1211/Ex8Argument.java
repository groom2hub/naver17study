package day1211;

public class Ex8Argument {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("외부에서 값 읽어오기");
		String name = args[0];
		String city = args[1];
		int birthYear = Integer.parseInt(args[2]);
		int age = 2024 - birthYear;
		
		System.out.println("이름 : " + name);
		System.out.println("지역 : " + city);
		System.out.println("태어난 년도 : " + birthYear + "나이 : " + age + "세");
		
		int kor = Integer.parseInt(args[3]);
		int eng = Integer.parseInt(args[4]);
		int total = kor + eng;
		double average = total / 2.0; // int + int = int, int + double = double
		
		System.out.println("국어점수 : " + kor + "점");
		System.out.println("영어점수 : " + eng + "점");
		System.out.println("총점 : " + total + "점");
		System.out.println("평균 : " + average + "점");
		

	}

}
