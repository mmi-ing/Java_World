package am;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class OutFrameEx4 extends JFrame {

    JTextArea ta;

    // 메뉴관련 객체들 선언
    JMenuBar bar;
    JMenu file_m;
    JMenuItem new_item, save_item, exit_item;

    // 저장시 사용할 스트림
    BufferedOutputStream bos;
    File selectedFile;

    public OutFrameEx4() {
        // 메뉴에 관련도나 객체들 생성-순서는 상관없다
        bar = new JMenuBar();

        file_m = new JMenu("파일");

        new_item = new JMenuItem("새 파일");
        save_item = new JMenuItem("저장");
        exit_item = new JMenuItem("종료");

        // 생성된 메뉴 관련 객체들을 배치한다.
        // 배치는 JMenuItem ---> JMenu ---> JMenuBar
        file_m.add(new_item);
        file_m.add(save_item);
        file_m.addSeparator(); // 구분선
        file_m.add(exit_item);

        bar.add(file_m);

        this.setJMenuBar(bar);

        // 현재 창 가운데에 JTextArea를 가지는 스크롤바를 생성하여 추가하자!
        this.add(new JScrollPane(ta = new JTextArea()));

        this.setBounds(300, 50,600,600);
        this.setVisible(true);

        // 이벤트 감지자 등록
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
               closed();
            }
        });
        exit_item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closed();
            }
        });
        save_item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 저장을 눌럿을 때만 수행하는 곳!
                // 파일 선택기 생성 - 저장모드
                JFileChooser jfc = new JFileChooser("/Users/ham/My_Study");
                int cmd = jfc.showSaveDialog(OutFrameEx4.this);
                // 사용자가 저장 승인을 눌렀는지? 확인하자!
                if(cmd == JFileChooser.APPROVE_OPTION){
                    // 멤버변수 selectedField에 선택된 파일을 저장한다.
                    selectedFile = jfc.getSelectedFile();
                    try{
                        bos = new BufferedOutputStream(new FileOutputStream(selectedFile));
                        // JTextArea에 있는 모든 문자열을 가져온다.
                        String str = ta.getText();
                        byte[] ar = str.getBytes();

                        bos.write(ar, 0, ar.length);
                        bos.flush();    // 스트림의 모든 자원들 방출
                    } catch (Exception e2){
                        e2.printStackTrace();
                    }
                }
            }
        });

    }

    private void closed() {
        // 종료하기 전에 사용된 스트림들 모두 닫기
        try {
            if(bos != null)
                bos.close();
        } catch (Exception e){

        }
        System.exit(0);
    }
    public static void main(String[] args) {
        // 프로그램 시작
        new OutFrameEx4();
    }
}
