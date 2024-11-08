package pm;

import java.io.InputStream;

public class InputEx2 {

    public static void main(String[] args) {
        InputStream key = System.in;
        System.out.println("입력: ");

        int i = 0;
        while(i<4) {
            try {
                int data = key.read();
                System.out.println(data + ":" + (char)data);    // 97 : a
            } catch (Exception e){

            }
            ++i;
        } //while문의 끝
        System.out.println("프로그램 끝!");
    }
}
