package pm;

public class MainEx3 {
    public static void main(String[] args) {
        // 프로그램 시작
        ThreadEx3 t1 = new ThreadEx3(); // 스레드 생성
        t1.start();     // 스레드 시작 ---> run 함수 호출

        TreadEx3_1 t2 = new TreadEx3_1();
        t2.start();

        System.out.println("나는 메인이야!"); // 스레드가 먼저 실행되지만 메인이 더 빠를 확률이 높음

    }
}
