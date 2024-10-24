package am;

public class Test2For문 {

	public static void main(String[] args) {
		// 프로그램 시작
		
		// 문) 1~10까지 반복 수행하는 문장을 완성하시오!
		//	   단, 3의 배수는 출력하지 않아야 한다.
		
		int n = 10;
		for (int i = 0; i < n; i++)
			if ( (i+1)%3 != 0 )		// 3의 배수가 아닐 때
				System.out.printf("%d ", i+1);


	}

}
