package ai0604;
// inheritance 패키지에 포함되지 않은 Rabbit 파일

public class Rabbit {

    private String shape; // 토끼의 모양
    private int xPos; // X 위치
    private int yPos; // Y// 위치
    public static int count;

    public Rabbit() {
        count++;
    }

    void setPosition(int x, int y) {
        xPos = x;
        yPos = y;

    }


    public Rabbit(String shape) {
        this.shape = shape;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public int getxPos() {
        return xPos;
    }


    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public void setLocation(int xPos, int yPos){
        this.xPos = xPos;
        this.yPos = yPos;
    }
    // 토끼의 모양, 위치 출력 메소드
    public void printInfo(){
        System.out.printf("%s 모양의 토끼는 (%d, %d) 좌표에 위치하고 있다.\n", shape, xPos, yPos);
    }

    //    x축으로 10씩 오른쪽으로 이동하는 메소드
    public void moverigthTen(){
        xPos += 10;
    }
    //    x축으로 10씩 왼쪽으로 이동하는 메소드
    public void moveleftTen() {
        xPos -= 10;
    }
}

