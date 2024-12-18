package day1217;

import java.util.Scanner;

public class Ex14ArrayRandom {

	public static void main(String[] args) {
		String []data = {"박남정", "공효진", "김미나", "이진", "손석구", "Adams"};
		
		for (int i = 0; i < data.length; i++) {
			for(int j = i + 1; j < data.length; j++) {
//				if (data[i].compareTo(data[j]) > 0) { // 오름차순 정렬
				if (data[i].compareTo(data[j]) < 0) { // 내림차순 정렬
					String temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
					
			}
		}
		
		for (int i = 0; i < data.length; i++) {
			System.out.println(i + ": " + data[i]);
		}
		
	}

}
