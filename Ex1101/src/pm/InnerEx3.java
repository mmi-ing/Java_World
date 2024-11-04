package pm;

import java.awt.event.WindowAdapter;

public class InnerEx3 {

    String str = "쌍용교육센터";  // 멤버변수
    class Inner { // 내부 클래스 (멤버)
        int value = 10;
        public void test() {
            System.out.println(str+":"+value);
        }
    }   // 내부클래스의 끝 : 내부클래스의 장점은 바깥쪽 클래스의 멤버를 자신의 것처럼 사용함
    public InnerEx3() {

        WindowAdapter wa = new WindowAdapter() {
            // WindowAdapter의 새로운 영역으로 인식한다.
            // 그렇다면 WindowAdapter의 새로운 영역언 바로 WindowAdqpter를 상속받는 새로운 영역이다.
            // 즉, csll ? extends WindowAdapter
        };

    }
    public static void main(String[] args) {
        // 프로그램 시작
        InnerEx3 ex3 = new InnerEx3();

        // 내부클래스 생성: 내부클래스는 반드시 바깥쪽 클래스를 통해서 생성해야 함
//        InnerEx3.Inner i = new InnerEx3().new Inner();
        InnerEx3.Inner i = ex3.new Inner();
        i.test();
    }
}
