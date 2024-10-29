package am;

import java.util.ArrayList;

public class Test2List {

	public static void main(String[] args) {
		// List구조 객체생성
		ArrayList<Integer> al = new ArrayList<>(3);
		
		// 현재 List구조의 사이지를 얻어내자!
		int size = al.size();
		System.out.println(size); 			// 0
		
		al.add(100);
		size = al.size();
		System.out.println(size); 		// 1
		
		for (int i = 1; i < 11; i++)
			al.add(i);
		
		size = al.size();
		System.out.println(size); 		// 11		
		
		// => 사이즈를 3으로 지정을 해두었지만 사이즈가 유연하게 바뀔 수 있음  
		
		for (int i = 0; i <al.size(); i++) {
			int val = al.get(i);		// ArrayList에 저장된 객체들이 하나씩 나온다.
			System.out.printf("%-4d", val);
		}
		 
		System.out.println(); 		// 줄바꿈 
		 
		 al.remove(1);	// ArrayList에서 1번지 즉, 두 번째 요소를 삭제한다.
		 for(int i = 0; i < al.size(); i++) {
			 int val = al.get(i);  		// ArrayList에 저장된 객체들이 하나씩 나온다.
			 System.out.printf("%-4d", val);
		 }
		 
		 System.out.println(); 		// 줄바꿈 
		 
		 // 원하는 위치에 추가하기 - insert
		 al.add(3, 400);
		 for(int i = 0; i < al.size(); i++) {
			 int val = al.get(i);  		// ArrayList에 저장된 객체들이 하나씩 나온다.
			 System.out.printf("%-4d", val);
		 }
		 
		 System.out.println(); 		// 줄바꿈
		 
		 al.clear();  			// 모두 삭제
		 System.out.println(al.size());
		 
		 // 특정 객체가 ArrayList에 포함되어 있는 지? 검사하는 함수
		 boolean chk = al.contains(99);
		 System.out.println("99가 포함되었는지?:" + chk); 		// false
		 
		 chk = al.contains(400);
		 System.out.println("400이 포함되었는지?:" + chk); 		// false
		 
		 // 400을 찾아서 삭제하자!
		 int idx = al.indexOf(400);
		 if(idx != -1)
			 al.remove(idx);
		 
		 al.clear(); 	// 모두 삭제 
		 System.out.println(al.size());
		 
		 
		 // List 구조에서 알아야 될 함수들
		 // add : 추가 
		 // get : 추출 
		 // remove : 삭제 
		 // size : 저장 수 
		 // contains : 포함여부 확인
		 // isEmpty : 
		 
		 
	
	
	}

}
