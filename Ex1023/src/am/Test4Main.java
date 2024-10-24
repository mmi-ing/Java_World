package am;

public class Test4Main {

	public static void main(String[] args) {
		// 프로그램 시작
		
		// 여기서 Test4Pen이라는 클래스에 있는 getColor라는 메서드를 호출하고자 한다면
		// 해당 클래스를 생성한 후 호출해야 한다.
		Test4Pen a = new Test4Pen();
		String c = a.getColor();
		System.out.println(c);		// 검정
		
		// 색상을 "빨강"으로 변경하자!
		a.setColor("빨강");
		c = a.getColor(); 		// 색상을 다시 가져온다.
		System.out.println(c);		// 빨강
		
		Test4Pen b = new Test4Pen();
		String c2 = b.getColor();
		System.out.println(c2); 	// 검정

		b.setColor("파랑");
		c2 = b.getColor();
		System.out.println(c2); 	// 파랑
		
		c2 = a.getColor();
		System.out.println(c2); 	// 빨강
		
	}

}
