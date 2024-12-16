package day1216;

public class Ex4ForLabel {
	public static void main(String[] args) {
		Loop:
			for (int i = 0; i <= 3; i++) {
				for (int j = 0; j <= 4; j++) {
					if (i == 2) {
						continue Loop; // i++로 이동
					}

					if (j == 3) {
						continue Loop; // i++로 이동
					}
					
					System.out.println("i = " + i + ", j = "+ j);
				}
			}
		
	}
	
}
