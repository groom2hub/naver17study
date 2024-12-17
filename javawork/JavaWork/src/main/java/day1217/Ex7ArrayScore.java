package day1217;

import java.util.Scanner;

public class Ex7ArrayScore {

	public static void main(String[] args) {
		/*
		 * 인원수를 입력 후 그 인원수만큼 이름과 점수를 입력하고
		 * 등수와총점과 평균을 구하여 출력하시오.
		 */
		Scanner sc = new Scanner(System.in);
		int num;
		int []score, rank;
		String []name;
		int total = 0;
		double avg;
		
		System.out.print("인원수: ");
		num = Integer.parseInt(sc.nextLine());
		score = new int[num];
		rank = new int[num];
		name = new String[num];
		
		for (int i = 0; i < num; i++) {
			System.out.print(i + "번지 이름: ");
			name[i] = sc.nextLine();
			System.out.print("점수: ");
			score[i] = Integer.parseInt(sc.nextLine());
			total += score[i];
		}
		

		for(int i = 0; i < score.length; i++) {
			rank[i] = 1;
			for (int j = 0; j < score.length; j++) {
				if (score[i] < score[j]) {
					rank[i]++;
				}
			}
		}
		
		avg = (double)total / num;

		System.out.println("번호\t이름\t점수\t등수");
		for (int i = 0; i < num; i++) {
			System.out.println((i + 1) + "\t" + name[i] + "\t" + score[i] + "\t" + rank[i]);	
		}
		
		System.out.println("=".repeat(40));
		System.out.println("총점: " + total + "\t\t평균: " + avg);
		
	}

}
