package day1217;

import java.util.Scanner;

public class Ex12ArraySearch {

	public static void main(String[] args) {
		/*
		 * 검색한 성씨는? >> 이지혜
		 * 총 1명 검색
		 * 
		 * 검색할 성씨는? >> 홍
		 * "홍"씨 성을 가진 멤버는 없습니다.
		 * 
		 * 대소문자 상관없이 exit 입력 시 종료
		 */
		
		Scanner sc = new Scanner(System.in);
		
		String []member = {"강호동", "김태희", "손미나", "이지혜", "송중기", "김사랑", "손석구", "박미나", "강리나", "김신"};
		String searchName;
		int cnt;

		while (true) {
			System.out.print("검색할 성씨은? (종료: exit) >> ");
			searchName = sc.nextLine();
			cnt = 0;
			for (String name : member) {
				if (name.startsWith(searchName)) {
					cnt++;
				}
			}
			
			if (searchName.equalsIgnoreCase("exit")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			
			
			if (cnt == 0) {
				System.out.println("\"" + searchName + "\"씨 성을 가진 멤버는 없습니다.");
				break;
			}
			else {
				System.out.println("총 " + cnt + "명 검색");
			}
		}
		
	}

}
