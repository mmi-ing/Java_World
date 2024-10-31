package pm;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class HamFrame extends JFrame implements MouseListener {
	
	JPanel center_p, north_p;
	JButton[] bt_ar = new JButton[8];
	JTextArea ta;
	
	public HamFrame() {
		north_p = new JPanel();
		
		for(int i = 0; i<bt_ar.length; i++) {
			bt_ar[i] = new JButton(" "+(i+2));
			bt_ar[i].addMouseListener(this);
			north_p.add(bt_ar[i]);
		}
		
		this.add(north_p, BorderLayout.NORTH);
		
		JScrollPane scroll = new JScrollPane(ta = new JTextArea());
		this.add(scroll);
		
		ta.setEditable(false); 
		
		this.setBounds(300, 50, 400, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		HamFrame ham = new HamFrame();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// 구구단
		JButton clickedButton = (JButton) e.getSource();
	    String buttonText = clickedButton.getText().trim();
	    
	    try {
	        int number = Integer.parseInt(buttonText);
	        ta.setText("");

	        for (int i = 1; i <= 9; i++) {
	            ta.append(number + " x " + i + " = " + (number * i) + "\n");
	        }
	    } catch (NumberFormatException ex) {
	        ex.printStackTrace();
	    }
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
