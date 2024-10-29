package am;

public class Test4Main {
	
	public static void test(int n) {
		n++;
		System.out.println(n); 		// 101
	}
	
	public static void main(String[] args) {
		
		int value = 100;
		
		Test4Main.test(value);		// value가 기본자료형이므로 가지고 있던
													// 100을 복사해서 test함수에게 전달한다.
		
		System.out.println(value); 		// 전달한 값이 지역변수 n에 복사되어 사용되다가
															// test함수가 끝나고 다시 main으로 돌아올 때
															// 지역변수인 n은 삭제된다.

	}

}
