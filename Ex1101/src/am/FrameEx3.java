package am;

import javax.swing.*;

public class FrameEx3 extends JFrame {
    CanvasEx3 can;
    public FrameEx3() {
        this.add(can = new CanvasEx3());

        this.setBounds(300, 50, 600, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new FrameEx3();
    }
}
