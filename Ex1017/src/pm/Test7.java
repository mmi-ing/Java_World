package pm;

public class Test7 {

	public static void main(String[] args) {
		// 프로그램 시작
		// 알파벳 A ~ Z 까지 들 중 하나가 선택된다.
//		int abc = (int)'Z';
//		System.out.println(abc);
		
		//A 65 Z 90
		char alp = (char)(Math.random()*25 + 65); 
		System.out.println(alp);
		
		// 'E' : "전자제품"
		// 'S' : "스포츠용품"
		// 'L' : "생활용품"
		// 'F' 또는 'G' : "식료품" ( || ) 
		// 그 외는 "구분되지 않는 상품"
		// 을 출력하는 구문을 완성하시오!
		
		String msg = "";
		
		//Switch문
		switch(alp) {
			case 'E':
				msg = "전자제품";
				break;	
			case 'S':
				msg = "스포츠용품";
				break;
			case 'L':
				msg = "생활용품";
				break;
			case 'F':
			case 'G':
				msg = "식료품";
				break;
			default:
				msg = "구분되지 않는 상품";			
		}
		System.out.println(alp + "는 " + msg);
		
		
		//If문
		if (alp == 'E')
			msg = "전자제품";
		else if (alp == 'S')
			msg = "스포츠용품";
		else if (alp == 'L')
			msg = "생활용품";
		else if (alp == 'F' || alp == 'G')
			msg = "식료품";
		else msg = "구분되지 않는 상품";
		
		System.out.println(alp + "는 " + msg);
		

	}

}
