package pm;

public class Test2산술연산자 {

	public static void main(String[] args) {
		// 프로그램 시작
		
		// 정수형 변수 a를 선언하면서 10을 저장하자!
		int a = 10;
		
		// 정수형 변수 b를 선언하면서 5를 저장하자!
		int b = 5;
		
		// 정수형 변수 c를 선언하면서 a에서 b를 뺀 값을 저장!
		int c = a - b;
		System.out.println("a - b = " + c);
		
		// 정수형 변수 c에 a와 b를 곱한 값을 저장하자!
		c = a * b;
		System.out.println("a * b = "+ c);
		
		// 정수형 변수 b에 7을 저장하자!
		b = 7;
		
		// 정수형 변수 a를 b로 나눴을 때 나오는 나머지 값을 변수 c에 저장하자!
		c = a % b;
		System.out.println("a % b = "+ c);
	}

}
