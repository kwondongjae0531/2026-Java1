package ai0430;

public class Fortest2 {
    public static void main(String[] args) {
        System.out.println("=== 1001 ~ 2000까지의 숫자 중에서 홀수값의 합계 구하기 ===");
        int hap = 0;
        for (int i = 1001; i <= 2000; i+=2){
            hap += i;

        }

        System.out.println(hap);

    }
}
