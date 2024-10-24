package homework;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Company comp = new Company();
		comp.init();

		// 키보드와 연결된 스캐너 준비
		Scanner scan = new Scanner(System.in);
		
		System.out.println("선택:");
		System.out.println("사번검색:1, 이름검색:2, 직책검색:3, 부서검색:4");
		int cmd = scan.nextInt();

		/*		
		if (cmd > 4 || cmd < 1) {
			System.out.println("잘못 입력하셨습니다.");
		}
		*/		
		
		String msg = null;
		String str = null;
		
		// 사용자가 입력한 값 (1,2,3,4)에 따라 분기문을 구현하자
		switch(cmd) {
			case 1: // 사번검색
				System.out.println("검색할 사번:");
				str = scan.next();
				msg = comp.searchEmp(cmd, str);
				break;
				
			case 2: // 이름검색
				System.out.println("검색할 이름:");
				str = scan.next();
				msg = comp.searchEmp(cmd, str);
				break;
				
			case 3: // 직책검색
				System.out.println("검색할 직책:");
				str = scan.next();
				msg = comp.searchEmp(cmd, str);
				break;
				
			case 4: // 부서검색
				System.out.println("검색할 부서:");
				str = scan.next();
				msg = comp.searchEmp(cmd, str);
				break;
				
			default:
				msg = "잘못 입력하셨습니다.";
				
		}
		
//		System.out.println("검색할 이름:");
//		String str = scan.next();
//
//		String msg = comp.searchEmp(str);
		System.out.println(msg);

	}

}
