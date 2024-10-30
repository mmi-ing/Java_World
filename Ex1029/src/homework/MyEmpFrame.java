package homework;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyEmpFrame extends JFrame implements MouseListener {
	// 화면에서 표현되는 모든 객체들을 멤버변수로 선언!
	JButton bt1, bt2, bt3, bt4, bt5;
	JTextField tf1, tf2, tf3, tf4, tf5;
	JLabel lb1, lb2, lb3, lb4, lb5;
	JTextArea ta;
	JPanel south_p, west_p, w_p1, w_p2, w_p3, w_p4, w_p5;
	
	public MyEmpFrame() {
		FlowLayout flow = new FlowLayout(FlowLayout.RIGHT);  		// 오른쪽 정렬의 레이아웃 생성  
		south_p = new JPanel(flow); 		// 오른쪽 정렬의 패널 생성
		
		// 아래쪽에 들어갈 버튼 5개 생성
		bt1 = new JButton("전체");
		bt2 = new JButton("추가");
		bt3 = new JButton("검색");
		bt4 = new JButton("삭제");
		bt5 = new JButton("취소");
		
		// 생성된 5개의 버튼객체들을 south_p에 추가
		south_p.add(bt1);
		south_p.add(bt2);
		south_p.add(bt3);
		south_p.add(bt4);
		south_p.add(bt5);
		
		south_p.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		
		// 버튼 객체 5개를 가지는 패널객체를 현재 창의 South영억에 추가!
		this.add(south_p, BorderLayout.SOUTH);
		
		// -----------왼쪽 부분 UI 작업-------------------------------------------------
		west_p = new JPanel(new GridLayout(8, 1));
		
		w_p1 = new JPanel();
		lb1 = new JLabel("사번");
		tf1 = new JTextField(7);
		w_p1.add(lb1);
		w_p1.add(tf1);
		
		w_p2 = new JPanel();
		lb2 = new JLabel("이름");
		tf2 = new JTextField(7);
		w_p2.add(lb2);
		w_p2.add(tf2);
		
		w_p3 = new JPanel();
		lb3 = new JLabel("부서");
		tf3 = new JTextField(7);
		w_p3.add(lb3);
		w_p3.add(tf3);
		
		w_p4 = new JPanel();
		lb4 = new JLabel("직책");
		tf4 = new JTextField(7);
		w_p4.add(lb4);
		w_p4.add(tf4);
		
		w_p5 = new JPanel();
		lb5 = new JLabel("이메일");
		tf5 = new JTextField(7);
		w_p5.add(lb5);
		w_p5.add(tf5);
		
		// 앞서 생성하고 자리잡은 w_p1 ~ w_p5까지의 패널들을 west_p에 추가!
		west_p.add(new JLabel());  	// 빈 공간 처리
		west_p.add(w_p1);
		west_p.add(w_p2);
		west_p.add(w_p3);
		west_p.add(w_p4);
		west_p.add(w_p5);
		
		// west_p를 현재 창의 West영역에 추가!
		this.add(west_p, BorderLayout.WEST);
		
		// 현재 창의 가운데에 JTextArea를 추가!
		// this.add(ta = new JTextArea());			// 이렇게 하면 스크롤 바가 생기지 않는다
		// 스크롤 바는 JScrollPane이라는 객체를 쓰는 것이 좋다.
		JScrollPane scroll = new JScrollPane(ta = new JTextArea());
		this.add(scroll);
		
		ta.setEditable(false); 		//JE=JTextArea를 비활성화!
		
		//this.setSize(500, 400);
		//this.setLocation(300, 50);
		this.setBounds(300, 50, 500, 300); 		// setSize + setLocation
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 		// X버튼 클릭시 종료!
		this.setVisible(true); 		// 보여주기
		
		// 이벤트 감지자 등록  ********************************
		bt5.addMouseListener(this);
		// bt5에게 마우스이벤트 감지자를 등록한다. 그 감지자는 바로 현재 객체(this)가 그 감지자이며,
		// 어떤 상황에서 bt5를 클릭하는 이벤트가 발생하면 현재 객체(this)에서 클릭 이벤트에 해당하는 함수
		// mouseCliked를 자동 호출한다.
		
		// 문제) bt4를 마우스로 누를 때 그것을 감지하고 창의 제목을 "눌렀네"로 변경하자!
		bt4.addMouseListener(this);
		
		
	}
	
	public static void main(String[] args) {
		// 프로그램 시작
		new MyEmpFrame();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// 이벤트 발생 객체를 얻어낸다.
		Object obj = e.getSource();
		if( obj==bt5 ) { 		// 이벤트를 발생 시킨 여러 개의 객체 중 bt5일 경우
			// 프로그램 종료!
			System.exit(0);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if ( e.getSource() == bt4) {
			this.setTitle("눌렀네");
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
