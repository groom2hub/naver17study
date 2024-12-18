package day1217;

public class Ex15ArrayRandom {

	public static void main(String[] args) {
		int []numbers = new int[50];
		
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (int)(Math.random() * 50) + 1;
			for(int j = i + 1; j < numbers.length; j++) {
				if (numbers[j] == numbers[i]) {
					i--;
					break;
				}
					
			}
		}
		
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(i + ": " + numbers[i]);
		}
		
	}

}
