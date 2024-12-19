package day1219;

public class Ex6VarArgs {
	
	public static int calcNum(int ...n) {
		int sum = 0;
		System.out.println("총 " + n.length + "개의 점수");
		for (int score : n) {
			System.out.print(score + " ");
			sum += score;
		}
		System.out.println();
		return sum;
		
	}
	
	public static void writeName(String ...name) {
			
	}

}
