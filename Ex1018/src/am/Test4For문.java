package am;

public class Test4For문 {

	public static void main(String[] args) {
		// 2~9까지의 수들 중 난수를 하나 발생시켜 그 난수에 맞는 구구단을 다음과 같이 출력해보자!
		/*
		 		3단
		 		--------
		 		
		*/
					// Math.random() * 범위 + 시작수
		int num = (int)(Math.random()*8 + 2); 
		System.out.printf("%d단 \r\n", num);
		System.out.println("------------");

		for(int i = 1; i < 10; i++) {
			int mul = num*i;
			System.out.printf("%d * %d = %d \r\n", num, i, mul);
		}
	}

}
