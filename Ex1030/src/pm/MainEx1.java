package pm;

public class MainEx1 {

	public static void main(String[] args) {
		// 프로그램 시작
		// AbsEx1 ex1 = new abex1();		// 추상 클래스는 직접 인스턴스를  생성할 수 없다.
												
		AbsEx1Child ex1 = new AbsEx1Child();
		ex1.test();
	}

}
