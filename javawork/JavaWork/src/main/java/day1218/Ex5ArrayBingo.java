package day1218;

import java.util.Random;
import java.util.Scanner;

public class Ex5ArrayBingo {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		

		int n, bingo;

		System.out.print("n(nxn 빙고): ");
		n = Integer.parseInt(sc.nextLine());
		int [][]puzzle = new int[n][n];
		

		while (true) {
			System.out.println("=".repeat(3 * n + 2));
			for (int i = 0; i < puzzle.length; i++) {
				for (int j = 0; j < puzzle[i].length; j++) {
					puzzle[i][j] = (int)(Math.random() * 3) + 1;
				}
			}

			for (int i = 0; i < puzzle.length; i++) {
				for (int j = 0; j < puzzle[i].length; j++) {
					System.out.printf("%3d", puzzle[i][j]);
				}
				System.out.println();
			}
			System.out.println("=".repeat(3 * n + 2));
			
			bingo = 0;
			boolean checkBingo;
			for (int i = 0; i < puzzle.length; i++) { // 가로 확인
				checkBingo = true;
				for (int j = 1; j < puzzle[i].length; j++) { 
					if(puzzle[i][j - 1] != puzzle[i][j]) {
						checkBingo = false;
						break;
					}
				}
				
				if (checkBingo) {
					bingo++;
				}
			}

			for (int i = 0; i < puzzle[0].length; i++) { // 세로 확인
				checkBingo = true;
				for (int j = 1; j < puzzle.length; j++) { 
					if(puzzle[j - 1][i] != puzzle[j][i]) {
						checkBingo = false;
						break;
					}
				}
				
				if (checkBingo) {
					bingo++;
				}
			}
		
			checkBingo = true; // 대각선(\) 확인
			for (int i = 1; i < puzzle.length; i++) { 
				if(puzzle[i - 1][i - 1] != puzzle[i][i]) {
					checkBingo = false;
					break;
				}
			}
			if (checkBingo) {
				bingo++;
			}
			
			checkBingo = true; // 대각선(/) 확인
			for (int i = 1; i < puzzle.length; i++) { 
				if(puzzle[i - 1][puzzle.length - i] != puzzle[i][puzzle.length - 1 - i]) {
					checkBingo = false;
					break;
				}
			}
			if (checkBingo) {
				bingo++;
			}

			if (bingo == 0) {
				System.out.println("\t꽝!!!");
			}
			else {
				System.out.println("\t" + bingo + "빙고");
			}


			if (sc.nextLine().equalsIgnoreCase("q")) {
				break;
			}
		}


	}

}
