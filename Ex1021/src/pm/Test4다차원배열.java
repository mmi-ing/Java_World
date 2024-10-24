package pm;

public class Test4다차원배열 {

	public static void main(String[] args) {
		// 프로그램 시작
		int [] ar1 = {1, 2, 3};
		int [] ar2 = {10, 20, 30, 40};
		int [] ar3 = {55, 77};
		
		// 위의 1차원 배열들을 하나로 묶기 위해 2차원 배열을 준비하자!
		int[][] ar = new int[3][];
		
		ar[0] = ar1;
		ar[1] = ar2;
		ar[2] = ar3;
		
		// 반복문으로 모두 출력해 보자!
		for (int i=0; i<ar.length; i++) {
			for (int j=0; j<ar[i].length; j++) {
				System.out.printf("%-4d", ar[i][j]);
			}	// 하나의 1차원 배열 반복문이 끝나는 순간!
			System.out.println();	//줄바꿈
		}

	}

}
