package am;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class DownWordFrameEx3 extends JFrame {
    JPanel North_p, Center_p;
    JButton b;
    ArrayList<WordEx3> list = new ArrayList<>();
    String[] words = {"Hello", "Hi", "Java", "Paint", "Ham"};

    public DownWordFrameEx3() {
        this.setLayout(new BorderLayout());

        FlowLayout flow = new FlowLayout(FlowLayout.RIGHT);
        North_p = new JPanel(flow);
        b = new JButton("시작");
        North_p.add(b);
        this.add(North_p, BorderLayout.NORTH);

        this.add(Center_p = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                for(WordEx3 word : list) {
                    g.setColor(word.c);
                    g.drawString(word.word, word.x, word.y);

                }
            }
        });

        this.setBounds(300, 50, 600, 500);
        this.setVisible(true);

        // 이벤트 감지자 등록
        this.addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0); // 프로그램 종료
            }
        });

        // 시작 버튼을 눌렀을 때 스레드 구동 후 단어 떨어지기
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.clear();
                for(String word : words) {
                    WordEx3 Obj = new WordEx3(DownWordFrameEx3.this, (int)(Math.random()*Center_p.getWidth()),0,word);
                    list.add(Obj);
                    Obj.start();
                }
            }
        });
    }

    public static void main(String[] args) {
        new DownWordFrameEx3();
    }
}
