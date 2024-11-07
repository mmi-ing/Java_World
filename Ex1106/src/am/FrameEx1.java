package am;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameEx1 extends JFrame {
    // 크기 객체 선언
    Dimension d = new Dimension(390, 590);

    // 필요한 각 이미지들 선언
    Image back_img, me_img, meteor_img;
    Me me = new Me();

    JPanel p = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            // 배경 그리기
            g.drawImage(back_img, 0, 0, this);
            // 주인공 그리기
            g.drawImage(me_img, me.rect.x, me.rect.y, this);
        }
    };

    public FrameEx1() {
        // 이미지들 초기화
        back_img = new ImageIcon("src/images/back.jpg").getImage();
        me_img = new ImageIcon("src/images/me.png").getImage();

        init_game(); //게임 초기화
        init_me_pos();

        this.setLocation(300, 50);
        this.pack();    // 컴포넌트들의 크기ㅔ 맞게 사이즈 설정!
        // 이 경우는 JPanel을 넣었으니 JPanel의 사이즈에 맞춘다.

        this.setResizable(false);   // 창 사이즈 조정 불가
        this.setVisible(true);

        // 이벤트 감지자 등록
        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
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
        new FrameEx1();
    }
}
