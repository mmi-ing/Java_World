package pm;

public class Test2IfElse문 {

	public static void main(String[] args) {
		// 1 ~ 10까지 수들 중 난수를 발생
		// 받은 난수가 짝수인지? 홀수인지?를 판단하여 출력하는 구문을 완성하시오
		
		int ran = (int) (Math.random()*10+1);
		
//		if (ran%2 == 1)
//			System.out.println(ran + " 홀수입니다.");
//		else System.out.println(ran + " 짝수입니다.");
		
		String msg = "";
		if (ran%2 != 0)
			msg = "은 홀수입니다.";
		else
			msg = "은 짝수입니다.";
		
		System.out.println(ran+msg);
	}

}
