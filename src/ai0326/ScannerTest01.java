package ai0326;

import java.util.Scanner;

public class ScannerTest01 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("좋아하는 정수값을 입력하세요.:");
        int num = s.nextInt();

        System.out.println("입력한 숫자는 "+ num +"입니다.");
        s.close();
    }
}
