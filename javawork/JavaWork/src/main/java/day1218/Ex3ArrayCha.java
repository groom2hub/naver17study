package day1218;

import java.util.Random;
import java.util.Scanner;

public class Ex3ArrayCha {
	public static void main(String[] args) {
		int[][] arr1 = new int[2][3];
		arr1[0] = new int[3];
		arr1[1] = new int[3];
		
		System.out.println("행 갯수: " + arr1.length);
		System.out.println("0번 행의 열 갯수: " + arr1[0].length);
		System.out.println("1번 행의 열 갯수: " + arr1[1].length);
		
		arr1[0][0] = 100;
		arr1[1][1] = 90;
		arr1[2][2] = 95;
		
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[i].length; j++) {
				System.out.printf("%d, %d: %d\t", i, j, arr1[i][j]);
			}
			System.out.println();
		}
	
	}

}
