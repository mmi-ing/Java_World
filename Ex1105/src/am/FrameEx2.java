package am;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class FrameEx2 extends JFrame {
    JPanel p;
    // 사용자가 클릭할 때마다 타원객체 (OvalEx2)가 생성되어 저장되는 곳
    ArrayList<OvalEx2> list = new ArrayList<>();

    public FrameEx2(){
        this.add(p = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                // 현재 JPanel과 크기가 같은 Imgae를 생성
                Image buf = createImage(this.getWidth(), this.getHeight());

                // Image에 그림을 그릴 수 있는 Graphics를 얻어낸다.
                Graphics buf_g = buf.getGraphics();

                // 사용자가 클릭할 때마다 타원객체가 생성되어 저장되는 list를
                // 반복하여 하나씩 얻어내어 그림을 그린다.
                for(int i = 0; i < list.size(); i++){
                    OvalEx2 oval = list.get(i);

                    buf_g.setColor(oval.c); // 색상 지정
                    buf_g.fillOval(oval.x, oval.y, oval.wh, oval.wh);
                }
                g.drawImage(buf, 0, 0, this);
            }
        });

        this.setBounds(300, 50, 500,600);
        this.setVisible(true);

        //이벤트 감지자 등록
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //p에서 클릭할 때를 감지하는 감지자 등록!
        p.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                // p에서 마우스 버튼을 누를 때마다 수행하는 곳!
                int x = e.getX();
                int y = e.getY();

//                OvalEx2 ov = new OvalEx2(FrameEx2.this, x, y); //타원객체(OvalEx2) 생성하자!
                OvalEx2 ov = new OvalEx2(FrameEx2.this, x, y);

                list.add(ov);   //ArrayList에 추가
                //OvalEx2가 스레드를 상속 받았기 때문에 스레드다.
                //이쯤에서 스레드 구동!
                ov.start(); //  --> OvalEx2의 run()메서드를 수행한다.
            }
        });
    }
    public static void main(String[] args) {
        new FrameEx2();
    }
}
