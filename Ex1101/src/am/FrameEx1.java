package am;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class FrameEx1 extends JFrame implements MouseMotionListener {

    // 현재 창에 들어갈 객체들 모두 멤버변수로 선언
    CanvasEx1 can;

    public FrameEx1() {
        this.add(can = new CanvasEx1());

        this.setBounds(300, 50, 500,450);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 이벤트 감지자 등록 - 캔버스 위에서 마우스를 이동할 것이므로
        // 이벤트 대상객체는 캔버스다.
        can.addMouseMotionListener(this);
    }

    public static void main(String[] args) {
        new FrameEx1();
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // 마우스가 이동할 때마다 호출되는 곳
        // 현재 마우스의 위치(x, y)를 캔버스의 멤버변수인 x, y에 저장한다.
        can.x = e.getX();
        can.y = e.getY();
        can.repaint();      // --> update()  -->  paint()

    }

}
