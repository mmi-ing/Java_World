package pm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ThreadFrameEx4 extends JFrame {
    int x = 0;
    ThreadEx4 t4;   //스레드 객체 준비! - 스페이스바를 누르면 생성하자!
    JPanel p = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            // 더블버퍼링 기법을 쓰기 위해 이미지 객체를 현재 JPanel의 크기와 같은 것을 준비해야 한다.
            Image buf = createImage(this.getWidth(), this.getHeight());

            // 준비된 이미지 객체에게만 그림을 그릴 수 잇는 붓과 같은 객체 준비
            Graphics buf_g = buf.getGraphics();

            buf_g.fillRect(x, 200, 20, 20);

            g.drawImage(buf, 0, 0, this);
        }
    };

    public ThreadFrameEx4() {
        this.add(p);

        this.setBounds(300, 50,500,500);
        this.setVisible(true);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);    // 프로그램 종료
            }
        });

        this.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                int code = e.getKeyCode();
                switch (code) {
                    case KeyEvent.VK_SPACE:
                        t4 = new ThreadEx4(ThreadFrameEx4.this);
                        t4.start();        // 스레드 시작
                        break;
                }
            }
        });
    }


    public static void main(String[] args) {
        // 프로그램 시작
        new ThreadFrameEx4();

    }
}
