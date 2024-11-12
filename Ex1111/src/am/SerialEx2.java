package am;

import java.io.*;
import java.util.ArrayList;

public class SerialEx2 {
    public static void main(String[] args) throws Exception {
        // 이전의 예제에서 객체 쓰기할 것을 읽어와서 표현하자!
        String path = "/Users/ham/My_Study/obj_test.txt";

        // 객체를 읽기할 스트림을 만들자
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(path)));
        Object obj = ois.readObject();
        if(obj instanceof ArrayList) {
            ArrayList<String> list = (ArrayList<String>) obj;

            for(String str : list)
                System.out.printf("%s\r\n", str);
        }



    }
}
