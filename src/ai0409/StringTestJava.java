package ai0409;

public class StringTestJava {
    public static void main(String[] args) {
        String s = "난생처음 자바";
        int len = s.length();
        System.out.println("내용: " + s);
        System.out.println("내용: " + s.length());

        s = "Software 입니다.";
        System.out.println("대문자로 출력: " + s.toUpperCase());
        System.out.println("원래문자열 출력 :" + s);
        System.out.println("소문자로 출력: " + s.toLowerCase());
        System.out.println("원래문자열 출력 :" + s);

        s = "    인공 지능 소프트웨어    ";
        System.out.println("trim전: " + s);
        System.out.println("trim후: " + s.trim());
        System.out.println("원래문자열 출력  : " + s);
    }
}
