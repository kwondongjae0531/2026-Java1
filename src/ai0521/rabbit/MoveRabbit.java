package ai0521.rabbit;

public class MoveRabbit {

    private String shape;
    private int xPos;
    private int yPos;

    public MoveRabbit() {
        shape = "기본";
        xPos = 0;
        yPos = 0;
    }

    public void setLocation(int x, int y) {
        xPos = x;
        yPos = y;
    }

    public void moveTen() {
        xPos += 10;
        yPos += 10;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public void printInfo() {
        System.out.printf("%s 모양의 토끼는 (%d, %d) 좌표에 위치하고 있다.\n", shape, xPos, yPos);
    }

    public static void main(String[] args) {

        MoveRabbit rabbit = new MoveRabbit();

        rabbit.setLocation(50, 50);

        rabbit.printInfo();

        rabbit.moveTen();

        rabbit.printInfo();
    }
}
// 궁금한 것: 기능은 둘 다 이동, 하지만 교수님의 코드처럼 방향별로 메소드를 나누는 방식이 객체지향적으로 더 좋은 이유가 있을까?