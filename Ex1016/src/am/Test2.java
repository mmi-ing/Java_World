package am;

public class Test2 {

	public static void main(String[] args) {
		// 프로그램의 시작
		
		// 변수 선언하기
		// 자료형- boolean, char, 정수형, 실수형
		//						  byte	  float
		//						  short   double
		//						  int
		//						  long
		boolean bl = true;
		// 자료형 변수명 = 값; 변수명은 반드시 소문자로 시작해야 함!
		
		char c2 = 'A'; // 문자이지만 내부적으로 유니코드 값으로 기억함
		// 대문자 A의 유니코드 값은 65다. 소문자 a는 97.
		
		// 정수 100을 저장하는 변수 a1을 선언하시오!
		byte a1 = 127; // byte는 127까지
		short a2 = 128;
		int a3 = 100;
		long a4 = 100;
		
		// 실수형 3.14를 저장하는 f1이라는 변수를 선언해보자!
		float f1 = 3.14f; // 실수는 기본적으로 double로 인식한다.
		// float형으로 인식시키기 위해 값 뒤에 반드시 f를 붙여야 한다.
		
		double f2 = 3.14;
		
		// 어떤 변수든 2개를 골라 더한 값을 화면에 출력하시오!
		long res = a3 + a4;
		System.out.println(res);
		
		// 자바에서는 32비트 미만의 자료형들끼리 연산을 수행하면 
		// 연산의 결과의 자료형은 무조건 32비트(int)로 승격된다.
		int res2 = a1 + a2;
		
	
	}

}
