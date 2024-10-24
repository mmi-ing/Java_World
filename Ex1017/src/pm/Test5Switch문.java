package pm;

import java.util.Scanner;

public class Test5Switch문 {

	public static void main(String[] args) {
		// 프로그램 시작
		
		// 키보드로부터 1, 2, 3 중 하나를 입력받도록 하자!
		System.out.println("입력(1~3) : ");
		
		Scanner scan = new Scanner(System.in); // 키보드와 연결된 스캐너객체 생성!
		int val = scan.nextInt();
		
		if (val > 3 || val < 1) {
			System.out.println("잘못 입력하셨습니다.");
			return;		// 더 이상 수행하지 못하도록 제어권을 호출한 JVM으로 돌려보낸다.
		}
		
		System.out.println("프로그램 판단시작!");
		
//		if (val == 1)
//			System.out.println("1번");
//		else if (val == 2)
//			System.out.println("2번");
//		else
//			System.out.println("3번");
		
		/*
				[switch문 구성]
				
				switch(조건값) {
						case 비교값;
							 실행문1;
			                 실행문2;
			                 break;  // 현재  switch 문을 탈출한다.
			 				case 비교값;
							 실행문3;
							 ....
							 break;
				} // switch 문의 끝
		*/
		
		switch(val) {
			case 1 : 
				System.out.println("1번");
//				break;
//			case 3 : 
//				System.out.println("3번");
//				break;
//			case 2 : 
//				System.out.println("2번");
//				break;
		} // switch 문의 끝2
		
	}

}
