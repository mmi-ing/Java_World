package am;

import javax.swing.JFrame;

public class FrameEx3 extends JFrame {
	public FrameEx3() {
		this.setSize(500, 450);
		this.setLocation(500,50);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 		// 종료
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		//프로그램 시작
		
		//현재 클래스 생성
		FrameEx3 ex = new FrameEx3();
//		ex.setSize(500, 450);
//		ex.setLocation(500,50);
//		ex.setVisible(true);
		// 위 3개의 함수 호출은 생성자에서 하는 것이 바람직하다!
	}
	

}
