package pm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DoubleBuffEx2 extends JFrame {
    int x = 210;
    JPanel p =new JPanel() {
        // JPanel을 상속받는 익명의 내부 클래스 정의
        @Override
        protected void paintComponent(Graphics g){
            // 현재 JPanel과 같은 크기의 이미지를 생성한다.
            Image buf = createImage(this.getWidth(), this.getHeight());

            //buf에만 그림을 그릴 수 있는 붓을 얻어낸다.
            Graphics buf_g = buf.getGraphics();
            buf_g.fillRect(x, 235, 80, 30); // buf이미지에 그림을 그린다.

            // 그림을 그린 이미지를 JPannel에 붙여넣는다.
            g.drawImage(buf, 0, 0, this);
        }
    };

    public DoubleBuffEx2() {
        this.add(p);
        p.setFocusable(true);

        this.setBounds(300, 50, 500,500);
        this.setVisible(true);

        //이벤트 감지자 등록
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        p.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // 키를 누를 때마다 현재 영역 수행
                int code = e.getKeyCode();
                switch (code) {
                    case KeyEvent.VK_LEFT:
                        x -= 5;
                        if( x < 0 )
                            x = 0;
                        break;
                    case KeyEvent.VK_RIGHT:
                        x += 5;
                        if (x > p.getWidth()-80)
                            x = p.getWidth()-80;
                        break;
                } // switch문의 끝
                p.repaint();   // 좌표가 변경되었으니 다시 그린다.
            }
        });
    }

    public static void main(String[] args){
        // 프로그램 시작
        new DoubleBuffEx2();
    }
}
