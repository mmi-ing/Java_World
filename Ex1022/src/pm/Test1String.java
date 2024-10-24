package pm;

public class Test1String {

	public static void main(String[] args) {
		// 프로그램 시작
		String s1 = "SIST";		// 암시적 객체생성
		
		String s2 = new String("SIST");		// 명시적 객체생성

		String s3 = "SIST";		
		String s4 = "SIST";
		
		if (s1 == s3)
			System.out.println("s1과 s3의 주소는 서로 같다.");
		else
			System.out.println("s1과 s3의 주소는 서로 다르다.");

		if (s1.equals(s3))
			System.out.println("s1과 s3의 내용이 서로 같다.");
		else
			System.out.println("s1과 s3의 내용이 서로 다르다.");
		
		s4.concat("123");		// s4가 가리키는 객체의 내용 뒤에 문자열 "123"을 이어 붙혔다.
								// 그런데 이 결과를 새로운 문자열로 생성해서 반환한다.
		System.out.println(s3); 	//SIST
		
		s3 = s3.concat("123");
		System.out.println(s3); 	//SIST123
		
		if (s1 == s3)
			System.out.println("s1과 s3의 주소는 서로 같다.");
		else
			System.out.println("s1과 s3의 주소는 서로 다르다.");
		if (s1.equals(s3))
			System.out.println("s1과 s3의 내용이 서로 같다.");
		else
			System.out.println("s1과 s3의 내용이 서로 다르다.");
		
		
		
	}

}
