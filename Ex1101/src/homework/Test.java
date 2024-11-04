package homework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Test extends JFrame {
    int x, y, w = 100, h = 50;
    Color c;    // 객체자료형의 기본값은 null이다.
    Canvas can = new Canvas() {
        //Canvas를 상속받는 이름없는 내부클래스
        @Override
        public void paint(Graphics g){
            g.fillRect(x, y, w, h);
        }

    };

    public  Test() {
        this.add(can);  // 현재 창 가운데에 추가!

        this.setBounds(300, 50,600,550);
        this.setVisible(true);

        // 현재 창 가운데에 상자 그림을 그리기 위해 현재 캔버스의 너비에서 2를 나눈 후
        // 상자의 너비에서 2를 나눈 값을 뺀다.
        this.x = can.getWidth()/2 - w/2;
        this.y = can.getHeight() - (h+5);

        //이벤트 감지자 등록
        this.addWindowListener(new WindowAdapter() {
            //windowadapter를 상속받는 익명의 내부크래스가 생성되는 내부의 영역
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);    //프로그램 종료
            }
        });


        this.addKeyListener(new KeyAdapter() {
            // KeyAdapter를 상속받는 익명의 내부클래스 영역
            // 곧 이 안에서 this는 KeyAdapter를 상속받는 내부클래스를 의미함!
            @Override
            public void keyPressed(KeyEvent e){
                // 사용자가 누른 키의 코드를 얻어낸다.
                int code = e.getKeyCode();

                switch (code){
                    case KeyEvent.VK_LEFT:  // 왼쪽 방향키
                        Test.this.x -= 10;  // 내부클래스에서 바깥쪽 클래스를 지칭하는 법
                                            // 바깥쪽클래스명.this
                        if(Test.this.x < 2)
                            Test.this.x = 2;
                        break;  //switch문 탈출
                    case KeyEvent.VK_RIGHT:  // 왼쪽 방향키
                        Test.this.x += 10;  // 내부클래스에서 바깥쪽 클래스를 지칭하는 법
                        if(Test.this.x > (Test.this.can.getWidth()-(Test.this.w+2)))
                            Test.this.x = Test.this.can.getWidth()-(Test.this.w+2);
                        break;  //switch문 탈출
                    case KeyEvent.VK_SPACE:
                        // 색상 선택
                        int red = (int)(Math.random()*256);
                        int green = (int)(Math.random()*256);
                        int blue = (int)(Math.random()*256);

                        Test.this.c = new Color(red, green, blue);
                        break;
                }
                // 좌표가 변경되었으니 캔버스의 그림을 다시시 그린다.
                Test.this.can.repaint();     // 변수를 자신한테서 찾다가 없으면 바깥쪽 클래스에서 찾는다.
            }
        });
    }   // 생성자의 끝

    public static void main(String[] args) {
        // 프로그램 시작
        new Test();
    }

}
