package day1223;

interface RemoteControl {
	int MAX_VOLUNM = 10;
	int MIN_VOLUNM = 0;
	
	public void turnOn();
	public void turnOff();
	public void setVolunm(int volumn);
	
	default void setMote(boolean mute) {
		if (mute) {
			System.out.println("무음 처리합니다.");
			setVolunm(MIN_VOLUNM);
		} else {
			System.out.println("무음 해제합니다.");
		}
	}
}

class Television implements RemoteControl {
	int volumn = MAX_VOLUNM;

	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다.");	
	}

	@Override
	public void setVolunm(int volumn) {
		this.volumn = volumn;
		System.out.println("현재 볼륨은 " + this.volumn + "입니다.");
	}
	
}

public class Ex5DefaultInterface {

	public static void main(String[] args) {
		Ex5DefaultInterface ex5 = new Ex5DefaultInterface();
		RemoteControl rc1 = null;
//		rc1.setMote(false);
		rc1 = new Television();
		rc1.turnOn();
		rc1.turnOff();
		rc1.setMote(false);
		rc1.setMote(true);
		
		
	}

}
