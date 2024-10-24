package pm;

public class Test6증감연산자 {

	public static void main(String[] args) {
		// 프로그램 시작
		
		int a = 10;
		
		System.out.println("a++ = "+ a++); // 10
		System.out.println("a = " + a); // 11
		
		// 현재 변수 a의 값은 10이다.
		int b = 10;
		
		System.out.println(a++ > ++b); // 11 > 10		false
		
		System.out.println(a); // 12
		System.out.println(b); // 11
		
		
	}

}
