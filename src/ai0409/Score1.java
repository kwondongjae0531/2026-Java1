package ai0409;

import java.util.Scanner;

public class Score1 {
    public static void main(String[] args) {
//        int java = 3, mobile = 2, excel = 1;
//        double A = 4.5, AO = 4.0, B = 3.5;
//
//        double avg;
//        avg = ((java*B) + (mobile*AO) + (excel*A)) / (java+ mobile + excel);
//        avg = Math.round(avg * 100.0) / 100.0;
//
//        System.out.println("평균 학점:" + avg);

        Scanner s = new Scanner(System.in);
        System.out.println("== 과목 성적 평균 ==");
                System.out.println("* 성적 입력값은 0~4.5 이하의 값을 입력하세요.");
        System.out.print("프로그래잉언어실습(3) 입력:");
        double score1 = s.nextDouble();
        System.out.print("웹프로그래밍기초(3) 입력:");
        double score2 = s.nextDouble();
        System.out.print("프롬프트엔지니어링(2) 입력:");
        double score3 = s.nextDouble();

        double avg = (score1 * 3 + score2* 3 + score3 * 2) / (3 + 3 + 2);

        System.out.printf("3과목 평균: %.2f\n", avg);

    }
}

