package day1227;

import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface MyEmployee {
	public void employeeAdd(String name);
}

@FunctionalInterface
interface Sales {
	public void itemAdd(String item, int num, int price);
}

public class Ex3Lambda {
	
	MyEmployee emp1 = (name) -> System.out.println(name + "사원 추가");
	
	Sales sale1 = (item, num, price) -> {
		System.out.println(item + "상품 등록");
		System.out.println("수량: " + num + "개");
		System.out.println("단가: " + price + "원");
		System.out.println("총 금액: " + (num * price) + "원");
		System.out.println("=".repeat(20));
	};
	
	public static void main(String[] args) {
		
		Ex3Lambda ex3 = new Ex3Lambda();
		ex3.emp1.employeeAdd("홍길동");
		ex3.emp1.employeeAdd("이영자");
		System.out.println();
		
		System.out.println("=".repeat(20));
		ex3.sale1.itemAdd("딸기", 5, 9000);
		ex3.sale1.itemAdd("오렌지", 3, 2000);
		
		System.out.println("List 데이터를 람다식으로 출력");
		List<String> list1 = Arrays.asList("빨강", "노랑", "분홍", "초록", "검정");
		
		System.out.print("출력 1 >> ");
		for (String s : list1) {
			System.out.print(s + " ");
		}
		System.out.println();
		
		System.out.print("출력 2 >> ");
		list1.forEach(s -> System.out.print(s + " "));
		
	}
	
}
