package ai0521.rabbit;

public class RunRabbit {
    public static void main(String[] args) {
        rabbit rabbit1 = new rabbit();
        rabbit rabbit2 = new rabbit("좁은 네모");

        rabbit1.setLocation(50, 50);
        rabbit2.setLocation(150, 70);

        rabbit1.setShape("기본");
        rabbit1.printInfo();
        rabbit2.printInfo();

        rabbit1.setShape("다이아몬드");
        rabbit1.setxPos(rabbit1.getxPos() + 60);
        rabbit1.setxPos(rabbit1.getyPos() + 20);

        rabbit1.printInfo();

        rabbit2.printInfo();
        for(int i = 0; i < 5; i++) {
            rabbit2.moverigthTen();
        }

        for(int i = 0; i < 2; i++){
            rabbit2.moveleftTen();
        }

        rabbit2.printInfo();

    }
}
// 기본 모양의 토끼를 다이아몬드 모양의 토끼로 변경, 위치는 현재 x좌표에서 오른쪽으로 60 이동, y좌표는 아래쪽으로 20 이동하도록 하기. 이동한 후 출력하기.
// JVM은 클래스 내에 생성자가 하나도 없는 경우 기본생성자를 만들어서 사용합니다.
// 그러나 클래스 내에 생성자가 선언 되어 있다면 선언된 생성자만 사용할 수 있다.



