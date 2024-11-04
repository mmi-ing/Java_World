package pm;

import am.MyWin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// 사각형 방향키 좌우만 가능, 벽에 부딪히면 부딪히지말라고 경고
// 스페이스 키 누르면
public class Quiz extends JFrame implements KeyListener {
//    JPanel
//    int cmd; // 사용자가 선택한 키의 코드값 저장
    QuizCanvas can;
    public Quiz() {
        this.add(can = new QuizCanvas());

        this.setBounds(300,50,500,500);
        this.setVisible(true);
        this.addWindowListener(new MyWin());

        can.x = can.getWidth()/2 - can.wh/2;
        can.y = can.getHeight()/2 - can.wh/2;

        // 이밴트 감지자
        can.addKeyListener(this);
        this.addKeyListener(this);

    }

    @Override
    public void paint(Graphics g) {

        int red = (int)(Math.random()*256);
        int green = (int)(Math.random()*256);
        int blue = (int)(Math.random()*256);
        Color c = new Color(red,green, blue);

        g.setColor(c);
        
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        // 왼쪽 키, 오른쪽 키, 스페이스바
        switch (code) {
            case KeyEvent.VK_LEFT:
                can.x += 5;
                break;
            case KeyEvent.VK_RIGHT:
                can.y -= 5;
                break;
            case KeyEvent.VK_SPACE:
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {


    }

    public static void main(String[] args) {
        new Quiz();
    }
}
