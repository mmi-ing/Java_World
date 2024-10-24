package pm;

public class Test1문자연습 {

	public static void main(String[] args) {
		// 프로그램 시작!
		
		//대문자 A를 저장하는 문자형 변수 a를 정의하자!
		char a = 'A';
		
		// a의 값을 1증가시켜 변수 b에 저장한다.
		int b = a + 1; // 65 + 1 여기는 나온 결과값 66이 변수 b에 저장
		System.out.println(b);
		
		char c = (char) b;
		System.out.println(c);
	}

}
