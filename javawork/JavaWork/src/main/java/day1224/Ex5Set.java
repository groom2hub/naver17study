package day1224;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Ex5Set {
	
	public static void main(String[] args) {
		Set<String> set1 = new HashSet<>();
		Set<String> set2 = new TreeSet<String>();
		
		set1.add("강리나");
		set1.add("이홍기");
		set1.add("강리나");
		set1.add("이영자");

		set2.add("강리나");
		set2.add("이홍기");
		set2.add("강리나");
		set2.add("이영자");
		
		System.out.println("set1의 갯수: " + set1.size());
		System.out.println("set2의 갯수: " + set2.size());
		
		System.out.println("HashSet 결과");
		for (String n : set1) {
			System.out.print(n + " "); // 비순차적으로 출력
		}
		System.out.println();
		
		System.out.println("TreeSet 결과");
		for (String n : set2) {
			System.out.print(n + " "); // 오름차순으로 출력
		}
		System.out.println();
		
	}

}