package am;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class FrameEx2 extends JFrame {
    // 크기 객체 선언
    Dimension d = new Dimension(390, 590);

    // 필요한 각 이미지들 선언
    Image back_img, me_img, meteor_img;
    Me me = new Me();

    // 두 번째 작업 내용 -------------------------------------
    ArrayList<MeteorEx2> m_list = new ArrayList<>();

    // 운석을 주기적으로 생성하여 m_list에 저장하는 스레드
    Thread makeMeteor = new Thread() {
        @Override
        public void run() {
            // 1초 간격으로 운석객체를 생성하여 m_list에 추가한다.
            // 반드시 p의 paintComponent에서 그림으로 그려야 한다.
            // 생성된 운석객체의 스레드를 구동시킨다.
            while (true) {
                // 운석객체 생성
                MeteorEx2 m = new MeteorEx2(FrameEx2.this, 35, 30);

                // 운석의 위치
                int x = (int) (Math.random() * p.getSize().width - 35);

                m.rect.x = x;
                m.rect.y = -30;

                m_list.add(m);// 생성된 운석객체를 ArrayList에 저장
                m.start(); // 생성된 운석객체의 스레드 구동

                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
            } // while문의 끝
        }
    };
    //--------------------------------------------------------------------------------------------------
    JPanel p = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            // 배경 그리기
            g.drawImage(back_img, 0, 0, this);
            // 주인공 그리기
            g.drawImage(me_img, me.rect.x, me.rect.y, this);

            // 2번째 작업에서 추가된 내용 : 운석 그리기
            // 운석들은 모두 ArrayList에 있다.
            /*
            for(MeteorEx2 m : m_list) {
                // 운석을 하나씩 그린다.
                g.drawImage(meteor_img, m.rect.x, m.rect.y, this);
            }
            */
//            Iterator<MeteorEx2> it = m_list.iterator();
//            while (it.hasNext()) {
//                MeteorEx2 m = it.next();
//                g.drawImage(meteor_img, m.rect.x, m.rect.y, this);
//            }
            // m_list를 복사본을 만든다
            ArrayList<MeteorEx2> copy_list = new ArrayList<>(m_list);
            for(MeteorEx2 m : copy_list) {
                g.drawImage(meteor_img, m.rect.x, m.rect.y, this);
            }
        }
    };

    public FrameEx2() {
        // 이미지들 초기화
        back_img = new ImageIcon("src/images/back.jpg").getImage();
        me_img = new ImageIcon("src/images/me.png").getImage();
        meteor_img = new ImageIcon("src/images/meteor.png").getImage();

        init_game(); //게임 초기화
        init_me_pos();

        this.setLocation(300, 50);
        p.setFocusable(true);
        this.pack();    // 컴포넌트들의 크기ㅔ 맞게 사이즈 설정!
        // 이 경우는 JPanel을 넣었으니 JPanel의 사이즈에 맞춘다.

        this.setResizable(false);   // 창 사이즈 조정 불가
        this.setVisible(true);

        makeMeteor.start(); // 2번째 작업 : 운석들을 생성하는 스레드 시작!

        // 이벤트 감지자 등록
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // 키 이벤트 감지자 등록
        p.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // 방향키들 중 좌/우측을 받아내어 me의 rect안에 x값을 증/감소 시킨다
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        me.rect.x -= 5;
                        if(me.rect.x < 0)
                            me.rect.x = 0;
                        break;
                    case KeyEvent.VK_RIGHT:
                        me.rect.x += 5;
                        if(me.rect.x > d.width-me.rect.width)
                            me.rect.x = d.width-me.rect.width;
                        break;
                }// switch의 끝!
                // 주인공의 위치가 변경되었으니 다시 그림을 그린다.
                p.repaint();
            }
        });
    }

    private void init_game() {
        // 게임 시작할 때 생성자에서 딱 한 번 호출하는 애
        // 크기객체(Dimension)을 가지고 JPanel의 크기로 예약하자!
        p.setPreferredSize(d);

        // 크기가 지정된 JPanel을 현재 창 가운데에 추가!
        this.add(p);
    }

    private void init_me_pos() {
        // 주인공의 초기 위치를 지정하는 함수

        // 주인공 이미지의 너비
        int imgWidth = me_img.getWidth(this);
        int imgHeight = me_img.getHeight(this);

        // Me객체 안에 Rectangle의 x, y, width, height를 지정하자
        me.rect.x = (d.width-imgWidth) / 2;
        me.rect.y = d.height-imgHeight-5;

        me.rect.width = imgWidth;
        me.rect.height = imgHeight;
    }

    public static void main(String[] args) {
        // 프로그램 시작
        new FrameEx2();
    }
}
