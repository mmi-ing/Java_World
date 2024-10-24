package pm;

import java.util.Scanner;

public class BookMain {

	public static void main(String[] args) {
		// 프로그램 시작
		
		// 도서관 객체 생성
		BookLibrary bl = new BookLibrary();
		bl.init(); 		// 도서관 초기화 끝!
		
		// 키보드로부터 검색할 도서명을 받기 위해 준비하자!
		Scanner scan = new Scanner(System.in);
		System.out.println("검색할 도서명:");
		String str = scan.nextLine(); 		// 한 줄 받기
		
		// 키보드로부터 입력받은 값(str)을 BookLibrary 안에 있는
		// searchBook이라는 함수를 호출할 때 인자로 전달하자!
		String msg = bl.searchBook(str);
		System.out.println(msg);

	}

}
