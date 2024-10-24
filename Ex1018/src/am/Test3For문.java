package am;

public class Test3For문 {

	public static void main(String[] args) {
		// 1~50 까지의 합을 구하시오!
		int n = 50;
		int l = 0;
		for (int i = 0; i < n; i++) {
			l = l + (i+1);
		}
		System.out.printf("%d ", l);

	}

}
