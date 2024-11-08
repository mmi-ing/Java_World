package pm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputEx3 {
    public static void main(String[] args) {
        // 파일의 경로
        String path = "/Users/ham/My_Study/test.txt";

        // 준비된 경로를 가지고 File객체를 생성하자!
        File f = new File(path);

        if(f.exists()) { // 존재할 경우에만 스트림을 생성한다.
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(f);
                int data = -1;
                int count = 0;  // 반복회차를 알기 위한 변수

                // 연결된 파일로부터 읽기를 수행하는 반복문 : 더이상 읽을 것이 없으면 -1을 받는다
                while((data = fis.read()) != -1) {
//                        System.out.printf("%c", data);
                    System.out.write(data);
                        count++;
                } //while문의 끝
                System.out.println(); // 줄바꿈
                System.out.println(count + "회 반복");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e){
                e.printStackTrace();
            } finally {
                try {
                    if(fis != null)
                        fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }
    }
}
