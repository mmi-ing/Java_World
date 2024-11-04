package pm;

import java.awt.*;
import java.awt.event.KeyEvent;

public class CanvasEx1 extends Canvas {

    int cmd; // 사용자가 선택한 키의 코드값이 저장되는 곳
    int x = 10, y = 10;

    @Override
    public void paint(Graphics g) {

        int red = (int)(Math.random()*256);
        int green = (int)(Math.random()*256);
        int blue = (int)(Math.random()*256);
        Color c = new Color(red,green, blue);

        g.setColor(c);

        // 1번 키 : 타원, 2번 키 : 채워진 타원, 3번 키 : 사각형, 4번 키 : 채워진 사각형
        switch (cmd) {
            case KeyEvent.VK_1:
                g.drawOval(x, y, 100,100);
                break;  //  switch문 탈출
            case KeyEvent.VK_2:
                g.fillOval(x, y, 100,100);
                break;  //  switch문 탈출
            case KeyEvent.VK_3:
                g.drawRect(x, y, 100,100);
                break;  //  switch문 탈출
            case KeyEvent.VK_4:
                g.fillRect(x, 4, 100,100);
                break;  //  switch문 탈출
            case KeyEvent.VK_5:
                g.drawString("쌍용교육센터", 100,100);
                break;  //  switch문 탈출

        }
    }
}
