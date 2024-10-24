package pm;

public class Test1배열 {

	public static void main(String[] args) {
		// 프로그램 시작
		
		// 문자 4개를 저장하는 배열을 만들자!
		
		//char[] ar;
		//ar = new char[4];
		char[] ar = new char[4];
		//System.out.println(ar[0]);
		
//		ar[0] = 'A';
//		ar[1] = 'B';
//		ar[2] = 'C';
//		ar[3] = 'D';
		
//		int num = 65;
//		
//		for (int i = 0; i < 4; i++) {
//			ar[i] = (char)num;
//			System.out.println(ar[i]);
//			num++;
//		}
		
		char ch = 'A';
		
		for (int i = 0; i < ar.length; i++) {
			ar[i] = ch++;
			System.out.println(ar[i]);
		}
		
		

	}

}
