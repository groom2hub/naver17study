package day1224;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Ex4Set {

	public static void main(String[] args) {
		Set<Integer> set1 = new HashSet<>();
		Set<Integer> set2 = new TreeSet<Integer>();

		set1.add(300);
		set1.add(100);
		set1.add(200);
		set1.add(500);

		set2.add(100);
		set2.add(300);
		set2.add(100);
		set2.add(200);
		set2.add(500);

		System.out.println("set1의 갯수: " + set1.size());
		System.out.println("set2의 갯수: " + set2.size());

		System.out.println("HashSet 결과");
		for (Integer n : set1) {
			System.out.print(n + " "); // 비순차적으로 출력
		}
		System.out.println();

		System.out.println("TreeSet 결과");
		for (Integer n : set2) {
			System.out.print(n + " "); // 오름차순으로 출력
		}
		System.out.println();

	}

}
