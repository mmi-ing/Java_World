package am;

public class Test1For문 {

	public static void main(String[] args) {
		// 프로그램 시작
		int n = 10;
		for(int i=0; i<n; i++) {
			// 마지막 반복회차가 아닐 때를 비교해서 알아낸다.
			if (i == 9)
				System.out.printf("%d", i+1 );
			else System.out.printf("%d%s ", i+1, ",");
			
			if(i != (n-1))		// 유지 보수를 위해 0가 아닌 10-1로 작성
				System.out.printf("%d %s", i+1, ",");
			else
				System.out.printf("%d", i+1);
		}

	}

}
