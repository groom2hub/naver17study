package day1211;

public class Ex9Argument {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("메인 Argument 값 읽기 문제");
		String name = args[0];
		String emp = args[1];
		String dep = args[2];
		int score1 = Integer.parseInt(args[3]);
		int score2 = Integer.parseInt(args[4]);
		int score3 = Integer.parseInt(args[5]);
		
		int total = score1 + score2 + score3;
		double average = total / 3.0;
		
		System.out.printf("이름 : %s\n", name);
		System.out.printf("회사 : %s\n", emp);
		System.out.printf("부서 : %s\n", dep);
		System.out.printf("입사 시험 점수 : %d, %d, %d\n", score1, score2, score3);
		System.out.printf("입사 시험 점수의 총점 : %s\n", total);
		System.out.printf("입사 시험 점수의 평균 : %.1f\n", average);

	}

}
