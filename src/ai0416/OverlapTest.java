package ai0416;

import java.util.Scanner;

public class OverlapTest {
    public static void main(String[] args) {
        System.out.println("== 특정범위 숫자 판별 프로그램 ==");
        Scanner s = new Scanner(System.in);
        System.out.println("* 정수를 입력 : ");
        int num = s.nextInt();

        if (num > 100) { //num > 100 && num < 1000
            if (num < 1000)
                System.out.printf("입력된 숫자 %d는(은) 100보다 크고 1000보다 작은 숫자이군요.\n", num);
            else
                System.out.printf("입력된 숫자 %d는(은) 1000보다 큰 숫자이군요. \n", num);

        }else{
            System.out.printf("입력된 숫자 %d는(은) 100보다 작은 숫자이군요.\n", num);


            s.close();
        }
    }

}