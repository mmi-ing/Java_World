package am;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Lotto extends JFrame implements MouseListener {

    Toolkit tk;     // 이미지 생성할 때 사용
    JPanel north_p, center_p;
    JButton bt;
    Image[] selectedImages;

    public Lotto() {
        FlowLayout flow = new FlowLayout(FlowLayout.RIGHT);
        north_p = new JPanel(flow);
        bt = new JButton("생성");

        north_p.add(bt);
        bt.addMouseListener(this);
        this.add(north_p, BorderLayout.NORTH);

        // 센터
        center_p = new JPanel();
        tk = Toolkit.getDefaultToolkit();
        selectedImages = new Image[6];

        this.add(center_p);

        this.setBounds(300, 50, 800, 250);
        this.setVisible(true);
        this.addWindowListener(new MyWin());
    }

    public static void main(String[] args) {
        new Lotto();
    }

    @Override
    public void paint(Graphics g) {

        int x = 50;
        int y = 100;
        int gap = 120; // 이미지 간 간격

        for (Image img : selectedImages) {
            if (img != null) { // 배열 요소가 null이 아닌 경우만 그림
                g.drawImage(img, x, y, 120, 120, this);
                x += gap;
            }
        }
    }
    /*
    @Override
    public void actionPerformed(ActionEvent e) {
        // 생성버튼을 클릭할 때마다 수행하는 곳!
        setArray();     //난수를 저장한다. 물론 중복체크까지 수행한다.
        setLable();     //난수가 모두 만들어진 배열을 가지고 ImageIcon 생성 후 JLable 생성하여 center_p에 추가하는 동작
    }

    private void setLable() {
        // center_p에 JLabel을 그리기 전에 이미 center_p에 있는 내용들을 모두 지워야 한다.
        center_p.removeAll();

        for(int i = 0; i<ar.length; i++) {
            StringBuffer sb = new StringBuffer("src/images/");
            sb.append(ar[i]);
            sb.append(".gif");

            // 위의 경로를 가지고 ImageIcon을 생성하자
            ImageIcon icon = new ImageIcon(sb.toString());

            // 위의 ImageIcon을 가지고 JLabelㅇ르 생성하자
            JLabel lv = new JLabel(icon);

            // 위의 JLabel을 center_p에 추가
            center_p.add(v);
        } // for 문의 끝
        center_p.revalidate();
    }

    private void setArray() {
        // 배열은 생성자에서 이미 생성되어 있으므르ㅗ 생성할 필요는 없다,
        for(int i=0; i<ar.length; i++) {
            // 1~45까지의 수들 중 난수 발생
            int r = (int)(Math.random()*45+1);
            ar[i] = r;

            // 위의 값이 중복된 값인지? 아닌지?를 판단하기 위해
            // 논리형 변수가 하나 필요하다.
            boolean chk = true;     // 현 true값을 chk가 계속 유지하고 있다면
                                    // 중복되지 않은 값으로 간주한다.
            for (int j = 0; j < i; j++) {
                if(ar[i]==ar[j] {
                chk = false;
                break;  // 가장 가까운 중복체크 for문 탈출!
            }
        } //중복체크 for문의 끝

        // 중복된 값이 없을 때만 (chk가 true일 때) i값ㅇ르 증가한다.
        if(chk)
            i++;
    }
    *
    * */

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == bt) {
            boolean[] isSelected = new boolean[45]; // 이미 선택된 이미지를 체크하는 배열

            // 6개의 이미지를 랜덤하게 선택
            for (int i = 0; i < 6; i++) {
                int imgIndex;
                do {
                    imgIndex = (int) (Math.random() * 45 + 1); // 1부터 45까지의 숫자 중 랜덤 선택
                } while (isSelected[imgIndex - 1]); // 이미 선택된 경우 다시 선택

                isSelected[imgIndex - 1] = true;
                selectedImages[i] = tk.getImage("src/images/" + imgIndex + ".gif");
            }

            // 새로고침하여 이미지를 다시 그림
            this.repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
