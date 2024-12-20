package day1220;

class SuperObj1 {
	SuperObj1() {
		System.out.println("Super 생성자");
	}
	
	SuperObj1(String msg) {
		System.out.println("Super msg: " + msg);
	}
}

class SubObj1 extends SuperObj1 {
	SubObj1() {
		// 첫줄에 super(), 직접 쓸 경우 첫줄
		super(); // 부모의 디폴트 생성자 호출
		System.out.println("Sub 생성자");// TODO Auto-generated constructor stub
	}
	

	SubObj1(String msg) {
		// 첫줄에 super(), 직접 쓸 경우 첫줄
		super(msg); // 부모의 디폴트 생성자 호출
		System.out.println("Sub 두번째 생성자");// TODO Auto-generated constructor stub
	}
}

public class Ex1Inheri {

	public static void main(String[] args) {
		SubObj1 s1 = new SubObj1();
		System.out.println();
		SubObj1 s2 = new SubObj1("2번째 생성자");
		
		

	}

}
