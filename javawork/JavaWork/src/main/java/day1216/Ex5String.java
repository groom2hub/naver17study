package day1216;

public class Ex5String {
	public static void main(String[] args) {
		System.out.println("String 클래스의 멤버 메소드에 대한 공부");
		
		String str1 = "Apple";
		String str2 = "Have a Nice Day!!";
		String str3 = "Orange";
		String str4 = "Apple";
		
		System.out.println("str1 = " + str1);
		System.out.println("str2 = " + str2);
		System.out.println("str3 = " + str3);
					
		System.out.println("str2의 길이 = " + str2.length());
		System.out.println("str2의 0번 글자 = " + str2.charAt(0));
		System.out.println("str2의 3번 글자 = " + str2.charAt(3));
		System.out.println("str2의 1번 글자 = " + str2.charAt(1));
		
		System.out.println();
		System.out.println("str1에서 l의 위치 = " + str1.indexOf('l'));
		System.out.println("str2에서 a의 위치 = " + str2.indexOf('a'));
		System.out.println("str2에서 마지막 a의 위치 = " + str2.lastIndexOf('a'));
		System.out.println("str3에서 x의 위치 = " + str3.indexOf('x')); // 해당 문자가 없을 경우 -1
		
		System.out.println();
		System.out.println(str1 == "Apple");
		System.out.println(str3 == "Orange");
		System.out.println(str1 == "apple");
		
		// 문자열을 정확하게 비교하기 위해서는 equals 사용
		System.out.println();
		System.out.println(str1.equals(str4));
		System.out.println(str1.equals("apple"));
		System.out.println(str1.equalsIgnoreCase("apPLe")); // 대소문자 상관없이 철자만 맞으면 true
		
		System.out.println();
		System.out.println("문자열 비교 - compareTo");
		int n = str1.compareTo("Apple");
		System.out.println(n); // 0: 대소문자까지 같은 경우
		
		n = str1.compareTo("Banana"); // 문자열1이 문자열2보다 작을 경우 -1
		System.out.println(n);
		
		n = str3.compareTo(str1); // 알파벳 순서가 거꾸로 되어 있을 경우 14		
		System.out.println(n);
		
		System.out.println();
		System.out.println("대,소문자 변환");
		System.out.println("str2를 모두 대문자로 변환: " + str2.toUpperCase());
		System.out.println("str2를 모두 소문자로 변환: " + str2.toLowerCase());
		
		System.out.println();
		System.out.println("시작, 끝 단어 확인");
		System.out.println("str2가 Have로 시작하면 true >> " + str2.startsWith("Have"));
		System.out.println("str2가 Happy로 시작하면 true >> " + str2.startsWith("Happy"));
		System.out.println("str2가 Day로 끝나면 true >> " + str2.startsWith("Day"));
		System.out.println("str2가 Day!!로 끝나면 true >> " + str2.startsWith("Day!!"));
		

		System.out.println();
		System.out.println("문자열 반복");
		System.out.println("=".repeat(50));
		System.out.println(str1.repeat(5));
		System.out.println("*".repeat(30));

		System.out.println();
		System.out.println("문자열 교체");
		System.out.println(str2.replace('a', '*'));
		System.out.println(str2.replace("Nice", "Happy"));

		System.out.println();
		System.out.println("문자열 추출");
		System.out.println(str2.substring(7));
		System.out.println(str2.substring(7, 10));

		System.out.println();
		System.out.println("문자열 분리");
		String str5 = "red,green,blue,gray,black,white";
		System.out.println(str5);
		String []array = str5.split(",");
		for (String a : array) {
			System.out.println(a);	
		}

		System.out.println();
		System.out.println("앞, 뒤 공백 제거");
		String str6 = "  Hello  ";
		System.out.println("*" + str6 + "*");
		System.out.println("*" + str6.trim() + "*");

		System.out.println();
		System.out.println("String 타입으로 형변환");
		String s1 = String.valueOf(100);
		String s2 = String.valueOf(true);
		String s3 = String.valueOf(34.6);
		String s4 = String.valueOf('A');
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		
		
		
	}
	
}
