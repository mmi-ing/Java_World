package pm;

public class Test4다중if문 {

	public static void main(String[] args) {
		// 0~100까지의 난수 발생
		int score = (int)(Math.random()*101);
		/*
			95~100까지 : "A+"
			90~94까지 : "A+"
			85~89까지 : "B+"
			80~84까지 : "B-"
			75~79까지 : "C+"
			70~74까지 : "C-"
			그 외 : "재수강"
		*/
		String msg = "";
		
		if (score >= 95)
			msg = "A+";
		else if (score >= 90)
			msg = "A-";
		else if (score >= 85)
			msg = "B+";
		else if (score >= 80)
			msg = "B-";
		else if (score >= 75)
			msg = "C+";
		else if (score >= 70)
			msg = "C-";
		else msg = "재수강";
		
		System.out.println("당신의 점수는 : " + score + "점 입니다. 그러므로 " + msg + "입니다.");
		
	}

}
