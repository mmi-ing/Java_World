package homework;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ex1GuguDan extends JFrame implements ActionListener {
	// 화면에 표현될 객체들을 멤버로 선언하자
	JTextArea ta;
	JPanel north_p;
	JButton[] bt_ar;
	
	public Ex1GuguDan() {
		
		ta = new JTextArea();
		bt_ar = new JButton[8];
		north_p = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		// north_p에 들어갈 버튼들을 생성하여 배열에 저장하고, north_p에 추가한 후 이벤트를 적용하는 반복문
		for(int i = 0; i<bt_ar.length; i++) {
			bt_ar[i] = new JButton(String.valueOf(i+2));
			north_p.add(bt_ar[i]);
			bt_ar[i].addActionListener(this); 	// 이벤트 감지자 등
		}
		
		// 버튼 8개를 가진 north_p를 현재 창 North 영역에 추가 
		this.add(north_p, BorderLayout.NORTH);
		
		JScrollPane scroll = new JScrollPane(ta = new JTextArea());
		this.add(scroll);
		
		this.setBounds(300, 50, 400, 450);
		// 							x좌표,y좌표,너비,높이 
		this.setVisible(true);
		
		// 종료를 전담하는 객체 생성
		this.addWindowListener(new MyWin());
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// 숫자버튼 8개 중 하나를 누를 때마다 수행하는 곳
//		Object obj = e.getSource();
//		int dan = 0;
//		if (obj == bt_ar[0]) {
//			dan = 2;
//		}
//		
//		ta.setText(String.valueOf(dan));
		
		// 이벤트를 발생시킨 해당 버튼 객체에 쓰여진 문자열을 얻어낸다.
		String s_dan = e.getActionCommand();
		int dan = Integer.parseInt(s_dan); 		// "3" ---> 3
		ta.setText(s_dan);
		ta.append("단\r\n");
		ta.append("----------------------------------");
		for (int i=1; i<10; i++) {
			// 포멧터를 사용한 문자열
			String str = String.format("\r\n%d*%d=%d", dan, i, dan*i);
			ta.append(str);
		}
	}
	
	public static void main(String[] args) {
		// 프로그램 시작
		new Ex1GuguDan();
	}



}
