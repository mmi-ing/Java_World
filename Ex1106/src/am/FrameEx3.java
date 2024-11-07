package am;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class FrameEx3 extends JFrame {
    // 크기 객체 선언
    Dimension d = new Dimension(390, 590);

    // 필요한 각 이미지들 선언
    Image back_img, me_img, meteor_img;
    Me me = new Me();

    // 두 번째 작업 내용 -------------------------------------
    ArrayList<MeteorEx3> m_list = new ArrayList<>();

    // 운석을 주기적으로 생성하여 m_list에 저장하는 스레드
    Thread makeMeteor = new Thread() {
        @Override
        public void run() {
            // 1초 간격으로 운석객체를 생성하여 m_list에 추가한다.
            // 반드시 p의 paintComponent에서 그림으로 그려야 한다.
            // 생성된 운석객체의 스레드를 구동시킨다.
            while (true) {
                // 운석객체 생성
                MeteorEx3 m = new MeteorEx3(FrameEx3.this, 35, 30);

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

    // 세 번째 작업 내용 ----------------------------------------------------------------
    // 폭발객체(ExplotionEx3)가 저장될 곳
    ArrayList<ExplosionEx3> ex_list = new ArrayList<>();

    // 폭탄 이미지들
    Image[] exp_ar = new Image[27];

    JPanel p = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            // 배경 그리기
            g.drawImage(back_img, 0, 0, this);
            // 주인공 그리기
            g.drawImage(me_img, me.rect.x, me.rect.y, this);

            // m_list를 복사본을 만든다
            ArrayList<MeteorEx3> copy_list = new ArrayList<>(m_list);
            for(MeteorEx3 m : copy_list) {
                g.drawImage(meteor_img, m.rect.x, m.rect.y, this);
            }

            // 폭발객체는 모두 ex_list에 저장되어 있다. 이거 하나당 27개의 이미지를 표현!
            ArrayList<ExplosionEx3> exp_list = new ArrayList<>(ex_list);
            for(ExplosionEx3 exp : exp_list) {
                // 폭발 객체 안에 있는 index를 이용하여 exp_ar이라는 배열의 index로 삼고
                // 그릴 폭발 이미지를 하나 가져온다
                Image img = exp_ar[exp.index];
                g.drawImage(img, exp.pt.x, exp.pt.y, this);

                // 폭발 객체 안에 있는 move_index() 함수를 5번 호출할 때마다 index값이 1씩 증가한다.
                // 그리고 index값이 27이 됐을 때 move_index함수는 true를 반환하여 폭발이 끝났음을 알려준다,
                if(exp.move_index())
                    ex_list.remove(exp);    // 폭발이 끝난 객체는 삭제
            }
        }
    };

    public FrameEx3() {
        // 이미지들 초기화
        back_img = new ImageIcon("src/images/back.jpg").getImage();
        me_img = new ImageIcon("src/images/me.png").getImage();
        meteor_img = new ImageIcon("src/images/meteor.png").getImage();

        // 폭발 이미지 27개 생성
        for(int i = 0; i<exp_ar.length; i++){
            // src/iamges/exp_enumy_1/exp_1.png ---> exp_ar[0]
            String img_path = String.format("src/images/exp_enemy_1/exp_%d.png", i+1);

            // 위으 ㅣ경로를 가지고 이미지 로드
            Image exp = new ImageIcon(img_path).getImage();

            // 로드된 이미지객체를 배열에 저장!
            exp_ar[i] = exp;

        }
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
        new FrameEx3();
    }
}
