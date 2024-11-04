package pm;

import am.MyWin;

import javax.swing.*;

public class CanvasEx4 extends JFrame {

    MyCanvas4 can;
    public CanvasEx4(){
        this.add(can = new MyCanvas4());
        this.setBounds(300, 50, 500, 450);
        this.setVisible(true);

        this.addWindowListener(new MyWin());
    }
    public static void main(String[] args) {
        new CanvasEx4();
    }
}
