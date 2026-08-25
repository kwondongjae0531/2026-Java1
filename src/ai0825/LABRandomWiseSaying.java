package ai0825;

import java.util.Random;

public class LABRandomWiseSaying {
    public static void main(String[] args) {
        String[] wiseSay = {
                "남들과 비교하는 순간, 자신의 행복을 잃는다. - 쇠렌 키르케고르",
                "성공은 최종적인 것이 아니며, 실패는 치명적인 것도 아니다. 중요한 것은 계속할 용기다. - 윈스턴 처칠",
                "인생은 자신을 발견하는 것이 아니라, 자신을 만들어가는 것이다. - 조지 버나드 쇼",
                "할 수 있다고 생각하든, 할 수 없다고 생각하든 당신이 옳다.” - 헨리 포드",
                "우리가 두려워해야 할 유일한 것은 두려움 그 자체다.” - 프랭클린 D. 루스벨트",
                "자유란 두려움이 없는 것이 아니라, 두려움에도 불구하고 행동하는 것이다. - 넬슨 만델라",
                "천 리 길도 한 걸음부터 시작된다. - 노자",
                "아는 것이 적을수록 확신은 커진다. - 찰스 다윈",
                "미래는 오늘 우리가 무엇을 하느냐에 달려 있다. - 마하트마 간디",
                "행복은 준비된 곳에서 오는 것이 아니라, 당신의 행동에서 만들어진다. - 달라이 라마"


        };

        Random random = new Random();
        int randomIndex = random.nextInt(wiseSay.length);
        System.out.println("오늘의 명언: " + wiseSay[randomIndex]);
    }
}

