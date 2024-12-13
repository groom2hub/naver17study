package day1212;

import java.util.Date;
import java.util.Scanner;

public class Ex15If {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		/*
		 * 상품(sang)과 수량(su), 단가(dan)을 입력 받은 후
		 * 총 금액(total)을 출력하시오.
		 * 단, 수량이 5개 이상이면 총 금액의 10프로 할인된 금액으로 출력하시오. 
		 *  
		 *  
		 *  (예)
		 *  상품명 : 바나나킥
		 *  수량 : 5개
		 *  단가 : 1000원
		 *  총 금액 : 4500원
		 *  
		 *  10프로 DC된 금액은 4500원입니다. => 5개 이상인 경우에만 출력되는 문 
		 *  
		 * */
		
		String sang;
		int su, dan, total;
		
		System.out.println("상품을 입력하시오.");
		sang= sc.nextLine();
		System.out.println("수량을 입력하시오.");
		su = sc.nextInt();
		System.out.println("단가를 입력하시오.");
		dan = sc.nextInt();
		total = su * dan;
		System.out.println("상품명 : " + sang);
		System.out.println("수량 : " + su + "개");
		System.out.println("단가 : " + dan + "원");
		
		if (su < 5)
			System.out.println("총 금액은 " + total + "원입니다.");
		else
			total = (int)(total * 0.9);
			System.out.println("10프로 DC된 금액은" + total + "원입니다.");
		
		
		
	}

}
