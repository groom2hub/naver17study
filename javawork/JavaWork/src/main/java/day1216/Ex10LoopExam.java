package day1216;

public class Ex10LoopExam {
	public static void main(String[] args) {
		System.out.println("=".repeat(63));
		for (int i = 2; i <= 9; i++) {
			System.out.printf("[%d단]\t", i);
		}
		System.out.println();
		System.out.println("=".repeat(63));
		
		for (int i = 1; i <= 9; i++) {
			for (int j = 2; j <= 9; j++) {
				System.out.printf("%dX%d=%d\t", j, i, j * i);
			}
			System.out.println();
		}
	}
	
}
