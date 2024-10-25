package pm;

public class Test2Main {

	public static void main(String[] args) {
		// 프로그램 시작
		
		Test2생성자 t1 = new Test2생성자();
		t1.setName("마루치");
		t1.setAge(22);
		
		Test2생성자 t2 = new Test2생성자();		// 인자가 없는 생성자를 우린 "기본생성자"라 한
		t2.setName("아라");
		t2.setAge(23);
		
		// 생성자는 객체가 생성도리 때 딱 한 번 호출하여 
		// 멤버변수들에 대한 초기화를 하면서 객체를 생성한다.
		// 만약에 생성자를 정의하면 컴파일러에 의해서 자동으로
		// 만들어줬던 기본생성자는 더 이상 컴파일러가 만들어 주지 않는다. 
		
		// 우리가 만든 생성자를 활용하여 객체를 생성해 보자!
		Test2생성자 t3 = new Test2생성자("파란해골", 19);
	}

}
