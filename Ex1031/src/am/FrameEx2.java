package am;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameEx2 extends JFrame implements ActionListener {
    JPanel north_p, ID_p, PW_p, Login_p;
    JLabel lb1, lb2;
    JTextField tf1, tf2;
    JButton bt;
    Login login;
    public FrameEx2(){
        FlowLayout flow = new FlowLayout(FlowLayout.RIGHT);
        north_p = new JPanel();
        ID_p = new JPanel(flow);
        PW_p = new JPanel(flow);
        Login_p = new JPanel(flow);
        bt = new JButton("로그인");

        this.add(north_p);
        this.add(north_p, BorderLayout.NORTH);

        this.add(ID_p);
        this.add(ID_p, BorderLayout.SOUTH);
        this.add(PW_p);
        this.add(PW_p, BorderLayout.SOUTH);
        this.add(Login_p);
        this.add(Login_p, BorderLayout.SOUTH);

        this.setBounds(300, 50, 500,400);
        this.setVisible(true);

        this.addWindowListener(new MyWin());
    }


    public static void main(String[] args){
        new FrameEx2();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
