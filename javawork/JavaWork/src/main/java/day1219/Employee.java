package day1219;

public class Employee {
	private String employeeName, position;
	private int familyNum;
	
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getFamilyNum() {
		return familyNum;
	}
	public void setFamilyNum(int familyNum) {
		this.familyNum = familyNum;
	}
	
	public int getDefaultSalary() {
		int defaultSalary = switch(position) {
		case "부장" -> 450;
		case "과장" -> 300;
		case "대리" -> 250;
		default -> 150;
		};
		
		return defaultSalary;
	}
	public int getAdditionalAllowance() {
		int additionalAllowance = switch(position) {
		case "부장", "과장" -> 70;
		case "대리", "사원" -> 50;
		default -> 0;
		};
		
		return additionalAllowance;
	}
	public int getTax() {
		return (int)(getDefaultSalary() * 0.05);
	}
	public int getFamliyAllowance() {
		int additionalAllowance = 0;
		if (familyNum >= 5) {
			additionalAllowance = 30;
		} else if (familyNum >= 2) {
			additionalAllowance = 10;
		}
		
		return additionalAllowance;
	}
	
	public int getActualSalary() {
		return (getDefaultSalary() + getAdditionalAllowance() - getTax() + getFamliyAllowance());
	}
	
}
