package pm;

public class TreadEx3_1 extends Thread{
    @Override
    public void run() {
        for(int i = 0; i < 7; i++){
            System.out.printf("%-2s", "*");

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
