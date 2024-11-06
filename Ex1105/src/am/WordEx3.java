package am;

import java.awt.*;

public class WordEx3 extends Thread {
    int x, y;
    String word; //단어를 저장하는 변수
    Color c;
    DownWordFrameEx3 w;

    public WordEx3(DownWordFrameEx3 w, int x, int y, String word) {
        this.w = w;
        this.x = x;
        this.y = y;

        int r = (int)(Math.random()*256);
        int g = (int)(Math.random()*256);
        int b = (int)(Math.random()*256);
        this.c = new Color(r,g,b);
    }

    @Override
    public void run() {
        while(true) {
            y += 5;
            if(y >= w.Center_p.getHeight()-20) {
                break; // 무한반복문 탈출
            }

            w.Center_p.repaint();

            try {
                Thread.sleep(30);
            } catch (Exception e) {

            }
        }
    }

}
