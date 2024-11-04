package am;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyDialog extends JDialog implements ActionListener {
    // 현재 창에 나타내고자 하는 객체들을 멤버로 선언
    JButton red_bt, green_bt, blue_bt;
    FrameEx1 p;
    public MyDialog(FrameEx1 p) {
        // 현재 객체가 생성될 때 전달되어 온 FrameEx1의 주소를 다른 메서드에서도 사용할 수 있도록 멤버 변수 p에 저장한다.
        this.p = p;

        // 현재 창의 레이아웃을 FlowLayout으로 변경하자!
        this.setLayout(new FlowLayout());

        red_bt = new JButton("Red");
        green_bt = new JButton("Green");
        blue_bt = new JButton("Blue");

        this.add(red_bt);
        this.add(green_bt);
        this.add(blue_bt);

        this.setBounds(400, 100,250,180);
        this.setVisible(true);

        red_bt.addActionListener(this);
        green_bt.addActionListener(this);
        blue_bt.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 색상 버튼들을 클릭할 때마다 호출되는 곳!!
        Object obj = e.getSource();
        Color c = null;

        if(obj == red_bt)
            c = Color.RED;
        else if (obj == green_bt) {
            c = Color.green;
        } else if (obj == blue_bt) {
            c = Color.BLUE;
        }
        // FrameEx1의 멤버 중 center_p의 배경색을 c로 지정해야 한다.
        p.center_p.setBackground(c);
    }
}
