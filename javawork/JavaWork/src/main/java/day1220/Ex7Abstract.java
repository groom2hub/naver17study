package day1220;

import java.util.List;
import java.util.Vector;

public class Ex7Abstract {

	public static void main(String[] args) {
		// 다형성 처리 예시
		List<String> list = null;
		list = new Vector<String>();
		list.add("Red"); // add 메서드는 오버라이드 메서드
		list.add("Green");
		for (String s : list) {
			System.out.println(s);
		}
		
		// 현재 할당된 크기를 알아보는 capacity() Vector에만
		int n = ((Vector<String>)list).capacity();
		System.out.println(n);
		
	}

}
