package am;

import java.util.Scanner;

public class ExceptionEx2 {
    public static void main(String[] args) {
        // 예외란
        // 예상하지 못한 가벼운 오류가 발생한 것을 의미하며,
        // 이는 개발자에 의해 수정이 가능한 가벼운 오류를 뜻한다.

        int res = 100;
        Scanner scan = new Scanner(System.in);
        System.out.println("값 입력");
        int su = scan.nextInt();    // 정수 하나를 입력받는다.
        try {
            //예외가 발생 가능한 영역
            System.out.println("받은 값으로 나누기:" + (res/su));
        } catch (ArithmeticException e){
            // ArithmeticException이 발생했을 때 수행하는 영역
            su = 1;
            System.out.println("받은 값으로 나누기(예외):"+(res/su));
        } catch (Exception e){
            System.out.println("Exception에서의 처리");
        } finally {
            System.out.println("무조건 수행하는 영역!");
        }
        System.out.println("프로그램 끝~~~!");
    }
}
