package am;

import java.awt.*;
import java.util.Iterator;

public class MeteorEx2 extends Thread {
    // 운석을 의미하는 클래스
    // 위치와 크기를 Rectangle로 지정
    Rectangle rect = new Rectangle();
    int speed;

    // 현재 운석객체는 JFrame정보를 가지고 있어야 한다.
    // 이유는 그곳에 있는 ArrayList와 JPanel등을 접근해야하기 때문이다.
    FrameEx2 f;
    public MeteorEx2(FrameEx2 f, int w, int h) {
        this.f = f;

        // 받은 w와 h는 Rectangle에 저장한다,
        rect.width = w;
        rect.height = h;

        speed = (int)(Math.random()*200+20);
    }

    @Override
    public void run() {
        // 무한반복을 통해 y값을 증가시킨다.
        // 이때 화면 하단에 도달할 경우 무한반복을 탈출한다.
        while (true) {
            rect.y += 3;

            // 화면 하단에 도달했는지? 확인!!
            if (rect.y >= f.p.getSize().height - rect.height)
                break;

            // 주인공과 현재 운석이 충돌했을 수도 있으므로 충돌 검사를 해보자
            if (rect.intersects(f.me.rect))
                break;

            try {
                Thread.sleep(speed);
            } catch (Exception e) {
            }
            f.p.repaint();
        }
        Iterator<MeteorEx2> it = f.m_list.iterator();
        while(it.hasNext()) {
            MeteorEx2 m = it.next();
            // 하나 가져온 m의 주소가 현재 객체의 주소와 같은지? 비교하자!
            if(m == this) {
                f.m_list.remove(m);
                break;
            }
        } // while문의 끝
    }
}
