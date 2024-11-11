package am;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.Field;

public class FileOutEx1 {
    public static void main(String[] args) {
        // 프로그램 시작
        String str = "abcdefg1000000";

        // 파일에 저장하기 위해 파일의 경로로 File객체를 준비하자!
        File f = new File("/Users/ham/My_Study/abc.txt");

        try {
            FileOutputStream fos = new FileOutputStream(f);
            // 위 스트림을 실행하면 파일이 만들어지는데 같은 이름이 존재한다면 덮어씌워진다
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
