package ai0416;

public class ReplaceAllTest {
    public static void main(String[] args) {
        String s1 = new String(" 한국 폴리텍 대학 서울     정수 캠퍼스     ");
        String s2 = s1.replaceAll(" ", "");
        System.out.println("원래문자열: " + s1);
        System.out.println("바꾼문자열: " + s2);
        
        s1 = "인곧지능소프트웨어과 1학년";
        System.out.println("\"지능\"의 인덱스번호: " + s1.indexOf("지능"));
        System.out.println("\'웨\'의 인덱스번호: " + s1.indexOf("웨"));

        s1 = "한국에는 한국 폴리텍대학이 한국 전체의 많은 곳에 취해 있습니다.";
        System.out.println("s1의 4번 위치부터 한국 이라는 문자열의 인덱스 번호:" + s1.indexOf("한국", 4));

        s1 = "서울정수";
        System.out.println("전체문자열의 길이: " + s1.length());
        System.out.println(s1.charAt(0));
        System.out.println(s1.charAt(1));
        System.out.println(s1.charAt(2));
        System.out.println(s1.charAt(3));

        System.out.println(s1.substring(1,3));

        String ss = "블랙핑크";
        System.out.println("원본문자열 -->" + ss);

        System.out.print("반대문자열 -->");
        System.out.print(ss.charAt(3));
        System.out.print(ss.charAt(2));
        System.out.print(ss.charAt(1));
        System.out.print(ss.charAt(0));

    }
}



