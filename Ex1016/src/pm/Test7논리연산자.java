package pm;

public class Test7논리연산자 {

	public static void main(String[] args) {
		// 프로젝트 시작
		// 논리연산자( && : 그리고, || : 또는 )
		int a = 10;
		int b = 10;
		
		System.out.println(++a > b++ || ++a != ++b ); // 앞에 T나와서 뒷 부분 수행 안함 a=11, b=11
//		System.out.println(++a > b++ && ++a != ++b ); // 앞에 T나왔어도 뒷 부분도 수행해야 함 a=12, b=12
		
		System.out.println(a); // 11
		System.out.println(b); // 11
	}

}
