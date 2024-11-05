package am;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TimeEx1 extends JFrame {

    Canvas can = new Canvas() {
        @Override
        public void paint(Graphics g){
            g.setColor(Color.ORANGE);
            g.fillRect(x, y, wh, wh);
        }
    };

    int wh = 20, x, y;
    boolean isRunning;      //false
    int direction;      //이동하는 방향을 기억하는 변수

    int[] ar = {
                KeyEvent.VK_UP,
                KeyEvent.VK_RIGHT,
                KeyEvent.VK_DOWN,
                KeyEvent.VK_LEFT,
               };
    Timer timer;

    public TimeEx1(){
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 상자가 이동할 방향(direction)으로 좌표를 수정한다
                switch (direction) {
                    case KeyEvent.VK_UP :
                        y -= 5;
                        break;
                    case KeyEvent.VK_DOWN:
                        y += 5;
                        break;
                    case KeyEvent.VK_LEFT:
                        x -= 5;
                        break;
                    case KeyEvent.VK_RIGHT:
                        x += 5;
                        break;
                }
                // 좌표가 변경되었으니 캔버스의 그림을 다시 그리자!
                can.repaint();
            }
        });

        this.add(can);


        Dimension d = new Dimension(wh*20, wh*20);
        can.setPreferredSize(d);
//        can.setPreferredSize(new Dimension(wh*20, wh*20));    // 표준수치로 크기 저장
        can.setBackground(Color.BLACK);
        can.setFocusable(true);

        // 상자의 위치를 화면 가운데에 지정하자!
        this.x = d.width/2 - wh/2;
        this.y = d.height/2 - wh/2;

        // 현재 창의 크기를 안에 배치된 객체의 크기에 맞도록 지정한다
        this.pack();
        this.setLocation(300, 50);
        this.setVisible(true);


        // 이벤트 감지자 등록
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        can.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // 현재 게임이 진행이 안될 때만 수행한다
                direction = e.getKeyCode();
                switch (direction) {
                    case KeyEvent.VK_SPACE:     // 게임 시작
                        if (!isRunning) {
                            direction = ar[(int) Math.random() * ar.length];
                            isRunning = true;
                            timer.start();  //타이머 시작과 함께 0.1초마다 action이 움직인다
                        }
                        break;
                }   //switch의 끝
            }
        });
    }

    public static void main(String[] args) {
        // 프로그램 시작
        new TimeEx1();
    }
}
