package pm;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FrameEx1 extends JFrame {
	
		// 현재 창에 보여질 객체들 또는 변수들을 선언한다.
		private JButton bt1, bt2, bt3;
		
		public FrameEx1(String title) {
			bt1 = new JButton("버튼1");
			bt2 = new JButton("버튼2");
			bt3 = new JButton("버튼3");
			
			// 생성된 버튼 객체들을 현재 창에 추가
			this.add(bt1, BorderLayout.WEST);
			this.add(bt2, BorderLayout.CENTER);
			this.add(bt3, BorderLayout.EAST);
			
			this.setSize(500, 450);
			this.setLocation(300, 50);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  		//종료
			this.setVisible(true);
		}// 생성자의 끝 

	public static void main(String[] args) {
		// 프로그램 시작
		
		// 현재 객체 생성
		FrameEx1 ex1 = new FrameEx1("MyWindow");

	}

}
