package pm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FrameEx5 extends JFrame{
	JButton bt1, bt2, bt3, bt4, bt5;
	JPanel south_p, center_p, west_p;
	JLabel lb1, lb2, lb3, lb4, lb5;
	JTextField tf1, tf2, tf3, tf4, tf5;  		// 배열해도 될 듯 
	FlowLayout flow;
	GridLayout grid;
	JTextArea ta;
	JColorChooser cc;
	
	public FrameEx5() {
		south_p = new JPanel();
		center_p = new JPanel();
		west_p = new JPanel();
		
		// 버튼 배치 
		flow = new FlowLayout(FlowLayout.RIGHT);
		south_p.setLayout(flow);
		
		bt1 = new JButton("전체");
		bt2 = new JButton("추가");
		bt3 = new JButton("검색");
		bt4 = new JButton("삭제");
		bt5 = new JButton("취소");
		south_p.add(bt1);
		south_p.add(bt2);
		south_p.add(bt3);
		south_p.add(bt4);
		south_p.add(bt5);
		
		this.add(south_p, BorderLayout.SOUTH);
		
		// 왼쪽 배치 (라벨, 텍스트)
		grid = new GridLayout(7, 2);
		west_p.setLayout(grid);
		
		lb1 = new JLabel("사번");
		lb2 = new JLabel("이름");
		lb3 = new JLabel("부서");
		lb4 = new JLabel("직책");
		lb5 = new JLabel("이메일");
		tf1 = new JTextField(1);
		tf2 = new JTextField(2);
		tf3 = new JTextField(3);
		tf4 = new JTextField(4);
		tf5 = new JTextField(5);

		west_p.add(lb1);
		west_p.add(tf1);
		west_p.add(lb2);
		west_p.add(tf2);
		west_p.add(lb3);
		west_p.add(tf3);
		west_p.add(lb4);
		west_p.add(tf4);
		west_p.add(lb5);
		west_p.add(tf5);
		
		this.add(west_p, BorderLayout.WEST);
		
		// 센터 
		ta = new JTextArea("Text Area");
//		cc = new JColorChooser();
		
	   center_p.add(ta);
//		center_p.add(cc);
		
		this.add(center_p, BorderLayout.CENTER);
		
		
		// 뭉텅이
		this.setSize(600, 550);
		this.setLocation(300, 50);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new FrameEx5();
	}

}
