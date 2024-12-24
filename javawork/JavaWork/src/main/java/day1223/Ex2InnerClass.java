package day1223;

class OuterObj {
	int a = 10;
	static int b = 20;
	private int c = 30;
	
	class InnerObj {
		int x = 40;
		static int y = 50;
		
		public void disp() {
			System.out.println("a = " + a);
			System.out.println("b = " + b);
			System.out.println("c = " + c);
			System.out.println("x = " + x);
			System.out.println("y = " + y);
		}
	}
	
	public void outerDisp() {
		InnerObj inObj = new InnerObj();
		inObj.disp();
	}
	
}

public class Ex2InnerClass {

	public static void main(String[] args) {
		OuterObj obj1 = new OuterObj();
		obj1.outerDisp();
		System.out.println();
		
		OuterObj.InnerObj obj2 = new OuterObj().new InnerObj();
		obj2.disp();
		
	}

}
