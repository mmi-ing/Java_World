package pm;

import am.MyWin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardEx1 extends JFrame implements ActionListener {

    JPanel card1, card2;

    //------------card1들어갈 객체들----------------
    JPanel p1, p1_1, p1_2, p1_3;
    JTextField id_tf;
    JPasswordField pw_tf;
    JButton login_bt;

    //------------card2들어갈 객체들-----------------
    JPanel p2, p3;
    JTextArea ta;
    JTextField input_tf;
    JButton pre_bt, send_bt;

    CardLayout cl;
    ImageIcon chat_icon;

    public CardEx1(){
        // 현재 창의 레이아웃을 CardLayout으로 지정!
        this.setLayout(cl = new CardLayout());

        // 첫 번째 카드 화면 구성
        card1 = new JPanel(new BorderLayout());
        p1 = new JPanel(new GridLayout(3,1));    // 3행 1열짜리 GridLayout으로 패널 생성
        p1_1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        p1_1.add(new JLabel("ID:  "));
        p1_1.add(id_tf = new JTextField(7));        // id 입력란
        p1.add(p1_1);

        p1_2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        p1_2.add(new JLabel("PW:  "));
        p1_2.add(pw_tf = new JPasswordField(7));        // pw 입력란
        p1.add(p1_2);

        p1_3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        p1_3.add(login_bt = new JButton("  로그인  "));
        p1.add(p1_3);

        card1.add(p1, BorderLayout.SOUTH);

        Image img = new ImageIcon("src/images/chat.png").getImage().getScaledInstance(300,300,Image.SCALE_SMOOTH);
        chat_icon = new ImageIcon(img);
        card1.add(new JLabel(chat_icon));       // 첫 번째 화면 가운데에 이미지 추가

        this.getContentPane().add(card1, "card1");

        // 두 번째 카드 화면 구성
        card2 = new JPanel(new BorderLayout());
        p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p2.add(pre_bt = new JButton("나가기"));
        card2.add(p2, BorderLayout.NORTH);
        card2.add(new JScrollPane(ta = new JTextArea()));
        p3 = new JPanel(new BorderLayout());
        p3.add(input_tf = new JTextField());    // p3의 가운데에 입력란 추가
        p3.add(send_bt = new JButton("보내기"), BorderLayout.EAST);    // p3의 오른쪽에 버튼 추가
        card2.add(p3, BorderLayout.SOUTH);
        this.getContentPane().add(card2, "card2");

        login_bt.addActionListener(this);
        pre_bt.addActionListener(this);

        this.setBounds(300, 50, 300, 500);
        this.setVisible(true);

        this.addWindowListener(new MyWin());
    }


    public static void main(String[] args){
        // 프로그램 시작
        new CardEx1();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        String cardName = null;

        if(obj == login_bt) {
            // 사용자가 입력한 id와 pw를 가져온다.
            String m_id = id_tf.getText().trim();
            String m_pw = String.valueOf(pw_tf.getPassword());
            if (m_id.length() > 0 && m_pw.length() > 0)
                cardName = "card2";
        }
        else if (obj == pre_bt)
            cardName = "card1";

        cl.show(this.getContentPane(), cardName);

    }
}
