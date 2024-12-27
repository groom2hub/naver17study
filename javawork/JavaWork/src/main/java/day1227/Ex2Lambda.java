package day1227;

interface Orange {
	public void write();
}

interface DataAdd {
	public void add(int x, int y);
}

public class Ex2Lambda {
	
	Orange or = new Orange() {
		
		@Override
		public void write() {
			System.out.println("오렌지 익명 내부 클래스 형태");
		}
	};
	
	public void lambdaMethod() {
		Orange orange1 = () -> System.out.println("람다식 오렌지 메서드 호출");
		orange1.write();
		
		Orange orange2 = () -> System.out.println("안녕하세요. 람다씨!");
		orange2.write();
		
		DataAdd add1 = (int x, int y) -> System.out.println(x + " + " + y + " = " + (x+y));
		add1.add(10, 20);
		add1.add(3, 5);
		
	}
	
	public static void main(String[] args) {
		
		Ex2Lambda ex2 = new Ex2Lambda();
		ex2.or.write();
		ex2.lambdaMethod();
		
	}
	
}
