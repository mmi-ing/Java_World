package pm;

public class Test2배열 {

	public static void main(String[] args) {
		// 프로그램 시작
		
		// 정수형 값을 10개 저장하는 배열을 생성하자!
		int[] ar = new int[10];
		int num = 1;
		
		for(int i = 0; i < ar.length; i++) {
			if (i%2 != 0) {
//				ar[i] = num;
//				num = num + 2;
				ar[i] = i;
			}
			System.out.printf("%d ", ar[i]);
		}
	}

}
