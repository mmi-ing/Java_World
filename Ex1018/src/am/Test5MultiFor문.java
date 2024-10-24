package am;

public class Test5MultiFor문 {

	public static void main(String[] args) {
		/*
				[결과]
			   * * * *
			   * * * *
			   * * * *
			   * * * *
		 */
/*		for ( int i = 0; i < 3; i++ ) {
			for ( int j = 0; j < 4; j++) {
				System.out.printf("* ");
			}	//안쪽for의 끝
			System.out.println();	//줄바꿈
		}	//바깥쪽for의 끝
*/		
		/*
			[결과]
		   1 2 3 4 5
		   1 2 3 4 5
		   1 2 3 4 5

	   */
		
		for ( int i = 0; i < 3; i++ ) {
			for ( int j = 1; j < 6; j++) {
				System.out.printf("%d ", j);
			}
			System.out.println();
		}
		
		
		int num = 1;
		
//		for ( int j = num; j < 16; j++) {
//			System.out.printf("%d ", j);
//			num = j;				
//			if ( j % 5 == 0 ) System.out.println();
//		}

		for ( int i = 0; i < 3; i++ ) {
			for ( int j = 1; j < 6; j++) {
				System.out.printf("%-3d ", num++);
//				num++;
			}
			System.out.println();
		}
		
		for ( int i = 0; i < 3; i++ ) {
			for ( int j = 1; j < 6; j++) {
				System.out.printf("%d ", j);
			}
			System.out.println();
		}
	}

}
