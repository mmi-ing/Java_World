package pm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

public class Frame extends JFrame {
    JTextArea ta;

    // 메뉴관련 객체들 선언
    JMenuBar bar;
    JMenu file_m;
    JMenuItem new_item, open_item, save_item, exit_item;

    // 저장시 사용할 스트림
    BufferedOutputStream bos;
    File selectedFile;

    public Frame() {
        // 메뉴에 관련도나 객체들 생성-순서는 상관없다
        bar = new JMenuBar();

        file_m = new JMenu("파일");

        new_item = new JMenuItem("새 파일");
        open_item = new JMenuItem("열기");
        save_item = new JMenuItem("저장");
        exit_item = new JMenuItem("종료");

        // 생성된 메뉴 관련 객체들을 배치한다.
        // 배치는 JMenuItem ---> JMenu ---> JMenuBar
        file_m.add(new_item);
        file_m.add(open_item);
        file_m.add(save_item);
        file_m.addSeparator(); // 구분선
        file_m.add(exit_item);

        bar.add(file_m);

        this.setJMenuBar(bar);

        // 현재 창 가운데에 JTextArea를 가지는 스크롤바를 생성하여 추가하자!
        this.add(new JScrollPane(ta = new JTextArea()));

        this.setBounds(300, 50, 600, 600);
        this.setVisible(true);

        // 이벤트 감지자 등록
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closed();
            }
        });
        // 새 파일
        new_item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.setText(""); // 텍스트 영역을 비운다.
                selectedFile = null; // 새 파일이므로 기존 선택된 파일을 해제한다.
            }
        });
        // 열기
        open_item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser("/Users/ham/My_Study");
                int cmd = jfc.showOpenDialog(Frame.this);
                if (cmd == JFileChooser.APPROVE_OPTION) {
                    selectedFile = jfc.getSelectedFile();
                    try (BufferedReader br = new BufferedReader(new FileReader(selectedFile))) {
                        ta.setText(""); // 기존 텍스트 초기화
                        String line;
                        while ((line = br.readLine()) != null) {
                            ta.append(line + "\n");
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        // 저장
        save_item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveFile();
            }
        });
        // 종료
        exit_item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closed();
            }
        });
    }
    private void saveFile() {
        // selectedFile이 null인지 확인하여 파일 선택기 표시 여부 결정
        if (selectedFile == null) {
            JFileChooser jfc = new JFileChooser("/Users/ham/My_Study");
            int cmd = jfc.showSaveDialog(Frame.this);
            if (cmd == JFileChooser.APPROVE_OPTION) {
                selectedFile = jfc.getSelectedFile();
            } else {
                return; // 사용자가 취소한 경우 저장하지 않음
            }
        }
        // 파일을 저장하는 로직
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(selectedFile))) {
            String str = ta.getText();
            byte[] ar = str.getBytes();
            bos.write(ar, 0, ar.length);
            bos.flush(); // 버퍼 비우기
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void closed() {
        // 종료하기 전에 사용된 스트림들 모두 닫기
        try {
            if (bos != null)
                bos.close();
        } catch (Exception e) { }
        System.exit(0);
    }

    public static void main(String[] args) {
        // 프로그램 시작
        new Frame();
    }
}

