package ai0423;

import java.util.Scanner;

public class ScoreTest {
    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        System.out.print("* 프로그래밍언어실습 ");
//        int score = s.nextInt();
//        char result = 0;
//
//        if(score >= 90)
//            result = 'A';
//        else if(score >= 80)
//            result = 'B';
//        else if(score >= 70)
//            result = 'C';
//        else if(score >= 60)
//            result = 'D';
//        else
//            result = 'F';
//
//        System.out.println("* 프로그래밍언어실습 과목의 학점은 " + result + "입니다.");
//
//
//            s.close();
        Scanner s = new Scanner(System.in);
        int age;

        System.out.print("나이 입력 ==> ");
        age = s.nextInt();

        if(age >= 18) {
            System.out.println("즐거운 시간 보내세요^^");
        } else{
            System.out.println("집에 갈 시간이네요!");
        }
        System.out.println("협조 감사합니다.");

        s.close();
    }
}
