package day1220;

/*
 * 추상 클래스는 객체 생성을 할수없다.
 * 자식 클래스로 하여금 반드시 구현하게 할 목적으로 추상메서드를 만든다.
 * 만약 자식클래스가 추상메서드를 오버라이드를 안 했을 경우 그 클래스도 추상화시켜야한다.
 * */
abstract class Parent2 {
	// 부모가 process 에서 하는일이 없을 경우
	// 안만들면 자식클래스에서 오버라이드를 할수 없다.
	// 이럴경우 미완성으로 선언만 하는데 이럴 경우 abstract 메서드로 만든다.
	abstract public void process(); // 추상메서드는 일반 클래스에 멤버로 올 수 없다.
	
	// 추상 클래스는 추상 메서드뿐만 아니라 일반메서드도 구현이 가능하다.
	// 부모만이 가진 메서드
	public void study() {
		System.out.println("자바 공부를 한다");
	}
}

class Your1 extends Parent2 {
	@Override
	public void process() {
		System.out.println("벽지공사를 합니다");
	}
	
	public void draw() {
		System.out.println("그림을 그린다");
	}
}

class Your2 extends Parent2 {
	@Override
	public void process() {
		System.out.println("타일공사를 합니다");
	}
}

public class Ex6Abstract {

	public static void yourProcess(Parent2 p) {
		p.process();
		p.study();
		
//		p.draw(); // 오류 발생
//		p 에 Your2가 생성되어있는 경우 오류 발생
		((Your1)p).draw(); // 다운캐스팅 후 호출
	}
	
	public static void main(String[] args) {
		yourProcess(new Your1());
		System.out.println("=".repeat(30));
//		yourProcess(new Your2());
		
//		yourProcess(new Parent2()); // 오류: 추상클래스는 new로 생성할 수 없다
	}

}










