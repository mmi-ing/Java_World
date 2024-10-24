package am;

public class Test2StringBuffer {

	public static void main(String[] args) {
		// 프로그램 시작
		
		// 문자열 편집이 가능한 StringBugger객체 생성
		StringBuffer sb1 = new StringBuffer("JAVA");
		StringBuffer sb2 = sb1;		// sb1이랑 sb2은 같은 곳을 가리킴
		
		if (sb1 == sb2)
			System.out.println("sb1과 sb2의 주소가 같다.");
		else
			System.out.println("sb1과 sb2의 주소가 다르다.");
		
		// 수정하기
		sb1.append(" Programming");
		System.out.println(sb2); 	// JAVA Programming
		
		// 0번지부터 3번지 전까지 삭제
		sb2.delete(0, 3);
		System.out.println(sb1); 	// JAVA Programming
		
		// 특정 위치 2번지 위치에 "-"를 추가한다.
		sb1.insert(2,  "-");
		System.out.println(sb2);
		
		// 버퍼가 가지고 있는 문자열을 String으로 변환하여 반환한다.
		String str = sb2.toString();
		System.out.println("str:"+str);

	}

}
