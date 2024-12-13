package day1212;

public class Ex5operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 조건(삼항)연산자 		조건식1 ? 참일때 값 : 거짓일때 값
		// 조건식이 여러개일 경우 	조건식1 ?  참 : 조건식2 ? 참 : 조건식3 ? 참 : 거
		int x, y, max;
		x = 5;
		y = 13;
		
		max = x > y ? x : y;
		System.out.println("max = " + max);
		
		int z = 20;
		
		max = x > y && x > z ? x : y > x && y > z ? y : z; 
		System.out.println("max = " + max);
		
		int score = 89;
		char grade;
		
		grade = score >= 90 ? 'A' : score >= 80 ? 'B' : score >= 70 ? 'C' : score >= 60 ? 'D' : 'F';
		System.out.println(score + "점은 " + grade + "학점입니다.");
		
		System.out.println(score + "점은 " + (score >= 90 ? "Good!!" : "Try!!"));
		
	}

}
