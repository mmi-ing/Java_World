package am;

public class Test1Break문 {

	public static void main(String[] args) {
		// 프로그램 시작
		for (int k=0; k<3; k++) {
			for (int i=0; i<4; i++) {
				System.out.printf("%2d", (i+1));
				// 3의 배수일 때 반복문 탈출
				if((i+1)%3 == 0)
					break;	// 가장 가까운 반복문 탈출
			}
			System.out.println();	// 줄바꿈
		}

	}

}
