package pm;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameEx3 extends JFrame {
	// 현재 창 객체가 가지는 모든 것을 멤버변수로 선언한다.
	//JButton bt1, bt2, bt3, bt4, bt5;
	JButton[] bt_ar = new JButton[5];
	JPanel p1;
		
	public FrameEx3() {
		this.setTitle("My Window");
			
		p1 = new JPanel();
		
//		bt1 = new JButton("버튼1");
//		bt2 = new JButton("버튼2");
//		bt3 = new JButton("버튼3");
//		bt4 = new JButton("버튼4");
//		bt5 = new JButton("버튼5");
//		
//		
//		// 패널에 각 버튼 추가
//		p1.add(bt1);
//		p1.add(bt2);
//		p1.add(bt3);
//		p1.add(bt4);
//		p1.add(bt5);
		
		for(int i = 0; i<bt_ar.length; i++) {
			bt_ar[i] = new JButton("버튼" + (i+1));
			p1.add(bt_ar[i]);
		}
		
		
		// 버튼 5개를 가지고 있는 패널을 창 하위(South)에 추가
		
		this.add(p1, BorderLayout.SOUTH);
		
		this.setSize(500, 500);
		this.setLocation(300, 50);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
			
		}
	
		public static void main(String[] args) {
			FrameEx3 ex3 = new FrameEx3();
	}

}
