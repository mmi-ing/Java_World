package pm;

public class Test4String {

	public static void main(String[] args) {
		// 프로그램 시작
		
		String p_num = "010-1234-5678";
		String s = p_num.replaceAll("-", "");
		System.out.println(s);
		
		System.out.println("--- 별도로 구분해서 관리하려면 ---");
		String[] p_ar = p_num.split("-");
		
		for(int i=0; i<p_ar.length; i++) {
			System.out.printf("%s", p_ar[i]);
		}

	}

}
