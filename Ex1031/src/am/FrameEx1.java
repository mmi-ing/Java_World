package am;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameEx1 extends JFrame implements ActionListener {

    JPanel north_p, center_p;
    JButton bt;
    MyDialog md;

    public FrameEx1() {
        north_p = new JPanel();
        center_p = new JPanel();
        bt = new JButton("대화상자");

        north_p.add(bt);

        this.add(center_p);
        this.add(north_p, BorderLayout.NORTH);

        this.setBounds(300, 50, 500, 400);
        this.setVisible(true);

        this.addWindowListener(new MyWin());
        bt.addActionListener(this);
    }

    public static void main(String[] args){
        // 프로그램 시작
        new FrameEx1();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 대화상자 객체 생성
        md = new MyDialog(this);
        // MyDialog를 생성할 때 현재객체의 주소(this)를 전달한다.
    }
}
