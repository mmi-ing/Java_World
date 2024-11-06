package pm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameEx1 extends JFrame implements ActionListener{

	Thread t1 ;// 시작버튼을 클릭할 때 생성되어 단어들을 화면 위에서
				// 아래로 눈 내리듯 떨어지게 하는 스레드
	boolean chk = true;
	
	JPanel p, north_p;
	JButton start_bt;
	
	ArrayList<WordThread> list = new ArrayList<>();
	String[] txt_ar = {"통조림", "학교", "코끼리", "마우스", "키보드", "컴퓨터"};
	
	public FrameEx1() {
		
		north_p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		north_p.add(start_bt = new JButton("시작"));
		
		this.add(north_p, BorderLayout.NORTH);
		
		this.add(p = new JPanel() {
			//JPanel을 상속받는 익명의 내부틀래스다.

			@Override
			protected void paintComponent(Graphics g) {
				//더블버퍼인 Image객체 준비
				Image img = createImage(this.getWidth(), this.getHeight());
				
				Graphics img_g = img.getGraphics();// 이미지에만 그림을 그리는 전용 붓!!!!
				
				// 리스트 구조안에 있는 WordThread객체들을 모두 가져와서
				// 그림을 그린다.
				for(int i=0; i<list.size(); i++) {
					WordThread tt = list.get(i);
					
					img_g.setColor(tt.color);
					img_g.drawString(tt.str, tt.x, tt.y);				
				}
				g.drawImage(img, 0, 0, this);
				
			}
			
			
		});
		
		this.setBounds(300, 50, 600, 500);
		this.setVisible(true);
		
		//이벤트 감지자 등록
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);//프로그램 종료!
			}
		});
		
		//시작버튼 클릭 감지자 등록
		start_bt.addActionListener(this);
	}
	
	public static void main(String[] args) {
		// 프로그램 시작
		new FrameEx1();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// t1이라는 스레드 생성하고 스레드 구동!
		t1 = new Thread() {

			@Override
			public void run() {
				// 일정한 시간(0.1초)이 흐를 때마다 WordThread를 생성한다.
				while(chk) {
					WordThread wt = new WordThread(FrameEx1.this);
					list.add(wt); //바깥쪽 클래스가 가지는 list에 저장
					wt.start();// 스스로 떨어지도록 해당 스레드 시작!!!!!
					
					try {
						Thread.sleep(100);
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
			
		};
		t1.start();// 단어들을 만들어 떨어지게 하는 스레드 시작!!!!!
	}

}
