package day1220;

import day1220_2.Apple;

class Banana extends Apple {
	public void play() {
		this.job(); //public
		this.study(); //protected
		// this.draw(); //오류발생(default): 패키지가 다를 경우 상속 관계라도 접근 불가
		this.process(); // 현재 클래스의 오버라이드 메서드가 호출된다
	}
	
	@Override
	protected void process() {
	// void process() { // 오류
	// private void process() { // 오류
	// public void process() {
		super.process();
		System.out.println("Oracle,Mysql 공부를 더 깊게 합니다");
	}
}

public class Ex4Inheri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Banana banana = new Banana();
		banana.play();
	}

}
