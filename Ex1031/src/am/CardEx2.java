package am;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardEx2 extends JFrame implements ActionListener {
    // 카드레이아웃은 한 화면을 하나의 카드로 인지하고,
    // 그 카드는 JPanel 로 만든다.
    JPanel p1, p2;
    JButton p1_bt, p2_bt;
    CardLayout cl;

    public CardEx2() {
        p1 = new JPanel();  // 첫 번째 화면
        p1_bt = new JButton("다음");
        p1.add(p1_bt);
        p1.setBackground(Color.CYAN);

        p2 = new JPanel();
        p2_bt = new JButton("이전");
        p2.add(p2_bt);
        p2.setBackground(Color.ORANGE);

        // 현재 창의 레이아웃을 CardLayout 로 지정하자!
        cl = new CardLayout();
        this.setLayout(cl);

        // 화면들을 현재 창의 container 에 추가한다.
        this.getContentPane().add(p1, "card1");
        this.getContentPane().add(p2,"card2");

        // 카드 변경하는 문장
        //cl.show(this.getContentPane(), "card2");

        this.setBounds(300,50,500,500);
        this.setVisible(true);
        this.addWindowListener(new MyWin());

        p1_bt.addActionListener(this);
        p2_bt.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        String cardName = null;
        if(obj == p1_bt)
            cardName = "card2";
        else if (obj == p2_bt)
            cardName = "card1";

        cl.show(this.getContentPane(), cardName);

    }

    public static void main(String[] args) {
        new CardEx2();
    }
}
