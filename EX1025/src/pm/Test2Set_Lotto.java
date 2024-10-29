package pm;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class Test2Set_Lotto {

	public static void main(String[] args) {
		// 로또를 만들기 위해 Set구조를 생성하자!
//		HashSet<Integer> lotto = new HashSet<>();
		TreeSet<Integer> lotto = new TreeSet<>(); 		// 기본적으로 오름차순 정렬을 지원해줌 
		
		for(;;) {
			int n = (int)(Math.random()*45+1); 		// 난수 발생
			lotto.add(n);
			if(lotto.size() == 6)
				break; 		// 무한반복 탈출 
		} //무한반복 끝 
		System.out.println(lotto);
		
		// 반복문을 이용하여 출력하고자 한다면 반드시
		// Iterator화 시켜서 반복처리해야 한다.
		Iterator<Integer> it = lotto.iterator();
		while(it.hasNext()) {
			int su = it.next();
			System.out.printf("%-3d", su);
		} //while문의 
	}

}
