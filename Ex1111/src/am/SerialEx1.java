package am;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerialEx1 {
    public static void main(String[] args) throws Exception {
        // 객체를 파일에 저장하기
        ArrayList<String> list = new ArrayList<>();
        list.add("대한민국");
        list.add("쌍용교육센터");

        String path = "/Users/ham/My_Study/obj_test.txt";

        // 객체를 파일에 저장하기 위해 FileOutputSream과 ObjectOutputStream이 연결되어 만들어져야 한다.
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(path)));

        oos.writeObject(list); // 객체 쓰기
        oos.flush();
        oos.close();

    }
}
