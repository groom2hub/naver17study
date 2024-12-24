package day1223;

abstract class AbstEmployee {
	abstract public void addEmployee();
	abstract public void removeEmployee();
}

interface InterSales {
	public void insertItem();
	public void selectItem();
}

public class Ex4InnerClass {
	AbstEmployee abstEmp = new AbstEmployee() {
		
		@Override
		public void removeEmployee() {
			System.out.println("사원을 제거합니다.");
		}
		
		@Override
		public void addEmployee() {
			System.out.println("사원을 추가합니다.");
		}
	};
	
	InterSales sales = new InterSales() {
		
		@Override
		public void selectItem() {
			System.out.println("상품을 추가합니다.");
		}
		
		@Override
		public void insertItem() {
			System.out.println("상품을 선택합니다.");
		}
	};

	public static void main(String[] args) {
		Ex4InnerClass ex4 = new Ex4InnerClass();
		
		ex4.abstEmp.addEmployee();
		ex4.abstEmp.removeEmployee();
		System.out.println();
		
		ex4.sales.insertItem();
		ex4.sales.selectItem();
		System.out.println();
		
	}

}
