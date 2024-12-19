package day1218;

import java.util.Scanner;

public class Ex1ArraySwitch {

	public static void main(String[] args) {
		/*
		 * 인원수를 입력 후 인원수만큼 이름과 자바, 스프링 두 점수를 입력 후
		 * 총합, 평균 등수, 등급을 구하시오.
		 */

		Scanner sc = new Scanner(System.in);
		
		int num;
		int []javaScore, springScore, sum, rank;
		String []name, grade;
		double []avg;
		
		System.out.print("인원수: ");
		num = Integer.parseInt(sc.nextLine());
		
		javaScore = new int[num];
		springScore = new int[num];
		sum = new int[num];
		rank = new int[num];
		name = new String[num];
		grade = new String[num];
		avg = new double[num];
		
		for (int i = 0; i < num; i++) {
			System.out.print("이름: ");
			name[i] = sc.nextLine();
			System.out.print("자바 점수: ");
			javaScore[i] = Integer.parseInt(sc.nextLine());
			System.out.print("스프링 점수: ");
			springScore[i] = Integer.parseInt(sc.nextLine());
			sum[i] = javaScore[i] + springScore[i];
			avg[i] = sum[i] / 2.0;
			System.out.println();
		}
		
		for (int i = 0; i < num; i++) {
			rank[i] = 1;
			for (int j = 0; j < num; j++) {
				if (avg[i] < avg[j]) {
					rank[i]++;
				}
			}
		}
		
		for (int i = 0; i < num; i++) {
//			switch((int)avg[i] / 10) {
//			case 10:
//			case 9:
//				grade[i] = "우수장학생";
//				break;
//			case 8:
//				grade[i] = "일반장학생";
//				break;
//			default:
//				grade[i] = "해당없음";
//			}
			
			grade[i] = switch((int)avg[i] / 10) {
			case 10, 9 -> "우수장학생";
			case 8 -> "일반장학생";
			default -> "해당없음";
			};
		}
		
		System.out.println("번호\t이름\t자바\t스프링\t총점\t평균\t등수\t등급");
		System.out.println("=".repeat(64));
		for (int i = 0; i < num; i++) {
			System.out.printf("%d\t%s\t%d\t%d\t%d\t%.1f\t%d\t%s\n", i, name[i], javaScore[i], springScore[i], sum[i], avg[i], rank[i], grade[i]);
		}
		
		
	}

}
