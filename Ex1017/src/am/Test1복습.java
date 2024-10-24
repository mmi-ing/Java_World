package am;

public class Test1복습 {
	// 함수 안에 함수 선언 못함 => class 안에만 만들면 됨
	public static char test() {
		System.out.println("여기는 test함수!");
		char ch = 'C'; // 변수가 test함수에서 만들어졌으므로 현재 영역인 test함수를 벗어나면 소멸된다
		System.out.println(ch);
		
		return ch; // 변수 ch가 기억하고 있는 값을 호출한 곳으로 반환한다.
	}

	public static void main(String[] args) {
		// 프로그램 시작
		// 자바의 자료형
		// 어제 배운 것은 : boolean, char, 정수형(byte, short, int, long), 실수형(float, double)
		
		boolean 변수1 = true; // 변수 초기화
		char ch = 'B';
		
		System.out.println(ch); // B
		ch = test(); // test라는 함수 호출
					 // test가 수행이 끝날 때 반환하는 값을 18번 행에서 만든 ch변수에 저장
		
		System.out.println(ch);
		System.out.println("끝~!");
	}
	


}
