package ai0528.access;

public class Rabbit {
    public String shape;
    public int x;
    public int y;

// default(생략) 제한자는 같은 패키지 내에서만 접근이 가능
//    String shape;
//    int y;
//    int x;
//    public String getShape() {
//        return shape;
//    }
//
//    public void setShape(String shape) {
//        this.shape = shape;
//    }

    public void setLocation(int x, int y){
        this.x = x;
        this.y = y;

    }

    public void printInfo(){
        System.out.printf("모양의 토끼는 (%d, %d)에 있음.\n", shape, x, y);
    }
}
