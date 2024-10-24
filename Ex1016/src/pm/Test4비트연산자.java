package pm;

public class Test4비트연산자 {

	public static void main(String[] args) {
		// 프로그램 시작
		
		// 비트연산자 ( & : 그리고, | : 또는 )
		// 피연산자들을 비트단위로 변경하여 연산 후 새로운 값을 얻어낼 때 사용됨!
		int a = 10; // 1 0 1 0			1 0 1 0
		int b = 7;  // 0 1 1 1			0 1 1 1
				//	& ----------	 | ----------
				//	   0 0 1 0			1 1 1 1 
		
		int c = a & b;
		System.out.println("a & b = " + c);
		
		c = a | b;
		System.out.println("a | b = " + c);

	}

}
