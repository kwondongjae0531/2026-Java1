package ai0908;

public class VoidTest {
    public static void printLine(char c, int count){
        for (int i = 0; i < count; i++) {
            System.out.print(c);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        String[] emojis = {"❤️", "✌️","😊", "🤷‍", "🤦‍", "😂", "🤣"};

        for (int i = 0; i < emojis.length; i++) {
            for (int j = 0; j < (i + 1) * 10; j++) {
                System.out.print(emojis[i]);
            }
            System.out.println();

            }
        }
    }



