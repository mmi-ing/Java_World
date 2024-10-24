package am;

public class Test3String {

	public static void main(String[] args) {
		// 프로그램 시작
		
		// 문자열 객체 생성
		String s1 = "sist";
		
		// s1에서 소문자 "s"가 있는지 ? 알아보자 !
		int idx = s1.indexOf("s");
		System.out.println("idx:"+idx);
		
		// s1에서 소문자 "s"를 뒤에서부터 검색해본다.
		idx = s1.lastIndexOf("s");	// 찾지 못하면 -1을 반환한다.
		System.out.println("idx:"+idx);
		
		char ch = s1.charAt(1);	// i
		System.out.println("s1.charAt(1):"+ch);
	}

}
