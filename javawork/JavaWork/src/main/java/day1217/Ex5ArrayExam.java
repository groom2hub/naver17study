package day1217;

public class Ex5ArrayExam {

	public static void main(String[] args) {
		int []data = {23, 10, -56, 234, 11, 88, 99, -120, 7, 10};
		int max = data[0];
		int min = data[0];
		for (int i = 1; i < data.length; i++) {
//			max = data[i] > max? data[i] : max;
			if (max < data[i]) {
				max = data[i];
			}
			
			if (min > data[i]) {
				min = data[i];
			}
		}
		
		System.out.println("max = " + max);
		System.out.println("min = " + min);
		
	}

}
