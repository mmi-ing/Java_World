package pm;

import am.MyWin;

import javax.swing.*;

public class CanvasEx3 extends JFrame {
    MyCanvas can;

    public CanvasEx3(){
        this.add(can = new MyCanvas());

        this.setBounds(300, 50, 500, 500);
        this.setVisible(true);
        this.addWindowListener(new MyWin());
    }
    public static void main(String[] args) {
        new CanvasEx3();

    }
}
