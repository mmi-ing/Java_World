package pm;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyAbsEx2 extends WindowAdapter {

	@Override
	public void windowClosing(WindowEvent e) {
		// 프로그램 종료 
		System.exit(0);
	}
	//	WindowAdapter는 추상 클래스이지만 내부에는 추상메서드를 하나도 가지고 있지 않다.
	// 개발자가 필요한 메서드만 재정의 해서 사용하는 것이다. 

}
