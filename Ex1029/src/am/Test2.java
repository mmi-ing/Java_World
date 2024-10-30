package am;

public class Test2 implements InterEx2, InterEx1 {

	@Override
	public void print() {
		System.out.println("Test2 print");
	}

	@Override
	public void test() {
		System.out.println("Test2 test");
	}
	
	public void showData() {
		System.out.println("showData");
	}

}
