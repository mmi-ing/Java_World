package homework;

import java.util.ArrayList;

public class Bullet extends Thread{

    int x, y;
    int w = 8, h = 20;
    Test f;     // 현재 객체가 생성되는 시점이 스페이스바를 누를 때다.
    // 그리고 현재 객체에서는 Test의 멤버변수인 ArrayList 또는 Jpanel을 접근할 때가 생김
    // 그래서 Arraylist와 JPanel을 가지고 잇는 Test의 주소를 받아서 저장하고 있어야 한다.

    public Bullet(int x, int y, Test f) {
        this.x = x;
        this.y = y;
        this.f = f;
    }

    @Override
    public void run() {
        // 일정 시간동안 쉬며서 y좌표를 감소 시킨다.
        while(true) {
            y -= 5;
            // 좌표값이 변경되었으므로 다시 그림을 그리도록 한다.
            f.p.repaint();
            try {
                Thread.sleep(20);
            } catch (Exception e) { }
            // 현재 총알이 화면 상단에 달하면 무한반복을 탈출하여 스레드를 소멸시키자!
            if(y<0)
                break;  // 무한반복 탈출
        }   //  while의 끝
        // Test객체의 멤버들 중 list라는 ArrayList에서 현재 객체 삭제!
        f.list.remove(this);
        f.p.repaint();
    }

}
