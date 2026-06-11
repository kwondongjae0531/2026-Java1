package ai0611.abstracttest;

public abstract class Person {
    String name;
    int weight;
    int height;

    public void eat(String food){
        System.out.println(food + "을 먹는다.");
    }

    public void sleep(int hour){
        System.out.println(hour + "시간 잔다.");
    }

    //  추상메소드
    public abstract void study();

}
