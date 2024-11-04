package pm;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InnerFrameEx4 extends JFrame {

    public InnerFrameEx4(){
        this.setBounds(300, 50, 400,450);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            // 여기는 WindowAdapter를 상속받는 익명의 내부클래스

            @Override
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }

        });
    }
    public static void main(String[] args) {
        new InnerFrameEx4();

    }
}
