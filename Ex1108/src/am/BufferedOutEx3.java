package am;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

public class BufferedOutEx3 {
    public static void main(String[] args) {
        // 파일에 Buffered스트림을 이용하여 자원 쓰기를 하자!
        String path = "/Users/ham/My_Study/abc.txt";

        // 파일이 존재할 경우에만 저장해야 함!
        File f = new File(path);
        if(!f.exists()) {   // 파일이 존재하지 않을 경우는 return 하여 프로그램 종료
            return;
        }

        BufferedOutputStream bos = null;
        try {
            bos = new BufferedOutputStream(new FileOutputStream(f));

            // 키보드로부터 문자열을 받아서 저장하자!
            Scanner scan = new Scanner(System.in);
            System.out.println("입력:");
            String msg = scan.next();

            byte[] buf = msg.getBytes();

            bos.write(buf, 0, buf.length);
            bos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                bos.close();
            } catch (Exception e) { }
        }
    }
}
