package ai0618.array;

import java.util.Scanner;

public class ArrayTest1 {
    public static void main(String[] args) {
        // 5개의 성적을 입력받아서 저장할 수 있는 1차원 배열 객체를 생성
        int[] scores = new int[5];
        String[] subjects = {"프로그래밍언어실습", "데이터베이스","융합UI실습", "인공지능개론", "직업과 경력개발"};



        // 콘솔창에서 키보드를 입력한 성적을 가자와서 배열에 저장
        Scanner s = new Scanner(System.in);
// 입력받아서 저장하는 반복문
        for (int i = 0; i < scores.length; i++) {

            System.out.print("- " + subjects[i] + "성적 입력(정수값): ");
            scores[i] = s.nextInt();
            }



        // 배열에 저장된 성적들을 한줄로 출력하고
        // 그 다음 줄에 성적의 전체 합계가 출력되게 한다.

        int sum = 0; // 합계를 저장할 변수 선언
        System.out.print("세부성적: ");
        // 1. 성적 출력 및 합계 누적
//        for (int i = 0; i < scores.length; i++) {
//            System.out.print(scores[i] + " "); // 한 줄로 출력 (뒤에 공백 추가)
//            sum += scores[i];                  // 누적 합계 구하기
//        }

        //enhanced for

        int i = 0;
        for (int score : scores) {
            System.out.print(subjects[i] + ":" + score + " ");
            sum += score;
            i++;
        }

        // 2. 줄바꿈 후 합계 출력
        System.out.println();
        System.out.println("합계: " + sum);
        System.out.println("평균: " + sum/scores.length);
        // ----------------------------------------------------


        s.close();
    }
}
