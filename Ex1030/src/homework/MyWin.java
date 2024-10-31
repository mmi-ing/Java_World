package homework;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyWin extends WindowAdapter {
	// 원하는 종료할 때 발생하는 함수만 재정의 한다.

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	
	

}
