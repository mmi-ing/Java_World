package am;

import java.awt.*;

public class ExplosionEx3 {
    // 주인공과 운석이 충돌했을 때 폭발이 발생하는 의미의 클래스다.
    int size = 128;

    Point pt = new Point();

    // 현재 객체가 하나 생성도리 때는 운석이 주인공이랑 충돌할 때다.
    // 아때 운석이 폭발하면서 사라져야 한다.

    // 폭발 이미지는 27개이며 이들은 JFrame창에 배열로 미리 준비해두자
    // 배열을 접근하는 index값을 준비하자!
    int index;  // 0
    int gap = 5;    // 반복 수행이 gap만큼 돌 때 index증가
    int interval = gap;

    public boolean move_index() {
        if(interval == gap)
            index++;

        interval--;
        if(interval == 0)
            interval = gap;

        // 인덱스 값은 27이 되면 현재 함수는 폭발이미지 27개를 모두 표현한 경우이므로
        // 현재 객체의 폭발 역할이 끝나야 한다.
        return index >= 27;

    }

}
