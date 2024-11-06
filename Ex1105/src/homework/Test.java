package homework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class Test extends JFrame {

    JPanel p;
    int w = 80;
    int h = 30;
    int x,y;

    ArrayList<Bullet> list = new ArrayList<>();

    public Test() {
        this.add(p = new JPanel() {
            // 현재 영역은 JPanel을 상속받는 익명의 내부클래스 영역이다.
            @Override
            protected void paintComponent(Graphics g) {
                // 더블버퍼링 기법 - 현 JPanel과 같은 크기의 Image객체를 준비한다.
                Image buf = createImage(this.getWidth(), this.getHeight());

                // 준비된 이미지 객체에만 그림을 그릴 수 있는 붓 객체를 준비한다.
                Graphics buf_g = buf.getGraphics();
                // 그림을 그리기 위해 붓(Graphics)이 필요한 것이며 그 붓은 반드시
                // 그리고자 하는 곳(Image)으로 부터 얻어야 한다.

                buf_g.fillRect(x, y, w, h);     //  주인공 상자 그리기

                // 총알 그리기
//                for(int i = 0; i<list.size(); i++){
//                    Bullet b = list.get(i);
//                }
                // 개선된 루푸형
                for(Bullet b : list) {
                    // 총알객체를 list로부터 하나씩 얻어내어 b라는 변수에 저장랬다.
                    buf_g.fillOval(b.x, b.y, b.w, b.h);
                }

                // 이렇게 그림이 그려진 Image를 다시 현 JPanel에 이미지를 그린다
                g.drawImage(buf, 0, 0, this);


            }
        });
        this.setBounds(300, 50, 600, 500);
        this.setVisible(true);
        x = p.getWidth()/2 - w/2;   // setVisible 후에 할 것
        y = p.getHeight() - (h+5); // 상자의 y값도 되지만 총알의 y값으로도 쓰인다.
        p.setFocusable(true);   // Jpanel을 활성화!

        // 이벤트 감지자 등록
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0); // 프로그램 종료
            }
        });
        p.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                // 사용자가 누른 키의 코드값만 알아낸다
                int code = e.getKeyCode();

                switch (code) {
                    case KeyEvent.VK_LEFT:
                        x -= 5 ;
                        // x가 0보다 작다는 것은 왼쪽 벽을 지나갔다는 의미다.
                        // 이건 있을 수 없는 일이므로 x의 값ㅇ르 다시 0으로 초기화 한다.
                        if(x < 0)
                            x = 0;
                        break;
                    case KeyEvent.VK_RIGHT:
                        x += 5 ;
                        if(x > p.getWidth()-w)
                            x = p.getWidth()-w;
                        break;
                    case KeyEvent.VK_SPACE:
                        // 스페이스 바를 누를 때마다 총알 객체 생성
                        Bullet b = new Bullet(x+37, y, Test.this);
//                        Bullet b1 = new Bullet(x+(w-8), y, Test.this);

                        // 생성된 총알객체를 ArrayList에 저장한다.
                        list.add(b);    // 이렇게 저장해둬야지 나중에 그림을 그릴 때
                                        // list에 있는 총알들을 모두 가지고 와서 그릴 수 있다.
//                        list.add(b1);
                        // 총알들은 모두가 스레드다.
                        b.start();      // ---> Bullet의 run메서드 호출
//                        b1.start();
                        break;
                } // switch의 끝
                // 프로그램의 흐름이 현재 위치에 왔을 때는 좌표가 변경됐을 것이다
                // 그러면 그림을 다시 그려야 한다.
                p.repaint();
            }
        });
    }
    public static void main(String[] args) {
        // 프로그램 시작
        new Test();

    }

}
