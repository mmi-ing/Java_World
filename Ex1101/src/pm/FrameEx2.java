package pm;

import am.MyWin;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FrameEx2 extends JFrame implements KeyListener {

    // 현재 창에 들어갈 객체들을 멤버변수로 선언
    CanvasEx2 can;

    public FrameEx2() {
        this.add(can = new CanvasEx2());

        this.setBounds(300, 50, 500, 500);
        this.setVisible(true);
        this.addWindowListener(new MyWin());

        can.x = can.getWidth()/2 - can.wh/2;
        can.y = can.getHeight()/2 - can.wh/2;

        // 이밴투 감지자
        can.addKeyListener(this);
        this.addKeyListener(this);
    }

    public static void main(String[] args) {
        new FrameEx2();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // 키를 누를 때마다 수행하는 곳
        int code = e.getKeyCode();

        switch (code) {
            case KeyEvent.VK_UP:
                can.y -= 5;     // can.y = can.y-5;
                break;
            case KeyEvent.VK_DOWN:
                can.y += 5;     // can.y = can.y-5;
                break;
            case KeyEvent.VK_LEFT:
                can.x -= 5;     // can.y = can.y-5;
                break;
            case KeyEvent.VK_RIGHT:
                can.x += 5;     // can.y = can.y-5;
                break;
        }
        // 좌표가 변경됐으니 캔버스의 그림을 다시 그린다.
        can.repaint();

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
