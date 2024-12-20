package day1219;

import java.util.Scanner;

public class Ex8StringBuffer {

	public static void main(String[] args) {
		String str = "Happy";
		// String -> StringBuffer
		StringBuffer sb = new StringBuffer(str);
		
		// 인스턴스 변수인 경우 변수명만 출력 시 자동으로 toString() 호출
		// toString을 갖지 않는 경우 값이 아닌 주소가 출력
		System.out.println(sb);
		System.out.println(sb.toString());
		
		// String은 값 자체를 변경할 수 없지만 StringBuffer는 문자열 편집이 가능
		sb.append('A');
		sb.append(100);
		sb.append("Bitcamp");
		System.out.println(sb);
		
		sb.delete(5, 9);
		System.out.println(sb);
		
		sb.insert(3, "Java");
		System.out.println(sb);

		sb.replace(3, 7, "Hello");
		System.out.println(sb);
		
		String name = "캔디";
		int age = 23;
		
		StringBuffer sb2 = new StringBuffer();
		sb2.append("{\"name\":");
		sb2.append("\"" + name +"\",");
		sb2.append("\"age\":");
		sb2.append(age + "}");
		System.out.println(sb2);
		
	}

}
