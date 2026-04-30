package ai0430;

public class Lab_SetLine {
    public static void main(String[] args) {
        int fact = 1;
        int friends_num = 5;

        for (int i = 1; i <= friends_num; i++) {
            fact = fact * i;
        }
            System.out.println("A, B, C, D, E 학생들을 순서대로 세우는 경우의 수 : " + fact);
        }
    }

