package homework;

import pm.Test;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class MyDialog extends JDialog {

    JTextArea ta;
    Test f;
    BufferedInputStream bis;
    File selectedFile;


    public MyDialog(Test f, String path) {
        this.f = f;
        // 파일경로를 가지고 File객체를 생성하자!
        selectedFile = new File(path);
        this.add(new JScrollPane(ta = new JTextArea()));

        this.setBounds(400, 100, 500, 450);
        this.setVisible(true);

        // 선택된 파일을 읽어서 JTextArea에 표현하는 동작을 호출한다.
        readFile();

        // 이벤트 감지자 등록
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
//                System.exit(0); //프로그램 종료
                dispose();  //현재 창만 닫기
            }
        });
    }
    private void readFile() {
        //멤버변수 selectFile을 가지고 스트림을 생성한다.
        try {
            bis = new BufferedInputStream(new FileInputStream((selectedFile)));
            byte[] buf = new byte[2048];
            int size = -1;
            while((size = bis.read(buf)) != -1){
                // 실제 자원들은 buf라는 배열에 저장되어 있다.
                // buf의 0번지~size가 기억하는 수만큼 가져와서 문자열로 생성한다.
                String str = new String(buf, 0, size);
                ta.append(str);
            } // while문의 끝
        } catch (Exception e){
            e.printStackTrace();    // 예외 발생내용을 순차적으로 스텍 형태로 출력

        }
    }
}
