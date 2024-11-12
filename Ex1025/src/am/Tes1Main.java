package am;

public class Tes1Main {

	public static void main(String[] args) {
		// 프로그램 시작 
		// 원하는 클래스 (Test1Gen)을 생성하자 
		// 먼저 문자열을 지정하여 생성하도록 하자
		Test1Gen<String> t1 = new Test1Gen<String>();
		t1.setValue("SIST");
		System.out.println(t1.getValue());
		
		// 때에 따라 같은 클래스를 가지고 생성할 때
		// 다른 자료형을 저장할 때도 다소 있다.
		Test1Gen<Long> t2 = new Test1Gen<>();
		t2.setValue(2100000000L);
		System.out.println(t2.getValue());
		
		Test1Gen<Long> t3 = new Test1Gen<>();
		t3.setValue((long) 3.14F);
		System.out.println(t3.getValue());
	}

}
