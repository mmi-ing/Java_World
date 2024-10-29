package homework;

public class no3 {

	public static void main(String[] args) {
		String str = "Java Programming";
		int cnt = 0;
		
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			if(ch=='r')
				cnt++;
		}
		System.out.println("r 은 "+ cnt + "개 있음");	
	}
}
