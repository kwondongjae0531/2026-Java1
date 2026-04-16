package ai0319;

public class VariableTest2 {
    public static void main(String[] args) {
        int num1, num2, result, result2, result3;

        num1 = 300;
        num2 = 500;
        result = num1 + num2;
        result2 = num1 * num2;
        result3 = num1 / num2;
//        result = 10;

        System.out.println(num1 + " + " + num2 + " = " + result);
        System.out.printf("%d + %d = %d\n", num1, num2, result);
        System.out.printf("%d × %d = %d\n", num1, num2, result2);
        System.out.printf("%d ÷ %d = %d", num1, num2, result3);
    }
}
