package pm;

public class Test3String {
	
	public static void main(String[] args) {
		// 프로그램 시작
		
		String s1 = "  Java Test   ";
		int size = s1.length();
		System.out.println("s1.length():"+size);
		
		// 문자열의 앞과 뒤에 있는 무의미한 공백을 제거하자!
		String s2 = s1.trim();
		System.out.println("s1.trim():"+s2);
		
		// s1에서 소문자 a의 위치값을 알아내자!
		int idx = s1.indexOf("a");
		System.out.println("idx:"+idx);
		
		// 한 번 찾았다면 그 이후부터 다시 "a"를 찾아내려면...
		idx = s1.indexOf("a", idx+1);
		System.out.println("idx:"+idx);
		
		System.out.println("--- 문자열로 변환하는 기능 ---");
		int n = 100;
		
		// 위의 정수 n의 값이 뭔지 모르지만 몇자리의 정수값이 들어왔는지 궁금하다면
//		if(n<10)
//			System.out.println("1자리 수");
//		else if(n<100)
//			System.out.println("2자리 수");
//		else if(n<1000)
//			System.out.println("3자리 수");
		
		String str = String.valueOf(n);		//"100"
		System.out.println(str.length()+"자리 수");
	}

}
