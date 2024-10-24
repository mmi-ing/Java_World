package am;

import java.util.Scanner;

public class Test6Switch문 {

	public static void main(String[] args) {
		// 키보드와 연결된 스캐너 객체 생성
		Scanner scan = new Scanner (System.in);
		
		System.out.println("원하는 월을 입력 (1~12)");
		int month = scan.nextInt();
				
		if (month>12 || month < 1 ) {
			System.out.println("잘못 입력하셨습니다.");
			return;
		} // if문의 끝
		
		// 1, 3, 5, 7, 8, 10. 12	31일 까지가 큰달
		// 4, 6, 9, 11 		30일까지인 작은 달, 2월 29일로 정하자!
		
		String msg = "";
		
		switch(month) {
			case 5:
			case 1:
			case 3:
			case 7:
			case 8:
			case 12:
			case 10:
				msg = "큰 달이므로 31일까지입니다.";
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				msg = "작은 달 이므로 30일까지 입니다.";
				break;
			default:
				msg = "29일까지 입니다";
				
		}		//switch 문의 끝
		System.out.println(month + "는 " + msg);
		
		

	}

}
