package day1224;

import java.io.File;

public class Ex3FileReadWrite {

	public static void main(String[] args) {
		File file1 = new File("/Users/choijunhyeok/Desktop/네이버클라우드캠프/study/javawork/JavaWork/src/main/java/day1224/score.txt");
		File file2 = new File("/Users/choijunhyeok/Desktop/네이버클라우드캠프/study/javawork/JavaWork/src/main/java/day1224");

		System.out.println(file1.length());
		System.out.println(file1.canExecute());
		System.out.println(file1.canRead());
		System.out.println(file1.canWrite());
		System.out.println(file1.exists());

		System.out.println(file1.isDirectory());
		System.out.println(file2.isDirectory());
		System.out.println(file1.isFile());
		System.out.println(file2.isFile());

		if(file1.isDirectory())
		{
			String []list=file1.list();
			for(String s:list)
				System.out.println(s);
		}else {
			System.out.println("file1 은 파일입니다");
		}

		//file2가 디렉토리라면 목록을 출력하라
		if(file2.isDirectory())
		{
			System.out.println("** 파일2 목록 **");
			String []list=file2.list();
			int n=0;
			for(String s:list)
				System.out.println(++n+":"+s);
		}else {
			System.out.println("file2 은 파일입니다");
		}
		System.out.println("=".repeat(30));
		System.out.println(file1.getAbsolutePath());
		System.out.println(file1.getName());
		System.out.println(file1.getPath());

	}

}
