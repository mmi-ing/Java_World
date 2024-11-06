package am;

import java.awt.*;

public class OvalEx2 extends Thread{
    int x, y, wh;
    Color c;

    FrameEx2 f;  // 부모창 객체의 주소

    public OvalEx2(FrameEx2 f, int x, int y) {
        // 부모창의 주소인 FrameEx2 f는 현재 영역이 아닌
        // run() 메서드에서 사용되어야 한다.
        this.f = f;
        this.wh = (int)(Math.random()*150+50);
        this.x = x - (wh / 2);
        this.y = y - (wh / 2);
//        this.x = x;
//        this.y = y;



        int r = (int)(Math.random()*256);
        int g = (int)(Math.random()*256);
        int b = (int)(Math.random()*256);
        this.c = new Color(r,g,b);

    }

    @Override
    public void run() {
        while (true) {
            // 현재 스레드가 해야할 일은 y좌표를 증가시키면서
            y += 5;
            if(y >= f.p.getHeight()-wh)
                break; // 무한반복문 탈출

            f.p.repaint();// JPanel을 다시 그린다.
            try {
                Thread.sleep(30);
            } catch (Exception e) {

            }
        } // 무한 반복의 끝
    }
}