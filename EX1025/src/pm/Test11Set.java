package pm;

import java.util.HashSet;
import java.util.Iterator;

public class Test11Set {

	public static void main(String[] args) {
		// 중복을 허용하지 않는 Set구조를 생성하자!
		HashSet<Integer> s = new HashSet<>();
		s.add(100);
		s.add(99);
		s.add(120);
		s.add(99);		// 허용안됨!!
		System.out.println(s.size());  		// 3
		
		s.remove(99);
		System.out.println(s.size()); 		// 2
		
		s.add(200);
		// Set구조는 index가 없으므로 그냥 통 안에 무작위로 들어간 상태라고 생각해야 한다.
		// 만약!
		// Set구조의 요소들을 반복처리하기 위해서는 iterator(반복자)를 사용해야 한다.
		// 먼저 Set구조로부터 Iterator를 얻어낸다.
		Iterator<Integer> it = s.iterator();
		while(it.hasNext()) {  	// hasNext()는 현재 커서 (반복자)의 위치에서 
			int n = it.next();			// 바로 다음 요소에 자원이 있다면 true, 그렇지 않다면 false
			// next()는 다음 요소로 이동하여 그곳에 있는 값을 반환한다.
			// 그 값을 우린 변수 n에 저장한 상태다.
		} 		// while문의 
	}

}
