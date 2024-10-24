package am;

public class Test3Wrapper {

	public static void main(String[] args) {
		// 문자형 변수를 선언하자
		/* 이게 지금 기본 자료형을 선언한 뒤 객체화를 시키는 것을 보여주는 것
		 * 자료구조 등 기본 자료형을 선언했을 때 실행되는 경우는 자동으로 객체화가 되었기 때문*/
		char ch = 'K';
		Character c1 = new Character(ch); 		// 예전 방식
		Character c2 = ch; 						// 요즘 방식 - Auto Boxing
		Character c3 = ch;						// 대입되는 변수가 같으면 암시적으로 이해하자!
		
		if (c3 == c2)
			System.out.println("c3와 c2의 주소가 같다.");
		else
			System.out.println("c3와 c2의 주소가 다르다.");
		
		int i = 100;
//		Integer i1 = new Integer(i);	// 예전 방식
		Integer i2 = i;					// 요즘 방식
		
		double d = 0.12;
		Double d1 = d;		// 객체화 시켰다.
		
		// 반대로 객체화 된 것을 기본 자료형으로 변환이 가능함!
		double dd = d1;
		System.out.println(dd);
		
		
	}

}
