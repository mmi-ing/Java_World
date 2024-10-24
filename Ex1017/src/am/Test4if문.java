package am;
import java.util.Scanner;

public class Test4if문 {

	public static void main(String[] args) {
		// 프로그램 시작
		
		// 제어문 종류
		/*
		 	분기문(비교문)
		 		1) if문 : 단순if문, if~else문, 다중if문
				2) switch문
				
			반복문
				1) for문
				2) while문
				3) do~while문
		 */
		Scanner scan = new Scanner(System.in);
		System.out.println("숫자입력: ");
		
		int su1 = scan.nextInt(); //키보드로 숫자 입력
		
		// [조건] su1의 값이 10이상이면 화면에 "10이상" 이라고 출력!
		
		if (su1 >= 10) {
			System.out.println("10이상");
			int su2 = su1+10;
			System.out.println("입니다" + su2);
		}
		
		System.out.println("끝~!");
	}

}
