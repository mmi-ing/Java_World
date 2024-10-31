package pm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrameEx2 extends JFrame implements ActionListener {

	JPanel center_p, north_p;
	JButton red_bt, green_bt, blue_bt;
	
	public MyFrameEx2() {
		north_p = new JPanel();
		red_bt = new JButton("빨강");
		blue_bt = new JButton("파랑");
		green_bt = new JButton("초록");
		
		north_p.add(red_bt);
		north_p.add(blue_bt);
		north_p.add(green_bt);
		
		this.add(north_p, BorderLayout.NORTH); 		// 현재창 North 영역에 north_p를 추가
		this.add(center_p = new JPanel());
		
		this.setBounds(300, 50, 400, 400);
		this.setVisible(true);
		
		// 이벤트 감지자 등록
		this.addWindowListener(new MyAbsEx2()); 		// 종료 이벤트
		// 빨강, 파랑, 초록, 버튼을 클릭할 때마다 해당 색상을 center_p의 벼경색으로 지정하는 이벤트 적용!
		red_bt.addActionListener(this);
		blue_bt.addActionListener(this);
		green_bt.addActionListener(this);
		
	} 	// 생성자의 끝 
	public static void main(String[] args) {
		// 프로그램 시작
		new MyFrameEx2();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// 빨강, 파랑, 초록 각 버튼을 클릭할 때마다 현재 영역을 수행한다.
		// 그러므로 이쯤에서 어떤 버튼에 의해서 이벤트가 구동되는 지?
		// 이벤트를 발생시킨 객체를 알아내야 한다.
		Object obj = e.getSource();
		Color c = null;
		
		if(obj == red_bt)
			c = Color.RED;
		else if (obj == green_bt)
			c = Color.GREEN;
		else
			c = Color.BLUE;
		
		// 위의 색상 즉, c를 center_p의 배경색으로 지정!
		center_p.setBackground(c);
		
		
	}

}
