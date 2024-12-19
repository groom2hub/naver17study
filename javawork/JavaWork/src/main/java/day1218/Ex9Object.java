package day1218;


class Car {
	static String carCompany = "현대";
	private String carName;
	private int carPrice;
	
	public void showData() {
		// 일반 멤버 메서드는 this라는 인스턴스 변수를 가지고 있다.
		// static 멤버 메서드에는 this가 없음
		
	}
	
	public static void setCarCompany(String carCompany) {
		Car.carCompany = carCompany;
	}
	
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}
	public void setData(String carName, int carPrice) {
		this.setCarName(carName);
		this.setCarPrice(carPrice);
	}
	
	public String getCarName() {
		return carName;
	}
	public int getCarPrice() {
		return carPrice;
	}
}

public class Ex9Object {
	
	public static void printCarInfo(Car myCar) {
		System.out.println("자동차명:" + myCar.getCarName());
		System.out.println("가격:" + myCar.getCarPrice());
		System.out.println("=".repeat(30));
	}
	
	public static void main(String[] args) {
		System.out.println("현재 자동차 회사명: " + Car.carCompany);
		
		Car.setCarCompany("삼성");
		System.out.println("변경된 자동차 회사명: " + Car.carCompany);
		
		
		System.out.println("=".repeat(30));
		Car car1 = new Car();
		car1.setCarName("그랜저");
		car1.setCarPrice(3900);
		
		Car car2 = new Car();
		car2.setData("소나타", 3200);
		

		Car car3 = new Car();
		car3.setCarName("Mini");
		car3.setCarPrice(5000);
		

//		System.out.println("car1 자동차명:" + car1.getCarName());
//		System.out.println("car1 가격:" + car1.getCarName());
//		System.out.println("=".repeat(30));
//		System.out.println("car2 자동차명:" + car2.getCarName());
//		System.out.println("car2 가격:" + car2.getCarName());
		printCarInfo(car1);
		printCarInfo(car2);
		printCarInfo(car3);
		
	}

}
