package am;

import java.awt.*;

public class CanvasEx3 extends Canvas {
    Toolkit tk;     //이미지를 생성할 때 필요함!

    public CanvasEx3() {
        tk = Toolkit.getDefaultToolkit();

    }
    @Override
    public void paint(Graphics g) {
        //Toolkit을 이용하여 이미지 생성
        Image img = tk.getImage("src/images/1.gif");

        g.drawImage(img, 100, 50, 120, 120, this);  // this는 이미지 옵저버를 뜻한다

    }
}
