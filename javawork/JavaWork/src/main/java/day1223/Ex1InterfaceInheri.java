package day1223;

interface InterA {
	public void study();
}

interface InterB extends InterA {
	public void play();
}

class MyInter implements InterB {
	
	@Override
	public void study() {
		System.out.println("그룹 스터디를 합니다.");
	}
	
	@Override
	public void play() {
		System.out.println("그룹 모임을 합니다.");
	}
	
	public void job() {
		System.out.println("밀린 일처리를 합니다.");
	}
}

public class Ex1InterfaceInheri {

	public static void main(String[] args) {
		InterA interA = new MyInter();
		interA.study();
		((MyInter) interA).play();
		((MyInter) interA).job();
		System.out.println("=".repeat(20));
		
		InterB interB = new MyInter();
		interB.study();
		interB.play();
		((MyInter) interB).job();
		System.out.println("=".repeat(20));

		MyInter my = new MyInter();
		my.study();
		my.play();
		my.job();
		
	}

}
