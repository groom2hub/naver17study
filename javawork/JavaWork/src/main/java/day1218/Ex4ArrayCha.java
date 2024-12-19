package day1218;

import java.util.Random;
import java.util.Scanner;

public class Ex4ArrayCha {
	public static void main(String[] args) {
		int [][]arr1 = {
				{67, 78, 90},
				{100, 90, 100},
				{67, 78, 45, 90}
		};
		
		
		System.out.println("행 갯수: " + arr1.length);
		System.out.println("0번 행의 열 갯수: " + arr1[0].length);
		System.out.println("1번 행의 열 갯수: " + arr1[1].length);
		System.out.println("2번 행의 열 갯수: " + arr1[2].length);
		System.out.println();
		
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[i].length; j++) {
				System.out.print(arr1[i][j] + "\t");
			}
			System.out.println();
		}
	
	}

}
