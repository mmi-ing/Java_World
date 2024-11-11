package am;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileOutEx2 {
    public static void main(String[] args) {

        // 프로그램 시작
        String str = "abcdefg1000000대한민국";

        File f = new File("/Users/ham/My_Study/abc.txt");

        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(f);
            // 준비된 output스트림을 통해 쓰기 수행!
            // 먼저 저장할 문장려 객체를 byte형 배열로 변환한다.
            byte[] ar= str.getBytes();

            fos.write(ar, 0, ar.length);
            fos.flush();    // 스트림을 비우는 동작인데 이것을 다르게 말하면
                            // 쓰트림에 있는 자원을 지금 당장 방출하라
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}