package pm;

import java.util.Scanner;

public class CompanyMain {

	public static void main(String[] args) {
		// 프로그램 시작
		
		Company com = new Company();
		com.init();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("검색할 사원 이름: ");
		String str = scan.nextLine();
		
		String msg = com.searchEmp(str);
		System.out.println(msg);
	}

}
