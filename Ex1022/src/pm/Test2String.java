package pm;

public class Test2String {

	public static void main(String[] args) {
		// 문자열 객체 생성
		String s1 = "Test Java Example";
		
		// s1이 가리키는 객체의 내용에서 소문자 a를 찾아 "*"로 모두 변경하고자 한다.
		String s2 = s1.replaceAll("a", "*");
		System.out.println(s2);
		System.out.println(s1);
		System.out.println("---- substring연습 ----");
		
//		String s3 = s1.substring(5);	// Java Example
//		System.out.println(s3);
		
		// 문제 : s1에서 대문자 J를 찾아서 인덱스 값을 알아내어
		// 그 위치에서 끝까지 문자열 추출하여 출력하시오!
		
		int idx = s1.indexOf("J");
//		System.out.println("idx:"+idx);
		String s3 = s1.substring(idx);
		System.out.println("s1.substring(idx):"+s3);
		
		// s1에서 "Java"만 추출하기 위해 인덱스를 알아봤더니
		// 5~8까지였다. 이것을 이용하여 추출해보자!
		// String s4 = s1.substring(5,8);	//Jav
		// 문자열 추출시 원하는 시작지점을 찾은 후
		// 그 시작점에서 글자 수를 더해서 가져온다.
		String s4 = s1.substring(idx, idx+4);
		System.out.println(s4);
				
	}

}
