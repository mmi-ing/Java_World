package am;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DownBallFrameEx1 extends JFrame {
    JPanel p;
    int y = 0;

    Thread t1 = new Thread(){
        //Thread를 상속받는 익명의 내부클래스 영역!

        @Override
        public void run() {
            // 현 스레드가 해야할 일들....
            // 1) y좌표 증가
            // 2) p의 그림 다시 그리기
            // 3) 일정 시간 휴식(sleep)
            // 4) 1-3 모두 반복

            while (true) {
                y += 8;

                // 바닥(JPannel의 높이)에 도달햇다면 무한반복 탈출
                if(y >= p.getHeight()-60)
                    break;; //무한반복 탈출

                p.repaint();
                try {
                    Thread.sleep(20);
                } catch (Exception e) {
                    // 예외가 발생했을 때만 수행하는 곳
                    // 할 것이 없다면 비워두면 된다.
                }
            } // 무한 반복의 끝
        } // run함수의 끝
    };

    public DownBallFrameEx1() {
        this.add(p=new JPanel(){
            @Override
            protected void paintComponent(Graphics g){
                // 더블버퍼링 기법을 사용하기 위해 Image 객체를 현재 JPanel과 같은 크기로 만들자
                Image buf = createImage(this.getWidth(), this.getHeight());

                // 이렇게 준비된 Image에는 g라는 Graphics로 그림을 그릴 수 없다.
                // Image객체에만 그림을 그리는 전용 붓을 준비하자!
                Graphics buf_g = buf.getGraphics();

                buf_g.setColor(Color.MAGENTA);
                buf_g.fillOval(170, y, 60, 60);

                // 그림이 그려진 Image를 현재 JPannel에 추가
                g.drawImage(buf, 0, 0, this);

            }
        });

        this.setBounds(300, 50, 400, 500);
        this.setVisible(true);

        p.setFocusable(true);

        // 이벤트 감지자 등록
        this.addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);     // 프로그램 종료
            }
        });

        // 스페이스바를 눌렀을 때 t1이라는 스레드가 구동 되기를 원한다면
        // 다음과 같은 KeyListener를 즉 감지자를 등록해야 한다.
        p.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int code = e.getKeyCode();  // 키보드로부터 키를 눌렀을 때 코드값을 얻기
                // 그 코드값이 스페이스 바일 경우 스레드를 구동한다.
                switch(code){
                    case KeyEvent.VK_SPACE:
                        t1.start();
                }
            }
        });
    }
    public static void main(String[] args) {
        new DownBallFrameEx1();
    }
}
