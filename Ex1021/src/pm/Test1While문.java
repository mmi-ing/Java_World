package pm;

public class Test1While문 {

	public static void main(String[] args) {
		// 프로그램 시작
		
		int i = 0;
		int sum = 0;
		
		while (i<=10) {
			sum += i;
			System.out.printf("%-2d", i++);
		}

	}

}
