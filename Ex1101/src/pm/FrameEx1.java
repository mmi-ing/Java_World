package pm;

import pm.CanvasEx1;
import am.MyWin;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FrameEx1 extends JFrame implements KeyListener {

     CanvasEx1 can;

    public FrameEx1() {
        this.add(can = new CanvasEx1());

        this.setBounds(300, 50, 300, 300);
        this.setVisible(true);
        this.addWindowListener(new MyWin());

        // 키 이벤트 감지자 등록
        can.addKeyListener(this);
        this.addKeyListener(this);
    }

    public static void main(String[] args) {
        new pm.FrameEx1();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // 키보드의 키를 누를 때 수행하는 곳
        // 누른 키의 코드값을 캔버스의 cmd에 저장하면 된다.
        can.cmd = e.getKeyCode();
        can.repaint();

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
