package day1223;

abstract class AbstEx {
	abstract public void show();
}

interface MyDB {
	public void list();
	public void insert();
}

class SubMyDB implements MyDB {
	
	@Override
	public void list() {
		System.out.println("리스트 출력2");
	}
	
	@Override
	public void insert() {
		System.out.println("데이터 추가2");	
	}
	
}

public class Ex3InnerClass {
	
	AbstEx abst1 = new AbstEx() {
		
		@Override
		public void show() {
			System.out.println("show 호출");
		}
	};
	
	MyDB myDB = new MyDB() {
		
		@Override
		public void list() {
			System.out.println("DB의 데이터를 조회합니다.");
		}
		
		@Override
		public void insert() {
			System.out.println("DB에 데이터를 추가합니다.");	
		}
	};
	
	MyDB myDB2 = new SubMyDB();

	public static void main(String[] args) {
		Ex3InnerClass ex3 = new Ex3InnerClass();
		ex3.abst1.show();
		System.out.println();
		
		ex3.myDB.insert();
		ex3.myDB.list();
		System.out.println();
		
		ex3.myDB2.insert();
		ex3.myDB2.list();
		
	}

}
