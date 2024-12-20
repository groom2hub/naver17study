package day1219;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex11MyCarArray {

	public static void showTitle() {
		System.out.println("자동차명\t가격\t색상\t구입일");
		System.out.println("=".repeat(50));
	}
	public static void printMyCar(MyCar myCar) {
		System.out.println(myCar.getCarName() + "\t" + myCar.getCarPrice() + "\t" + myCar.getCarColor() + "\t" + myCar.getPurchaseDay() );
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		MyCar[] myCar;
		int cnt;
		
		System.out.print("등록할 자동차 갯수: ");
		cnt = Integer.parseInt(sc.nextLine());
		myCar = new MyCar[cnt];
		
		for (int i = 0; i < myCar.length; i++) {
			System.out.print("자동차명: ");
			String carName = sc.nextLine();
			System.out.print("자동차 색상: ");
			String carColor = sc.nextLine();
			System.out.print("자동차 가격: ");
			int carPrice = Integer.parseInt(sc.nextLine());
			
			myCar[i] = new MyCar(carName, carPrice,carColor);
			System.out.println();
		}
		
		showTitle();
		for (MyCar my : myCar) {
			printMyCar(my);
		}

	}

}
