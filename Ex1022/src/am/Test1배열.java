package am;

public class Test1배열 {

	public static void main(String[] args) {
		// 프로그램 시작
		
		// 1차원 배열 생성
		int[] a1 = {1, 2, 3};
		int[] a2 = {4, 5, 6};
		
		// 2차원 배열 생성 (위 2개의 배열을 저장한다.)
		int [][] a3 = new int[2][3];
		a3[0] = a1;
		a3[1] = a2;
		
		// 1차원 배열
		int[] a4 = {7, 8, 9};
		int[] a5 = {9, 9, 9};
		
		// 위 a4, a5를 하나로 묶는 2차원 배열 생성
		int [][] a6 = {a4, a5};
		
		// 위의 a3, a6인 2차원 배열들을 하나로 묶는 3차원 배열
		int[][][] a7 = new int[2][][];
		
		a7[0] = a3;
		a7[1] = a6;
		
		System.out.println(a7[1][0][0]);
		
	}
}
