package am;

public class Test3Main {

	public static void main(String[] args) {
		// 프로그램 시작
		int value = 100;
		
		// Test3CallBy라는 클래스 안에 있는 test메서드를 호출하려 한다.
		// 이때 반드시 해당 클래스를 먼저 생성해야 된다.
		Test3CallBy t1 = new Test3CallBy();
		t1.test(value);
		
		System.out.println(value); 		// 100

	}

}
