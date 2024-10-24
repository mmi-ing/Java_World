package am;

public class Test4Continue문 {

	public static void main(String[] args) {
		// 1 2 3 4
		// 1 2 3 4
		// 1 2 3 4
		for (int k=0; k<3; k++) {
			for (int i=1; i<5; i++) {
				if((i%3) == 0)
					continue;	// 이후의 내용을 하지 않고 다음 반복 회차로 넘어간다.
				System.out.printf("%2d", i);
			}	// for문의 
			System.out.println();	//줄바꿈	
		}	//바깥쪽 for문의 끝
	}

}
