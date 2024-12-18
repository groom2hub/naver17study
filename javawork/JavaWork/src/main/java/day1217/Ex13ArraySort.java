package day1217;

public class Ex13ArraySort {

	public static void main(String[] args) {
		/*
		 * 배열에 1~50 사이의 난수 20개를 구하여 넣고
		 * 오름차순으로 정렬해서 출력하시오.
		 */
		
		int []numbers = new int[20];
		int number;
		boolean duplicated;
		
		for (int i = 0; i < numbers.length; i++) {
			number = (int)(Math.random() * 50) + 1;
			
			duplicated = false;
			for (int j = 0; j < i; j++) {
				if (number == numbers[j]) {
					duplicated = true;
					break;
				}
			}
			
			if (duplicated) {
				i--;
			}
			else {
				numbers[i] = number;
			}
		}
		
		for (int i = 0; i < numbers.length; i++) {
			for(int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] > numbers[j]) {
					int temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
					
			}
		}
		
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(i + ": " + numbers[i] + "\t");
			if (i % 5 == 4) {
				System.out.println();
			}
		}
		
	}

}
