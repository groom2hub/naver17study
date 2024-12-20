package day1219;

import java.util.StringTokenizer;

public class Ex10MyCarArray {

	public static void showTitle() {
		System.out.println("자동차명\t가격\t색상\t구입일");
		System.out.println("=".repeat(50));
	}
	public static void printMyCar(MyCar myCar) {
		System.out.println(myCar.getCarName() + "\t" + myCar.getCarPrice() + "\t" + myCar.getCarColor() + "\t" + myCar.getPurchaseDay() );
	}

	public static void main(String[] args) {
		MyCar my1 = new MyCar();
		System.out.println(my1); // toString이 있을 경우 자동 호출

		MyCar my2 = new MyCar("소나타", 3900, "진주색"); 
		System.out.println(my1);

		//		System.out.println("객체 배열 생성");
		//		MyCar[] carArray = {
		//				new MyCar(),
		//				new MyCar("그랜져", 5600, "검정색"),
		//				new MyCar("BMW", 6700, "흰색")
		//		};

		MyCar[] carArray = new MyCar[3];
		carArray[0] = new MyCar();
		carArray[1] = new MyCar("그랜져", 5600, "검정색");
		carArray[2] = new MyCar("BMW", 6700, "흰색");

		showTitle();
		for (MyCar myCar : carArray) {
			printMyCar(myCar);
		}

	}

}
