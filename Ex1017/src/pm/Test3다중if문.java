package pm;

public class Test3다중if문 {

	public static void main(String[] args) {
		// 프로그램 시작
		
		int score = (int)(Math.random()*101); // 0~100까지의 수들 중 난수발생!!
		
		// 점수가 70 ~ 100까지는 "우수"
		// 점수가 50~ 69까지는 "보통"
		// 점수가 50미만은 "노력"
		
//		if (score >= 70)
//			System.out.println(score + "점 우수");
//		else if ( score >= 50 )	// 제어권이 현재 행에 왔다면 score의 최대값은 69다
//			System.out.println(score + "점 보통");
//		else System.out.println(score + "점 노력");
		
		if (score >= 95)
			System.out.println(score + "점 A+");
		else if (score >= 90)
			System.out.println(score + "점 A-");
		else if (score >= 85)
			System.out.println(score + "점 B+");
		else if (score >= 80)
			System.out.println(score + "점 B-");
		else if (score >= 75)
			System.out.println(score + "점 C+");
		else if (score >= 70)
			System.out.println(score + "점 C-");
		else System.out.println(score + "점 재수강");
	}

}
