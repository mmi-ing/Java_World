package am;

import java.awt.*;
import java.util.ArrayList;

public class CanvasEx2 extends Canvas {

    // 클릭할 때마다 타원 Oval(Ex2)를 생성하여 저장할 곳
    // 이때 배열로 선언하면 안되는 이유는 몇 개를 저장할 지 모르기 때문
//    ArrayList<OvalEx2> list;
    ArrayList<OvalEx2> list = new ArrayList<>();

    @Override
    public void paint(Graphics g) {
        // 타원(OvalEx2)들이 저장된 list를 반복문을 이용하여 그린다.
        for (int i=0; i<list.size(); i++){
            // 리스트로부터 하나씩 요소를 가져온다.
            OvalEx2 ov = list.get(i);

            g.setColor(ov.c);
            g.fillOval(ov.x, ov.y, ov.wh, ov.wh);
        }
    }
}
