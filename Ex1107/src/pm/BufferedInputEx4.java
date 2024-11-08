package pm;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class BufferedInputEx4 {
    public static void main(String[] args) {


        // 파일 경로
        String path = "/Users/ham/My_Study/test.txt";

        // 위 경로로 File객체 생성
        File f = new File(path);

        if (f.exists()) {
            // 실제 존재할 경우에만 스트림을 만든다.
            BufferedInputStream bis = null;
            try {
                // 읽기를 하기 위한 스트림 준비
                bis = new BufferedInputStream(new FileInputStream(f));
                int data = -1;
                int count = 0;

                byte[] buf = new byte[2048];

                // 다음은 읽은 자원은 buf라는 배열에 저장되며 data는 읽은 수를 저장한다.
                while ((data = bis.read(buf)) != -1) {
                    System.out.write(buf, 0 , data);
                    count++;
                }
                System.out.println();
                System.out.println(count + "회 반복됨");
            } catch (Exception e) {

            } finally {
                try {
                    if (bis != null)
                        bis.close();
                } catch (Exception e2) {

                }
            }
        }
    }
}