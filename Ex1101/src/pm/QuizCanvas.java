package pm;

import java.awt.*;

public class QuizCanvas extends Canvas {
    int x, y, wh = 30;

    @Override
    public void paint(Graphics g) {
//        g.setColor(Color.BLUE);
        g.fillRect(x,y,wh,wh);
    }
}
