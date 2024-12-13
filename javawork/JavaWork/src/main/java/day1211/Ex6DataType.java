package day1211;

public class Ex6DataType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "Hello";
		String str2 = new String("Happy");
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println("\t" + str1);
		System.out.println("\t\t" + str2);

		System.out.printf("%s\n", str1);
		System.out.printf("%30s\n", str1);
		System.out.printf("%s40\n", str1);
		System.out.printf("**%-30s\n", str1);

		System.out.println(str1 + str2);
		
	}

}
