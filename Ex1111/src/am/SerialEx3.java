package am;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerialEx3 {
    public static void main(String[] args) throws Exception{

        // 저장할 음료객체 생성
        DrinkVO d1 = new DrinkVO();
        d1.setName("웰치스");
        d1.setPrice(1000);

        DrinkVO d2 = new DrinkVO();
        d2.setName("사이다");
        d2.setPrice(800);

        ArrayList<DrinkVO> list = new ArrayList<>();
        list.add(d1);
        list.add(d2);

        String path = "/Users/ham/My_Study/obj_test.txt";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(path)));

        //객체 쓰기
        oos.writeObject(list);
        oos.flush();
        oos.close();
    }
}
