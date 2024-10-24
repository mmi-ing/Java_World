package pm;

public class Lotto {

	public static void main(String[] args) {
		// 프로그램 시작
//		int k = 0;
//		int[] arr = new int[6];
//		for (int i = 0; i < arr.length; i++) {
//			int num = (int)(Math.random() * 45 + 1);
//			arr[i] = num;s
//			for (int j = 0; j < i; j++) {
//				if (arr[i] == arr[j]) {
//					--i;
//					break;
//				}
//			}
//			System.out.printf("%d ", arr[i]);
			
//		int[] lotto = new int[6];
//		
//		//1~45까지의 수들 중 난수 발생으로 초기화
//		for(int i=0; i<lotto.length; i++) {
//			int su = (int)(Math.random() * 45 + 1);		//난수 발생
//			lotto[i] = su;	//난수를 배열에 저장
//			
//			//이미 앞에서 중복된 값이 있을 수 있으므로 반복문을 통해
//			//i번째보다 작은 요소까지만 비교하는 반복문
//			for(int k=0; k<i; k++) {
//				//중복된 값을 찾은 경우
//				--i;
//			}
//		}
		
		int[] lotto = new int[6];
		boolean chk = true; //중복된 상황인지? 아닌지? 판단하는 변수
		
		//1~45까지의 수들 중 난수 발생으로 초기화
		for(int i=0; i<lotto.length;) {
			int su = (int)(Math.random() * 45 + 1);		//난수 발생
			lotto[i] = su;	//난수를 배열에 저장
			
			//이미 앞에서 중복된 값이 있을 수 있으므로 반복문을 통해
			//i번째보다 작은 요소까지만 비교하는 반복문
			for(int k=0; k<i; k++) {
				if(lotto[i] == lotto[k]) {
					//중복된 값을 찾은 경우
					chk = false;
					break; //가장 가까운 반복문 탈출!
				}
			}
			//제어권이 여기 왔을 때는 문제가 있다.
			//현재 i번째요소의 값이 중복된 값인지? 아닌지? 알 수가 없다.
			if(chk) {
				//중복된 상황이 아닌 경우 수행하는 곳!
				System.out.printf("%-3d", lotto[i]);
				++i;
			}//if문의 끝
		
		}
	}

}
