package day1217;

import java.util.Scanner;

public class Ex11ArraySearch {

	public static void main(String[] args) {
		/*
		 * 숫자를 입력하면 그 숫자가 몇번째 있는지 출력
		 * 없을 경우 "해당 숫자가 없습니다." 출력
		 */
		
		Scanner sc = new Scanner(System.in);
		
		String []member = {"강호동", "김태희", "손미나", "이지혜", "송중기", "김사랑", "손석구", "박미나", "강리나", "김신"};
		String searchName;
		boolean find;

		while (true) {
			find = false;
			System.out.print("검색할 이름은? (종료: 0) >> ");
			searchName = sc.nextLine();
			if (searchName.equals("0")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			
			for (int i = 0; i < member.length; i++) {
				if (member[i].equals(searchName)) {
					find = true;
					System.out.println((i + 1) + "번째에 있습니다.");
				}
			}
			
			if (!find) {
				System.out.println("해당 이름은 없습니다.");
			}
		}
		
	}

}
