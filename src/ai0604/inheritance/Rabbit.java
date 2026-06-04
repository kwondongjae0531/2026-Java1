package ai0604.inheritance;
// inheritance에 포함된 Rabbit 파일

public class Rabbit {

    // super 클래스의 필드 또는 메소드 앞에 private를 붙이면 sub 클래스에서 사용이 제한된다.
    String shape; // 토끼의 모양
    int xPos; // X 위치
    int yPos; // Y 위치


    void setPosition(int x, int y) {
        xPos = x;
        yPos = y;

    }
    public Rabbit() {
        this.shape = shape;
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

