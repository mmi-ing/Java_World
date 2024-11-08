package am;

import java.io.File;

public class FileEx1 {
    public static void main(String[] args) {
        // 자바에서 File 객체는 파일 뿐만 아니라 폴더(디렉토리)를 객체화시키는 클래스다.
        // 실제 존재하지 않아도 File객체로 생성 가능

        String path = "/Users/ham/My_Study"; // 원하는 폴더의 경로 준비
        File f = new File(path);


        // 생성된 파일 객체가 파일인지? 디렉토리인지? 판단하자!
        if(f.isDirectory()) {
            System.out.println("폴더입니다.");
            // 하위에 있는 자식요소들을 모두 배열로 얻어낸다.
            File[] sub = f.listFiles();
            for (File sFile : sub){
                if(sFile.isFile())
                System.out.printf("\t-%s\r\n", sFile.getName());
            } // for의 끝
            System.out.println("-----------------------------------------------");
            String[] sub_ar = f.list();

            for (String sf: sub_ar) {
                System.out.printf("\t-%s\r\n", sf);
            } //for의 끝
        } else {
            System.out.println("파일입니다.");
        }

        if(f.exists())
            System.out.println("존재합니다.");
        else
            System.out.println("존재하지 않습니다.");
    }
}