package am;

import java.util.Scanner;

public class Test2조건연산자 {

	public static void main(String[] args) {
		// 프로그램 시작
		
		// 화면에 "숫자입력: "문자열 출력
		System.out.println("숫자입력: ");
		
		// 사용자로 하여금 숫자를 입력받기 위해 필요한 객체 생성!
		Scanner scan = new Scanner(System.in);
		int su = scan.nextInt();
		
		//int su = 50;
		
		// 조건연산자 (삼항연산자)
		// [구성]
		// (조건식) ? 조건에 참일 경우 수행할 값 : 거짓일 때 수행하는 값 ;
		
		// su의 값이 100보다 크면 나며지 값을 반환하고, 그렇지 않다면 su 값을 그대로 전달하자!
		int result = (su > 100) ? su%100 : su ;
		System.out.println(result);
		
	}

}
