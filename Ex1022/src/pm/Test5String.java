package pm;
import java.util.Scanner;

public class Test5String {

	public static void main(String[] args) {
		// 프로그램 시작
		Scanner scan = new Scanner(System.in);
		System.out.printf("입력(행/열):");
		
		
		String num = scan.nextLine();
		System.out.println(num);
		
		char ch1 = num.substring(0,1);
		char ch2 = num.substring(1);
		System.out.println(ch1);
		System.out.println(ch2);
		
		int[][] ar = new int[(int)ch1][(int)ch2];
		
		
		

	}

}
