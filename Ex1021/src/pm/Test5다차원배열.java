package pm;

public class Test5다차원배열 {

	public static void main(String[] args) {
		// 길이가 4개짜리인 1차원 배열을 4개 저장하는 2차원 배열을 생성하자!
		
		int[][] ar = new int[4][4];
		int num = 0;
		
		for (int i=0; i<ar.length; i++) {
			// 2차원 배열 안에 있는 각 1차원 배열을 반복하는 반복문
			for (int j=0; j<ar[i].length; j++) {
				ar[i][num]=1;
				
				//i와 j가 같을 때만 1로 초기화 하자!
				//if(i == j)
				//	ar[i][j] = 1;
				//또는
				//ar[j][j] = 1;
				System.out.printf("%-4d", ar[i][j]);
			}
			System.out.println();
			num++;
		}

	}

}
