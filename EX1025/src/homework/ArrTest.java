package homework;

public class ArrTest {

	public static void main(String[] args) {
		int[][] arr = new int[4][4];
		int num = 0;
		
		for (int i=0; i<arr.length; i++) {
			for (int j=0; j<arr[i].length; j++) {
				arr[i][num]=1;
				
				arr[j][j] = 1;
				System.out.printf("%-4d", arr[i][j]);
				}
			System.out.println();
			num++;
			}
		}
}

