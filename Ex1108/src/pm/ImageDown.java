package pm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;

public class ImageDown extends JFrame {

    JPanel center_p;
    JTextField input_tf;
    JButton bt;

    BufferedInputStream bis = null;
    BufferedOutputStream bos = null;

    public ImageDown(){

        center_p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        center_p.add(new JLabel("이미지 경로:"));
        center_p.add(input_tf = new JTextField(50));
        center_p.add(bt = new JButton("이미지 저장"));

        this.add(center_p);

        this.setBounds(300,50,700,120);
        this.setVisible(true);

        // 이벤트 감지자 등록
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // 종료하기 전에 닫아야 할 것들이 있으면 닫는다
                System.exit(0);
            }
        });
        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //[이미지 저장] 버튼을 클랙했을 때만 수행하는 곳
                JFileChooser jfc = new JFileChooser("/Users/ham/My_Study");
                String url_path = input_tf.getText().trim();

                // 파일명만 알아내기
                int idx = url_path.lastIndexOf("/");
                String fname = url_path.substring(idx+1); //파일명만 추출

                // 추출한 파일명을 파일 선택기에게 지정한다.
                jfc.setSelectedFile(new File(fname));

                int cmd = jfc.showSaveDialog(ImageDown.this);
                if(cmd == JFileChooser.APPROVE_OPTION) {

                    // 선택된 파일 가져오기
                    File f = jfc.getSelectedFile();
                    if(url_path.length() > 7) {     // http://
                        try {
                            URL url = new URL(url_path); // 웹상의 경로를 객체화
                            // 웹 상에 존재한느 이미지 경로와 연결 된 스트림 생성
                            bis = new BufferedInputStream(url.openStream());

                            // 웹 상의 이미지를 저장할 파일과 연결하는 스트림
                            bos = new BufferedOutputStream(new FileOutputStream(f));

                            int size = -1;
                            byte[] buf = new byte[2048];
                            while ((size = bis.read(buf)) != -1) {
                                // 읽은 자원들은 모두 buf배열에 저장된 상태다.
                                // 읽기한 수는 size가 기억하므로 buf의 0번지부터 size 수만큼 쓰기하면 된다.
                                bos.write(buf, 0 ,size);
                                bos.flush();
                            }
                            JOptionPane.showMessageDialog(ImageDown.this, "저장완료");
                        } catch (Exception e2) {

                        }
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        // 프로그램 시작
        new ImageDown();
    }
}
