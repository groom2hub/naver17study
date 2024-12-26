package day1224;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex1FileScore {
	
	private static void scoreRead() {
		FileReader fr = null;
		BufferedReader br = null;
		
		int cnt = 0, sum = 0;
		double avg;
		
		try {
			fr = new FileReader("/Users/choijunhyeok/Desktop/네이버클라우드캠프/study/javawork/JavaWork/src/main/java/day1224/score.txt");
			System.out.println("파일 존재함!");
			br = new BufferedReader(fr);
			
			while (true) {
				String s = br.readLine();
				if (s == null) {
					break;
				}
				try {
					int score = Integer.parseInt(s);
					cnt++;
					sum += score;
					System.out.println(cnt + " => " + score + "점 ");
				} catch (NumberFormatException e) {
					System.out.println("\t문자가 포함됨!");
				}
			}
			
			avg = (double)sum / cnt;
			System.out.println("점수 갯수: " + cnt);
			System.out.println("총점: " + sum);
			System.out.printf("평균: %.1f\n", avg);
			
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다. > " + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException | NullPointerException e) {
				System.out.println(e.getMessage());
//				e.printStackTrace();
			}
		}
		
	}

	public static void main(String[] args) {
		scoreRead();
		System.out.println("** 정상종료 **");
	}

}
