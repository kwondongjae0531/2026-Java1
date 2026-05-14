package ai0514;

import java.util.Random;
import java.util.Scanner;

public class LAB_Break2 {
    public void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int i = 1;
        int num = 0;
        int computerNum = 0;
        Random random = new Random();

        while(true){
            computerNum = random.nextInt(5) + 1;
            System.out.print("게임 " + i + "회: 컴퓨터가 생각한 숫자는 무엇일까요?");
            num = s.nextInt();
            if(computerNum == num){
                System.out.println("축하합니다. 맞히셨어요~");
                break;
            }
            }
        System.out.println("아까워요." + computerNum + "였는데. +  다시 도전해 보세요.");
        i++;

        System.out.println("게임을 마칩니다.");
        s.close();
        }
    }

