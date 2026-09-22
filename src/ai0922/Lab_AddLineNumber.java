package ai0922;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Lab_AddLineNumber {
    public static void main(String[] args) {
        try {
            // File을 읽어오기 위한 입력스트림(inputStream) 생성

            BufferedReader br = new BufferedReader(
                    new FileReader("D:\\FileIOTest\\myData1.txt"));

            String line = "";
            int cnt = 1;


// File의 끝까지 File에서 한 줄씩 읽어오기
            while (true) {
                line = br.readLine();
                if (line == null)
                    break;
                System.out.println(cnt++ +" : " +line);
            }

// FileInputStream 닫기
            br.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

