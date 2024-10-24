package am;

public class Test1StringBuffer {

	public static void main(String[] args) {
		// 프로그램 시작
		
		String s1 = new String("Test");
		
		StringBuffer sb = new StringBuffer(s1);
		
		// 문자열(s1)을 가지고 문자열을 수정하자!
		String s2 = s1.concat("123");
		System.out.println("s1: "+s1);		//Test
		System.out.println("s2: "+s2);		//Test123
		
		// 같은 작업을 sb에 해보자!
		StringBuffer sb2 = sb.append("123");
		System.out.println("sb: "+sb);
		System.out.println("sb2: "+sb2);
		
		if (sb == sb2)
			System.out.println("sb와 sb2의 주소가 같다.");		
		else
			System.out.println("sb와 sb2의 주소가 다르다.");
		
		
	}

}
