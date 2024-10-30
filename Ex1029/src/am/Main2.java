package am;

public class Main2 {

	public static void main(String[] args) {
		// 프로그램 시작
		
		ChildEx2 t1 = new ChildEx2();
		
		Test2 t2 = new Test2();
		ex(t1);
		ex(t2);

	}
	
	public static void ex(InterEx2 n) {
		n.print();
		if(n instanceof Test2) {
			// n이 가리키는 인스턴스 안에 Test2가 있는 경우
			// 강제 형변환한다.
			Test2 tt = (Test2)n;
			tt.showData();
		}
	}
}
