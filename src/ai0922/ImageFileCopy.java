package ai0922;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
// 이미지 파일과 같은 이진파일은 1 byte 씩 읽어서 1byte 씩 출력해야 한다.
public class ImageFileCopy {
    public static void main(String[] args) {
        try {
        FileInputStream fIn = new FileInputStream("기영이.jpg");
            FileOutputStream fOut = new FileOutputStream("기영이Copy.jpg");

            int data;
            while ((data = fIn.read()) != -1){
                fOut.write((byte)data);
            }

            System.out.println("이미지 복사 완료");

            fIn.close();
            fOut.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
