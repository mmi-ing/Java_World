package am;

import java.util.Scanner;

public class T_Main {

	public static void main(String[] args) {
		// 프로그램 시작
		
		// 자판기 (Vending)객체 생성
		T_Vending v =new T_Vending();
		v.init(); 	// 각 음료들이 배열에 저장된다.
		
		Scanner scan = new Scanner(System.in);
		System.out.println("insert Coin: ");
		int m = scan.nextInt();
		
		// 자판기에 금액을 넣어서 선택할 수 있는 음료의 이름들을 받아야 한다.
		String msg = v.insertCoin(m);
		System.out.println(msg);
		
		System.out.println("선택:");
		int cmd = scan.nextInt();		// 음료 번호
		msg = v.change(cmd, m);
		System.out.println(msg);
		
	}
	
}
