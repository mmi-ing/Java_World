package pm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DoubleBuffEx1 extends JFrame {
    int x = 200;
    Canvas can;
    public DoubleBuffEx1() {
        this.add(can = new Canvas() {
           // 이 영역은 Canvas를 상속받는 이름없는 내부클래스다.

            @Override
            public void paint(Graphics g) {

                // 버퍼 기능인 이미지 객체를 하나 준비하자!
                // 크기는 현재 Canvas와 동일 크기여야 한다.
                int w = this.getWidth();
                int h = this.getHeight();

                Image buf = createImage(w, h);      // 현재 캔버스와 같은 크기의 이미지 생성
                // Image에만 그림을 그리기 위해 Imgae로부터 붓(Graphics)으르 달라고 해야 한다.
                Graphics buf_g = buf.getGraphics();
                buf_g.setColor(Color.GREEN);
                buf_g.fillRect(x, 235,80,30);   // 이미지에 도형 그리기

                // 이제 buf이미지를 캔버스에 그린다
                g.drawImage(buf, 0, 0, this);

            }
            @Override
            public void update(Graphics g) {
                paint(g);   //  지우지 않고 현재 그림상태를 그대로 가지고 paint 호출
            }
        });

        this.setBounds(300, 50, 500, 600);
        this.setVisible(true);
        can.setFocusable(true);

        // 이벤트 감지자 등록
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);     // 프로그램 종료
            }
        });
        can.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // 키보드에서 키를 누를 때마다 현재 영역 수행
                int code = e.getKeyCode();
//                DoubleBufferEx1.this.setTitle(code+"번");
                switch (code) {
                    case KeyEvent.VK_LEFT:
                        x -= 5;
                        if(x<0)
                            x = 0;
                        break;
                    case KeyEvent.VK_RIGHT:
                        x += 5;
                        if(x>can.getWidth() - 80)
                            x = can.getWidth() - 80;
                        break;
                }   // Switch문의 끝
                can.repaint();
            }
        });
    }
    public static void main(String[] args) {
        // 프로그램 시작
        new DoubleBuffEx1();
    }
}
