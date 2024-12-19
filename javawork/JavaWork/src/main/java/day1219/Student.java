package day1219;


class a {
	public static final String MESSAGE = "Happy";
	
	private String name;
	private int age;
	
	public void showData() {
		// 일반 멤버 메서드는 this라는 인스턴스 변수를 가지고 있다.
		// static 멤버 메서드에는 this가 없음
		System.out.println("이름: " + this.name + ", 나이: " + this.age);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
}

public class Student {
	private String stuName;
	private String stuAddress;
	private String stuBlood;
	private int stuBirthYear;
	private int stuScore;
	

	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuAddress() {
		return stuAddress;
	}
	public void setStuAddress(String stuAddress) {
		this.stuAddress = stuAddress;
	}
	public String getStuBlood() {
		return stuBlood;
	}
	public void setStuBlood(String stuBlood) {
		this.stuBlood = stuBlood;
	}
	public int getStuBirthYear() {
		return stuBirthYear;
	}
	public void setStuBirthYear(int stuBirthYear) {
		this.stuBirthYear = stuBirthYear;
	}
	public int getStuScore() {
		return stuScore;
	}
	public void setStuScore(int stuScore) {
		this.stuScore = stuScore;
	}

	public void changeStudent(String stuName, String stuAddress, String Blood) {
		this.stuName = stuName;
		this.stuAddress = stuAddress;
		this.stuBlood = Blood;
	}
	public char getScoreGrade() {
		char grade = switch(stuScore / 10) {
		case 10, 9 -> 'A';
		case 8 -> 'B';
		case 7 -> 'C';
		case 6 -> 'D';
		default -> 'F';
		};

		return grade;
	}
	public int getAge() {
		return 2024 - this.stuBirthYear;
	}

}
