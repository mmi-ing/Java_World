package pm;

public class Main2 {

	public static void main(String[] args) {
		// 프로그램 시작
		
		// 무조건 새로운 인스턴스가 생김
		// 오브젝트 -> CarEx2 -> HDCarEx2
		HDCarEx2 car1 = new HDCarEx2();		
		// 오브젝트 -> CarEx2 -> KiaCarEx2
		KiaCarEx2 car2 = new KiaCarEx2();
		
		// test함수 호출
		test(car1, "현대");
		test(car2, "기아");

	}
	
	public static void test(CarEx2 n, String m) {
		n.setModel(m);
		n.print();
	}

}
