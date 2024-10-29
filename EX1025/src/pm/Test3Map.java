package pm;

import java.util.HashMap;

public class Test3Map {

	public static void main(String[] args) {
		// Map구조 : 키와 값을 하나의 쌍으로 저장하는 구조
		HashMap<Integer, String> map = new HashMap<>();
		
		String s1 = "쌍용교육센터";
		String s2 = "SIST";
		String s3 = "SIST";
		
		map.put(100, s1);
		map.put(200, s2);
		map.put(100, s3);  // 덮어쓰기 
		
		System.out.println(map.size()); 		//2
		// Map구조로부터 데이터 검출 이때 키를 알고 있어야 함!
		String n1 = map.get(100);
		System.out.println("100: " + n1);
		String n2 = map.get(200);
		System.out.println("200: " + n2);
		
		if (n1 == n2)
			System.out.println("n1과 n2의 주소가 같다.");
		else
			System.out.println("n1과 n2의 주소가 다르다.");
			
	}

}
