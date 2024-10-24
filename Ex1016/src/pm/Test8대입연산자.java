package pm;

public class Test8대입연산자 {

	public static void main(String[] args) {
		// 프로젝트 시작
		// 대입연산자
		//		= : 우측의 값을 좌측변수에 저장
		//	   += : 우측의 값을 좌측변수에 더하면서 저장
		//	   -= : 우측의 값을 좌측변수에 빼면서 저장
		//	   *= : 우측의 값을 좌측변수에 곱하면서 저장
		//	   /= : 우측의 값을 좌측변수에 나누면서 저장
		//	   %= : 우측의 값을 좌측변수에 나머지 값을 저장
		
		int a = 10;
		int b = 7;
		System.out.println("a = "+ a); // 10
		System.out.println("b = "+ b); // 7
		
		a += b; // a = a + b;
		
		System.out.println("a + b = " + a);
		
		// 여기서는 a의 값이 17이된 상태다.
		
		a %= b; // a = a % b; 이는 17을 가진 a를 7로 나눴을 때 나머지 값이 3이 값을 다시 a에 저장 a = 17 % 7;
		System.out.println("a % b = " + a);
		
		

	}

}
