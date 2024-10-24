package pm;

public class Test3배열 {

	public static void main(String[] args) {
		// 프로그램 시작
		int[] ar1 = new int[3];
		ar1[0] = 10;
		ar1[1] = 20;
		ar1[2] = 30;

		int[] ar2 = new int[3];
		ar2[0] = 200;
		ar2[1] = 300;
		ar2[2] = 400;
		
		// 2차원 배열을 생성하자!
		int[][] ar3 = new int[2][];
		ar3[0] = ar1;	//2차원 배열 첫번째 요소에 1차원 배열 ar1이 기억하는 주소를 저장한다.
		ar3[1] = ar2;	
		
		// 첫 번째 저장된 1차원 배열의 1번째 칸에 있는 값은?
		System.out.println(ar3[0][1]);
		
		// 2차원 배열의 길이
		System.out.println(ar3.length);
		
		// 각 1차원 배열의 길이
		System.out.println(ar3[0].length);
		
		// 2차원 배열을 반복문으로 출력하자
		for(int k=0; k<ar3.length; k++) {
			// 2차원 배열에 저장된 각 1차원 배열을 반복문으로 출력!
			for(int i=0; i<ar3[k].length; i++) {
				System.out.printf("%-4d", ar3[k][i]);
				
			}
			System.out.println();	//줄바꿈
		}	//바깥쪽 for의 끝

	}

}
