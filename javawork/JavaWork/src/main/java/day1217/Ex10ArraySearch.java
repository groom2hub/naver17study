package day1217;

import java.util.Scanner;

public class Ex10ArraySearch {

	public static void main(String[] args) {
		/*
		 * 숫자를 입력하면 그 숫자가 몇번째 있는지 출력
		 * 없을 경우 "해당 숫자가 없습니다." 출력
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int []data = {12, 5, 8, 10, 9, 16, 19, 3, 1, 7};
		int searchNum;
		boolean find;

		while (true) {
			find = false;
			System.out.print("검색할 숫자는? (종료: 0) >> ");
			searchNum = sc.nextInt();
			if (searchNum == 0) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			
			for (int i = 0; i < data.length; i++) {
				if (searchNum == data[i]) {
					find = true;
					System.out.println((i + 1) + "번째에 있습니다.");
				}
			}
			
			if (!find) {
				System.out.println("해당 숫자는 없습니다.");
			}
		}
			
	}

}
