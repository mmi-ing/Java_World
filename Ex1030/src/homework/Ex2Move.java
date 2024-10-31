package homework;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Ex2Move extends JFrame implements ActionListener {
	
	JPanel north_p;
	JButton left_bt, center_bt, right_bt;
	
	public Ex2Move() {
		north_p = new JPanel();
		left_bt = new JButton("Left");
		center_bt = new JButton("Center");
		right_bt = new JButton("Right");
		
		north_p.add(left_bt);
		north_p.add(center_bt);
		north_p.add(right_bt);
		
		this.add(north_p, BorderLayout.NORTH);
		
		this.setBounds(300, 50, 400, 450);
		this.setVisible(true);
		
		// 종료를 전담하는 객체 생성
		this.addWindowListener(new MyWin()); 	// 종료 이벤트 감지자 등록
		left_bt.addActionListener(this);
		center_bt.addActionListener(this);
		right_bt.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 클릭한 버튼을 알아내자!
		Object obj = e.getSource();
		int align = -1;
		if(obj == left_bt) 	// 사용자가 왼쪽 버튼을 클릭한 경우
			align = FlowLayout.LEFT;
		else if(obj == center_bt)
			align = FlowLayout.CENTER;
		else
			align = FlowLayout.RIGHT;
		
		north_p.setLayout(new FlowLayout(align));
		north_p.updateUI();  		// UI가 업데이트 

	}

	public static void main(String[] args) {
		// 프로그램 시작
		new Ex2Move();

	}

}
