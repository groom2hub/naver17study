package day1218;

import java.text.NumberFormat;

public class BookCar {
	private int speed;
	private boolean stop;
	
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		if (speed < 0) {
			this.speed = 0;
		} else {
			this.speed = speed;
		}
	}
	public boolean isStop() {
		return stop;
	}
	public void setStop(boolean stop) {
		this.stop = stop;
		if (stop == true) {
			this.speed = 0;
		}
	}
	
	
	public static void main(String[] args) {
		BookCar myCar = new BookCar();
		
		myCar.setSpeed(-50);
		System.out.println("현재 속도: "  + myCar.getSpeed());

		myCar.setSpeed(60);
		System.out.println("현재 속도: "  + myCar.getSpeed());
		
		
		if (myCar.isStop()) {
			myCar.setStop(true);
		}
		System.out.println("현재 속도: "  + myCar.getSpeed());
		
	}

}
