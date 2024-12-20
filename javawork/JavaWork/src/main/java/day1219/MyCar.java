package day1219;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyCar {
	private String carName;
	private int carPrice;
	private String purchaseDay;
	private String carColor;
	
	public MyCar() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm");
		purchaseDay = sdf.format(new Date());
		carColor = "흰색";
	}

	public MyCar(String carName, int carPrice, String carColor) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm");
		purchaseDay = sdf.format(new Date());
		this.carName = carName;
		this.carPrice = carPrice;
		this.carColor = carColor;
		
	}

	@Override
	public String toString() {
		return "MyCar [carName: " + carName + ", carPrice: " + carPrice + ", carColor: " + carColor + "]";
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public int getCarPrice() {
		return carPrice;
	}

	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}

	public String getPurchaseDay() {
		return purchaseDay;
	}

	public void setPurchaseDay(String purchaseDay) {
		this.purchaseDay = purchaseDay;
	}

	public String getCarColor() {
		return carColor;
	}

	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}
}
