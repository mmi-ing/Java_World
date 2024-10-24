package am;

import java.util.Scanner;

public class Test5String {

	public static void main(String[] args) {
		// 프로그램 시작
		
		Scanner scan = new Scanner(System.in);
		System.out.println("첫 번째 문자열:");
		
		String msg1 = scan.nextLine(); 		// 한 줄 입력받기
		
		System.out.println("두 번째 문자열:");
		String msg2 = scan.nextLine();
		
		// 두 개의 문자열(msg1, msg2)의 내용이 같은지 비교해 보자!
		if(msg1.equals(msg2))
			System.out.println("서로 같다.");
		else
			System.out.println("서로 다르다.");
	}

}
