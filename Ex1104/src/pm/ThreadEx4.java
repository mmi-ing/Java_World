package pm;

public class ThreadEx4 extends Thread{
    ThreadFrameEx4 f;   //********중요함********
    public ThreadEx4(ThreadFrameEx4 f) {
        this.f = f;
    }

    @Override
    public void run() {
        // ThreadFrameEx4가 가지고 있는 x값을 증가시킨 후
        // 잠시 쉬었다가 ThreadFrameEx4가 가지는 p를 다시 그려야 한다.
        while(true) {
            //ThreadFrameEx4가 가지고 있는 x값을 증가!
            f.x += 5;

            // f의 x값이 f가 가지는 p의 너비를 넘었으면 탈출!
            if(f.x >= f.p.getWidth()-20)
                break;; //무한반복 탈출

            f.p.repaint();  // 다시 그리기
            try {
                Thread.sleep(50);
            } catch (Exception e){

            }

        }
        // 끝
    }
}
