package homework;

public class no2 {

	public static void main(String[] args) {
		String str = "Java Programming";
		
		int idx = str.indexOf("v");
		System.out.println("idx:"+idx);

		String str2 = str.substring(idx, idx+2);
		System.out.println(str2);
	}
}
