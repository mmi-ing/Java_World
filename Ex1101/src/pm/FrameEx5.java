package pm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class FrameEx5 extends JFrame {
    int x=30, y=100, wh=120;
    Canvas can = new Canvas() {
        @Override
        public void paint(Graphics g){
            // Canvas를 상속받는 익명의 내부클래스
            g.fillRect(x, y, wh, wh);
        }
    };
    public FrameEx5() {
        this.add(can);  // 현재 창에 캔버스를 가운데에 추가!
        this.setBounds(300, 50, 500,450);
        this.setVisible(true);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

        });
    }
    public static void main(String[] args) {
        new FrameEx5();
    }
}
