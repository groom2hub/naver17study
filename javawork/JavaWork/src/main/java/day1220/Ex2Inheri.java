package day1220;

class SuperObj2 {
	private String schoolName;
	SuperObj2() {
		schoolName = "청담고등학교";
	}
	
	SuperObj2(String schoolName) {
		this.schoolName = schoolName;
	}
	
	public void print() {
		System.out.println("학교명: " + schoolName);
	}
}

class SubObj2 extends SuperObj2 {
	private String studentName;
	
	SubObj2() {
		studentName = "이름 없음";
	}
	
	SubObj2(String schoolName, String studentName) {
		super(schoolName);
		this.studentName = studentName;
	}
	
	@Override
	public void print() {
		super.print(); // 부모가 처리한 로직 실행, 호출 위치 상관 없음
		System.out.println("학생 이름: " + studentName);
	}
	
}

class SubObj22 extends SuperObj2 {
	private String teacherName;
	
	SubObj22() {
		teacherName = "이름 없음";
	}
	
	SubObj22(String schoolName, String teacherName) {
		super(schoolName);
		this.teacherName = teacherName;
	}
	
	@Override
	public void print() {
		super.print(); // 부모가 처리한 로직 실행, 호출 위치 상관 없음
		System.out.println("선생님 이름: " + teacherName);
	}
}

public class Ex2Inheri {

	public static void main(String[] args) {
		SubObj2 s1 = new SubObj2();
		SubObj2 s2 = new SubObj2("강남고등학교", "홍길동");
		SubObj22 s3 = new SubObj22("강남고등학교", "강호동");
		
		s1.print();
		System.out.println();
		s2.print();
		System.out.println();
		s3.print();
		System.out.println();

	}

}
