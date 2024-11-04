package am;

import java.awt.*;

public class OvalEx2 {
    int x, y, wh;
    Color c; //색상

    public OvalEx2(int x, int y) {
//        this.x = x; // 지역 변수 x, y랑 멤버 변수 x, y의 이름이 같기 때문에 지역 변수만 적용이 됨 -> 멤버 변수를 언급하기 위해서 this.x, tihs.y를 사용
//        this.y = y; // 그냥 x는 인자인 x 즉 지역변수를 의미하며, 인자 x를 멤버변수 x, 다시 말해 this.x에 저장한다.

        // 크기(너비, 높이) 지정
        wh = (int)(Math.random() * 150 + 50);

        // x와 y를 클릭한 지점을 중심으로 조정
        this.x = x - wh / 2;
        this.y = y - wh / 2;

        // 색상을 랜덤하게 만들어보자!
        int red = (int)(Math.random()*256);
        int green = (int)(Math.random()*256);
        int blue = (int)(Math.random()*256);
        c = new Color(red, green, blue);

        // 크기(너비, 높이) 지정
        wh = (int)(Math.random()*150+50);
    }
}
