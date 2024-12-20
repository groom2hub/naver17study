package day1220;

import java.util.Scanner;

interface Command {
	public void process();
}

class List implements Command {
	@Override
	public void process() {
		System.out.println("1번을 누르면 데이터가 추가되었습니다.");
	}
}
class Insert implements Command {
	@Override
	public void process() {
		System.out.println("2번을 누르면 데이터가 출력되었습니다.");
	}
}
class Delete implements Command {
	@Override
	public void process() {
		System.out.println("3번을 누르면 데이터가 삭제되었습니다.");
	}
}
class Update implements Command {
	@Override
	public void process() {
		System.out.println("4번을 누르면 데이터가 수정되었습니다.");
	}
}

public class Ex11Interface {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("1. 추가 2. 출력 3. 삭제 4. 수정 5. 종료");
			switch(Integer.parseInt(sc.nextLine())) {
				case 1 -> {
					Command cmd = new List();
					cmd.process();
				}
				case 2 -> {
					Command cmd = new Insert();
					cmd.process();
	
				}
				case 3 -> {
					Command cmd = new Delete();
					cmd.process();
	
				}
				case 4 -> {
					Command cmd = new Update();
					cmd.process();
	
				}
				case 5 -> {
					System.out.println("5번을 누르면 프로그램을 종료합니다.");
					return;
				}
				default ->{
					System.out.println("잘못된 번호를 입력하였습니다.");
				}
			}
			System.out.println();
		}

	}

}
