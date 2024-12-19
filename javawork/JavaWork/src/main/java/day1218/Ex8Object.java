package day1218;


class Orange {
	public static final String MESSAGE = "Happy";
	
	private String name;
	private int age;
	
	public void showData() {
		// 일반 멤버 메서드는 this라는 인스턴스 변수를 가지고 있다.
		// static 멤버 메서드에는 this가 없음
		System.out.println("이름: " + this.name + ", 나이: " + this.age);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
}

public class Ex8Object {
	
	public static void main(String[] args) {
		System.out.println(Orange.MESSAGE);
		
		Orange orange = new Orange();
//		System.out.println("이름: " + orange.name); // private 변수는 직접 접근 불가
		orange.showData();
		
		orange.setName("Apple");
		orange.setAge(10);
		orange.showData();
				
	}

}
