package ai0430;

public class hap {
    public static void main(String[] args) {
       int hap = 0;
       for (int i = 1 ; i <= 10 ; i++){
           hap = hap + i;
           if(i < 10)
               System.out.print(i + " + ");
               else
               System.out.print(i + " = ");
       }
        System.out.println(" " + hap);
    }
}
