package am;

import java.util.ArrayList;

public class Test5Main {
	
	public static void test(ArrayList<Integer> n) {
		n.add(202);
		n.add(200);
		System.out.println("n.size(): "+n.size());		// 3	
	}
	
	// Varargs 개념 
	public void test2 (int ...n ) {
		System.out.println("Varargs개념의 지역변수(n)는 배열개념이 된다.");
		System.out.println("Argument length:"+n.length);
		
		for(int i = 0; i<n.length; i++) {
			System.out.println(n[i]);
		}
	}
	
	/*
	public void test(int n, int n2) {
		System.out.println(++n);
		System.out.println(++n2);
	}
	*/

	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<>();
		
		al.add(404);
		System.out.println(al.size()); 		// 1
		
//		Test5Main.test(al);		//	test함수를 호출할 때 al이 가리키는 주소를 복사해서
												// test함수의 지역변수인 n에게 복사해 준다.
		
		Test5Main t = new Test5Main();
		Test5Main.test(al);
		
		System.out.println(al.size()); 		// 3
		
		t.test2(10);
		t.test2(1,10,100);

	}

}
