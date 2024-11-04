package pm;

import am.MyWin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CanvasEx5 extends JFrame implements ActionListener, ItemListener {

    MyCanvas5 can;
    JPanel west_p, color_p;
    JButton[] bt_ar;
    Color[] colors = {Color.WHITE, Color.BLACK, Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN};
    JComboBox<Integer> combo;
    Integer[] size_ar = {5, 10, 15, 20, 25, 30};

    public CanvasEx5() {
        this.add(can = new MyCanvas5());

        west_p = new JPanel();
        // 왼쪽에 들어가는 패널의 크기를 너비는 70, 높이는 창의 높이를 고정하려 한다면
        // Dimension(70, 0)을 생성ㅇ하여 해당 패널에게 PreferredSize로 지정하면 된다.
        // (Dimension은 너비와 높이를 가지고 객체화 시킨 것이다.)
        west_p.setPreferredSize(new Dimension(70, 0));

        color_p = new JPanel(new GridLayout(3, 2));
        bt_ar = new JButton[6];
        for (int i = 0; i < bt_ar.length; i++) {
            bt_ar[i] = new JButton();
            // 생성된 버튼의 크기를 30*30으로 지정하고자 한다면 앞서 작업한
            // PreferredSize 로 지정을 하면 된다.
            bt_ar[i].setPreferredSize(new Dimension(30,30));
            bt_ar[i].setBackground(colors[i]);
            bt_ar[i].addActionListener(this);
            color_p.add(bt_ar[i]);
        }
        west_p.add(color_p);

        west_p.add(combo = new JComboBox<>(size_ar));
        this.add(west_p, BorderLayout.WEST);

        this.setBounds(300, 50, 500, 450);
        this.setVisible(true);

        this.addWindowListener(new MyWin());
        combo.addItemListener(this);
    }

    public static void main(String[] args) {
        new CanvasEx5();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        Color c = can.existing;
        if(obj instanceof JButton){
            JButton bt = (JButton)obj;
            c = bt.getBackground();

            can.color = c;      // 캔버스의 색상변경
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        int value = (Integer)combo.getSelectedItem();
        can.wh = value;
    }
}
