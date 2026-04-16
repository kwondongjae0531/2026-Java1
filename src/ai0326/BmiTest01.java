import java.util.Scanner;

public class BmiTest01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("이름을 입력하세요: ");
        String name = sc.nextLine();

        System.out.print("키를 입력하세요 (cm): ");
        double height = sc.nextDouble();

        System.out.print("몸무게를 입력하세요 (kg): ");
        double weight = sc.nextDouble();

        // cm → m 변환
        double heightM = height / 100;

        // BMI 계산
        double bmi = weight / (heightM * heightM);

        // 결과 출력
        System.out.printf("\n%s님의 BMI는 %.2f 입니다.\n", name, bmi);

        // BMI 판정
        if (bmi < 18.5) {
            System.out.println("저체중입니다.");
        } else if (bmi < 23) {
            System.out.println("정상체중입니다.");
        } else if (bmi < 25) {
            System.out.println("과체중입니다.");
        } else {
            System.out.println("비만입니다.");
        }

        sc.close();
    }
}