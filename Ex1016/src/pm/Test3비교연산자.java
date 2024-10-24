package pm;

public class Test3비교연산자 {

	public static void main(String[] args) {
		// 프로그램 시작
		
		// 비교연산자(관계연산자)
		// 프로그래밍에서는 연산자를 중심으로 해서 왼쪽이 기준이다.
		// > : 크다.
		// < : 작다.
		// >= : 크거나 같다.
		// <= : 작거나 같다.
		// == : 같다.
		// != : 같지 않다.
		// 비교연산자의 결과는 무조건 true 아니면 false다.
		// 한 마디로 결과의 자료형이 boolean이어야 한다.
		
		// 정수 10을 저장하는 변수 a를 선언하자
		int a = 10;
		
		// 정수 7을 저장하는 변수 b를 선언하자!
		int b = 7;
		
		// a가 b보다 큰지 비교하여 그 결과를 변수 c에 저장하자
		boolean c = a > b; 
		System.out.println("a > b = "+ c);
		
		// 변수 c에 a와 b가 같은지? 비교하고 그 결과를 저장하시오!
		c = a == b;
		System.out.println("a == b = "+ c);
	}

}
