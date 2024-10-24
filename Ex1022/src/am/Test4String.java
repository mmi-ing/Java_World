package am;

import java.util.Scanner;

public class Test4String {

	public static void main(String[] args) {
		// 프로그램 시작
		
		// 키보드와 연결된 스캐너 생성
		Scanner scan = new Scanner(System.in);
		System.out.println("문자열 입력:");
		
		String msg = scan.nextLine();	//사용자가 입력하고 엔터키를 칠 때까지 기다린다.
		
		// 사용자가 입력한 값이 String msg에 저장되었다.
		int len = msg.length();	// 입력한 문자열의 길이를 얻어낸다.
		
		System.out.println("총 문자열 길이는:"+len);

		int count = 0;
		for(int i=0; i<len; i++) {
			char ch = msg.charAt(i);
			if(ch>='0' && ch<='9')	// 숫자일 경우 count증가
				count++;		
		}
		System.out.println("숫자는 "+count+"개 있어요!");	
	}

}
