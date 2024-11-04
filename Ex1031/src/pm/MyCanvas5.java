package pm;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MyCanvas5 extends Canvas implements MouseMotionListener {
    int x = -50, y;
    int wh = 30;
    Color color, existing;

    public MyCanvas5() {

        // 이벤트 감지자 등록
        this.addMouseMotionListener(this);
    }

    @Override
    public void paint(Graphics g){
        g.fillOval(x-wh/2, y-wh/2, wh,wh);
    }

    @Override
    public void update(Graphics g) {
        // 현재 그림 상태를 그대로 유지하여 paint를 호출하도록 하면
        // 기존 그림을 지우지 못한다.
        paint(g);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // 마우스로 드래그할 때마다 수행하는 곳
        x = e.getX();
        y = e.getY();
        this.repaint();  //  -> update() -> paint()
        //      지우기       그리기
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
