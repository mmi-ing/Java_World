package pm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameEx4 extends JFrame {
	
	JButton bt;
	JCheckBox ch1, ch2, ch3;
	JPanel north_p, center_p;
	GridLayout grid;
	FlowLayout flow;
	
	public FrameEx4() {
		north_p = new JPanel();
		center_p = new JPanel();
		
		flow = new FlowLayout(FlowLayout.RIGHT);		// 오른쪽 맞춤의 FlowLayout이다.
		north_p.setLayout(flow);
		
		grid = new GridLayout(3, 1);
		center_p.setLayout(grid); 	// 위 레이아웃을 center_p에 적용 
		
		bt = new JButton("확인");
		north_p.add(bt);
		
		ch1 = new JCheckBox("항목1");
		ch2 = new JCheckBox("항목2");
		ch3 = new JCheckBox("항목3");
		center_p.add(ch1);
		center_p.add(ch2);
		center_p.add(ch3);
		
		// 현재 창에 각 패널들 추가
		this.add(north_p, BorderLayout.NORTH);
		this.add(center_p); 		// CENTER
		
		this.setSize(600, 550);
		this.setLocation(300, 50);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		
		new FrameEx4();
		
	}

}
