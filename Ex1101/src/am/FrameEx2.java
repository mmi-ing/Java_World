package am;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FrameEx2 extends JFrame implements MouseListener {

    CanvasEx2 can;

    public FrameEx2() {
        can = new CanvasEx2();
        this.add(can);

        this.setBounds(300, 50, 600, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 이벤트 감지자 등록
        can.addMouseListener(this);
    }

    public static void main(String[] args) {
        new FrameEx2();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // 마우스 버튼을 누를 때마다 호출하는 곳
        // 마우스를 누른 시점의 좌표(x, y)를 얻어낸다
        int x = e.getX();
        int y = e.getY();

        OvalEx2 o = new OvalEx2(x, y);

        // 생성하자마자 캔버스가 가지는 list에 저장해야한다
        can.list.add(o);

        //캔버스 다시 그리기
        can.repaint();

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
