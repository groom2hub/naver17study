package day1211;

public class Ex4DataType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int year = 2024;
		int month = 12;
		int day = 11;
		
		int year2 = 2024;
		int month2 = 5;
		int day2 = 3;
		
		System.out.println(year + "-" + month + "-" + day);
		System.out.printf("%d-%d-%d", year, month, day);
		
		int money = 23560000;
		System.out.printf("이번달 급여 = %10d원 \n", money);
		System.out.printf("이번달 급여 = %-10d원 \n", money); // -는 왼쪽부터 출력

	}

}
