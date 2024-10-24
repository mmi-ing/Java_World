package pm;

public class BookLibrary {
	// 도서관을 의미하는 클래스
	// 현 도서관은 5개의 도서를 가진다
	BookVO[] ar = new BookVO[5];
	// 도서객체(BookVO)를 5개 저장할 수 있는 공간을 마련했으며
	// 절대로 BookVO가 5개 만들어진 것은 아니다.
	
	// 책을 생성하여 배열에 저장하는 동작
	public void init() {
		BookVO b1 = new BookVO();
		b1.setName("이것이 자바다");
		b1.setPress("한빛미디어");
		b1.setPos("A-102");
		b1.setRent(false);
		
		BookVO b2 = new BookVO();
		b2.setName("UML기초");
		b2.setPress("한빛미디어");
		b2.setPos("B-100");
		b2.setRent(false);
		
		BookVO b3 = new BookVO();
		b3.setName("자바 바이블");
		b3.setPress("한빛아카데미");
		b3.setPos("A-2");
		b3.setRent(true);
		
		BookVO b4 = new BookVO();
		b4.setName("이것이 우분투 리눅수다");
		b4.setPress("한빛미디어");
		b4.setPos("C-222");
		b4.setRent(true);
		
		BookVO b5 = new BookVO();
		b5.setName("스프링부트");
		b5.setPress("두빛미디어");
		b5.setPos("D-122");
		b5.setRent(false);
		
		// 생성된 도서객체들을 이대로 두면 현재 함수를 벗어남과 동시에 모두 소멸된다.
		// 소멸되지 않도록 멤버변수(속성)인 배열에 저장하자!
		ar[0]=b1;
		ar[1]=b2;
		ar[2]=b3;
		ar[3]=b4;
		ar[4]=b5;
	}
	
	// 인자로 단어를 받아 검색하는 동작(반환값은 개발자가 정한다.)
	public String searchBook(String n) {
		// 이것은 자바다 | 한빛미디어 | A-102 | 대여가능
		// BookVO에 있는 값들을 얻어내어 위와 같이 만들기 위해서는 StringBuffer가 필요하다.
		StringBuffer sb = new StringBuffer();
		
		// 인자인 n이 포함된 도서들을 검색하기 위한 반복문
		for (int i = 0; i<ar.length; i++) {
			// 배열에 있는 도서 객체들 중 하나를 가져온다.
			BookVO b = ar[i];
			
			// 도서명에 n의 값이 있는지? 판단하자!
//			int idx = b.name.indexOf(n);		// idx가 -1이 아니면 검색된 경우
//			if (idx != -1) {
			if(b.name.contains(n)) {
				// 도서명에 n이 기억하고 있는 단어를 포함한다면 true발생!
				// StringBuffer에 적재한다.
				sb.append(b.name);
				sb.append(" | ");
				sb.append(b.press);
				sb.append(" | ");
				sb.append(b.pos);
				sb.append(" | ");
				if (b.rent)
					sb.append("대여중");
				else sb.append("대여가능");
				sb.append("\r\n");
			}
			
		}	// for의 끝
		
		return sb.toString();		// 호출한 곳으로 sb가 기억하고 있는 버퍼의 내용을
									// 하나의 문자열로 변환하여 반환한다.
	}	//함수의 끝

}