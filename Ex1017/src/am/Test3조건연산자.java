package am;

import java.util.Scanner;

public class Test3조건연산자 {

	public static void main(String[] args) {
		// 프로그램 시작
		
		// 키보드(System.in)로 정수 하나를 입력받기 위해 Scanner객체 생성
		Scanner scan = new Scanner(System.in);
		
		// 화면에 "정수 입력: " 문자열을 출력하자
		System.out.println("정수 입력: ");
		
		// 키보드와 연결된 장치로부터 숫자를 하나 입력 받아 변수 su1에 저장하자!
		int su1 = scan.nextInt();
		
		// 입력된 값이 su1에 저장된 상태다. 이때 su1의 값이 100보다 크면 "잘못된 값"을 출력하고, 그렇지 않다면 "유효한 값"을 출력하자!
		String result = (su1>100) ? "잘못된 값" : "유효한 값" ;
		System.out.println(result);
		
	}

}
