package am;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class SerialEx4 {
    public static void main(String[] args) throws Exception {
        String path = "/Users/ham/My_Study/obj_test.txt";
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(path)));

        // 객체 읽기
        Object obj = ois.readObject();
        if(obj instanceof ArrayList) {
            ArrayList<DrinkVO> list = (ArrayList<DrinkVO>) obj;

            for (DrinkVO d : list) {
                System.out.printf("%s, %d \r\n", d.getName(), d.getPrice());
            }
        }

        if(ois != null)
            ois.close();

//        // 객체 읽기
//        ArrayList<DrinkVO> list = (ArrayList<DrinkVO>) ois.readObject();
//        ois.close();
//
//        // 읽어온 객체 출력
//        for (DrinkVO drink : list) {
//            System.out.println("Name: " + drink.getName() + ", Price: " + drink.getPrice());
//        }
    }
}

