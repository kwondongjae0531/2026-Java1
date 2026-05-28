package ai0521.rabbit;

public class Rabbit {

    private String shape;
    private int xPos;
    private int yPos;

    // 기본 생성자
    public Rabbit() {
    }

    // 생성자
    public Rabbit(String shape) {
        this.shape = shape;
    }

    // getter / setter
    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public int getXPos() {
        return xPos;
    }

    public void setXPos(int xPos) {
        this.xPos = xPos;
    }

    public int getYPos() {
        return yPos;
    }

    public void setYPos(int yPos) {
        this.yPos = yPos;
    }

    // 위치 설정
    public void setLocation(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    // 오른쪽 10 이동
    public void moveRightTen() {
        xPos += 10;
    }

    // 왼쪽 10 이동
    public void moveLeftTen() {
        xPos -= 10;
    }

    // 정보 출력
    public void printInfo() {
        System.out.printf(
                "%s 모양의 토끼는 (%d, %d) 좌표에 위치하고 있다.\n",
                shape, xPos, yPos
        );
    }
}