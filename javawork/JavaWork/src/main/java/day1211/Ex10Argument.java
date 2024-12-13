package day1211;

public class Ex10Argument {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("double 형 Argument 값 읽기");
		
		double score1 = Double.parseDouble(args[0]);
		double score2 = Double.parseDouble(args[1]);
		double score3 = Double.parseDouble(args[2]);
		
		double total = score1 + score2 + score3;
		double average = total / 3;
		
		System.out.printf("점수 1 : %5.1f점\n", score1);
		System.out.printf("점수 2 : %5.1f점\n", score2);
		System.out.printf("점수 3 : %5.1f점\n", score3);
		System.out.printf("총  점 : %5.1f점\n", total);
		System.out.printf("평  균 : %5.1f점\n", average);


	}

}
