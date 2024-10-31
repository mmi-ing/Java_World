package am;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyChatFrame extends JFrame implements WindowListener, MouseListener {
	// 현재 창에 나타낼 객체들을 멤버변수로 선언
	JTextArea ta;
	JTextField tf;
	JButton send_bt;
	JPanel south_p;
	
	public MyChatFrame() {
		// 현재 객체는 JFrame으로부터 상속받았으므로 현재 창의 레이아웃은 BorderLayout이다.
		JScrollPane scroll = new JScrollPane(ta = new JTextArea());
		this.add(scroll); //	현재 창 가운데에 JTextArea를 가진 JScrollPane이 추가됐다.
		
		ta.setEditable(false);// JTextArea 비활성
		
		south_p = new JPanel(new BorderLayout()); 	// JPanel의 기본레이아웃은 FlowLayout이다.
													// 이것을 BorderLayout으로 변경하자!
		// south_p에 추가할 객체들 생성
		tf = new JTextField();
		send_bt = new JButton("보내기");
		south_p.add(tf); 		// south_p의 가운데에 추가
		south_p.add(send_bt, BorderLayout.EAST); 		// south_p의 오른쪽에 추가
		
		// 현재 창 South영역에 south_p추가
		this.add(south_p, BorderLayout.SOUTH);
		
		this.setBounds(300, 50,400,500);
		this.setVisible(true);
		
		// 이벤트 감지자 등록!!
		this.addWindowListener(this);
		// 이벤트 발생 객체.addWindowListener(이벤트를 수행하는 객체(여기에 다 있어야 됨));
		send_bt.addMouseListener(this);
		
		
	}

	public static void main(String[] args) {
		// 프로그램 시작
		new MyChatFrame();

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// 프로그램 종료
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// send_bt가 눌려질 때마다 현재 영역 수행!
		if(e.getSource() == send_bt) {
			String str = tf.getText(); 		// tf로부터 문자열 가져오기
			ta.append(str);
			ta.append("\r\n");
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
