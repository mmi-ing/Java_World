package pm;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HamFrameEx2 extends JFrame implements ActionListener {
	
	JPanel center_p, north_p;
	JButton left_bt, center_bt, right_bt;
	
	public HamFrameEx2() {
		north_p = new JPanel();
		left_bt = new JButton("L");
		center_bt = new JButton("C");
		right_bt = new JButton("R");
		
		this.add(north_p, BorderLayout.NORTH); 		// 현재창 North 영역에 north_p를 추가
		this.add(center_p = new JPanel());
		
		this.setBounds(300, 50, 400, 400);
		this.setVisible(true);
		
		this.addWindowListener(new MyAbsEx2()); 
		left_bt.addActionListener(this);
		center_bt.addActionListener(this);
		right_bt.addActionListener(this);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
