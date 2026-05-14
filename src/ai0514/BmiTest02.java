package ai0514;

import java.util.Scanner;

public class BmiTest02 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("======== BMI(Body Index Mass) =========");

        while (true) {
            System.out.print("* 체중(㎏, 실수값)을 입력하세요: ");
            double weight = s.nextDouble();

            System.out.print("* 키(㎝, 실수값)을 입력하세요: ");
            double height = s.nextDouble();

            s.nextLine(); // 엔터 제거

            System.out.print("* 성명 입력(exit 프로그램 종료): ");
            String name = s.nextLine();

            // exit 입력하면 종료
            if (name.equalsIgnoreCase("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            // bmi 지수 계산
            double bmi = weight / Math.pow(height / 100, 2);
            String result1, result2;

            if (bmi < 18.5) {
                result1 = "저체중";
                result2 = "식이요법과 운동을 통해 체중을 증량시켜야 합니다. 생명에 위협이 있을 수도 있습니다.";
            } else if (bmi < 22.9) {
                result1 = "정상";
                result2 = "현재 상태를 유지하세요.";
            } else if (bmi < 29.9) {
                result1 = "비만";
                result2 = "식단과 운동을 통해 체중을 감량하시기 바랍니다. 성인병 유발의 원인이 될 수 있습니다.";
            } else {
                result1 = "고도비만";
                result2 = "전문가의 도움을 받아 반드시 체중을 감량하시기 바랍니다.";
            }

            System.out.printf("* %s님의 BMI 지수 결과: %.2f㎏/㎡\n", name, bmi);
            System.out.printf("* %s → %s\n\n", result1, result2);
        }

        s.close();
    }
}