package pm;

public class Test1Main {

	public static void main(String[] args) {
		// 프로그램 시작
		
		Test1Gen<String> t1 = new Test1Gen<String>();
		t1.setValue("SIST");
		System.out.println(t1.getValue());  			// SIST
		
		Test1Gen<String> t2 = new Test1Gen<String>();
		t2.setValue("SIST");
		System.out.println(t2.getValue());  			// SIST
		
	}

}
