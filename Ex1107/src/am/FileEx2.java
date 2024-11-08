package am;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class FileEx2 extends JFrame implements ActionListener {
    JPanel north_p;
    JTextField input_tf;
    JButton ok_bt, back_bt;
    JList<String> list;

    public FileEx2() {
        this.add(new JScrollPane(list = new JList<>()));

        north_p = new JPanel();
        input_tf = new JTextField(20);
        ok_bt = new JButton("확인");
        back_bt = new JButton("뒤로");


        north_p.add(new JLabel("경로"));
        north_p.add(input_tf);
        north_p.add(ok_bt);
        north_p.add(back_bt);

        this.add(north_p, BorderLayout.NORTH);

        this.setBounds(300, 50,600,500);
        this.setVisible(true);


        // 이벤트 감지자 등록
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);  // 프로그램 종료
            }
        });
        // 확인버튼에게 이벤트 감지자 등록
        ok_bt.addActionListener(this);  // 확인 버튼을 클릭할 때마다 현재객체(this)에서 actionPerformed를 자동호출한다
        input_tf.addActionListener(this);  // 엔터를 클릭할 때 호출

        // 더블 클릭
        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // 더블 클릭을 했는지? 확인!
                if (e.getClickCount() == 2) {
                    // 더블 클릭한 경우
                    // 더블 클릭하고 선택된 값을 가져온다.
//                    String click = list.getSelectedValue();
                    String click = list.getSelectedValue();
                    // 얻어낸 선택된 값을 input_tf 안에 추가한다.
                    StringBuffer sb = new StringBuffer(input_tf.getText());
                    sb.append("/");
                    sb.append(click);
                    // 문자열 편집된 내용을 다시 input_tr에 저장한다.
                    input_tf.setText(sb.toString());

                    viewList();
                }
            }
        });
        back_bt.addActionListener(this);
    } // 생성자의 끝

    public static void main(String[] args) {
        new FileEx2();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 만약에 back_bt에서 이벤트가 발생했다면
        Object obj = e.getSource();
        if (obj == back_bt) {
            // 현재 input_tf에서 경로 문자열로 가져온다.
            String path = input_tf.getText();

            // "C:/my_study/java_study" 이런 경우 가장 오른쪽에 있는 "/"를 찾아
            // index값을 얻어낸다
            int index = path.lastIndexOf("/");

            // 검색된 "/"의 뒷 부분이 필요가 없으므로 0번~index 전까지를 추출한다,
            String p = path.substring(0, index);

            // 추출한 경로(p)를 다시 input_tf 에 적용시킨다.
            input_tf.setText(p);
        }
        viewList();
    }

    private void viewList() {
        // 1. input_tf애 사용자가 입력한 경로를 가져온다.
        String path = input_tf.getText().trim();
        if(path.length() > 3 ) {
            // 잘 입력한 경우!
            // 일단은 File객체로 생성한다
            File f = new File(path);

            // 존재여부 확인 후 폴더인지 판단
            if(f.exists()) {
                // 존재할 경우
                if(f.isDirectory()) {
                    // 폴더의 하위요소 모두 가져오기
                    String[] ar = f.list();

                    // 받은 배열을 JList에 넣어준다.
                    list.setListData(ar);

                } else {
                    // 존재하지만 파일인 경우
                    JOptionPane.showMessageDialog(this, "폴더 경로를 입력하세요.");
                }
            }else {
                // 경로가 존재하지 않는 경우
                JOptionPane.showMessageDialog(this, "존재하지 않습니다.");
                initTextList(); // 함수호출
            }
        }else {
            // 경고창을 보여준다.
            JOptionPane.showMessageDialog(this, "유효하지 않는 값입니다.");
            initTextList(); // 함수호출
        }
    }

    private void initTextList() {
        input_tf.setText("");   // 청소
        list.setListData(new String[0]);
    }
}


//
//package am;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//import java.io.File;
//import java.util.ArrayList;
//
//public class FileEx2 extends JFrame implements ActionListener {
//    JPanel north_p;
//    JTextField input_tf;
//    JButton ok_bt, back_bt;
//    JList<String> list;
//    ArrayList<String> pathHistory = new ArrayList<>(); // 경로 히스토리를 저장할 ArrayList
//
//    public FileEx2() {
//        this.add(new JScrollPane(list = new JList<>()));
//
//        north_p = new JPanel();
//        input_tf = new JTextField(20);
//        ok_bt = new JButton("확인");
//        back_bt = new JButton("뒤로");
//
//        north_p.add(new JLabel("경로"));
//        north_p.add(input_tf);
//        north_p.add(ok_bt);
//        north_p.add(back_bt);
//
//        this.add(north_p, BorderLayout.NORTH);
//
//        this.setBounds(300, 50, 600, 500);
//        this.setVisible(true);
//
//        // 이벤트 감지자 등록
//        this.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                System.exit(0);  // 프로그램 종료
//            }
//        });
//
//        // 확인 버튼과 입력 필드 이벤트 등록
//        ok_bt.addActionListener(this);
//        input_tf.addActionListener(this);
//
//        // "뒤로" 버튼 이벤트 등록
//        back_bt.addActionListener(e -> {
//            if (pathHistory.size() > 1) { // 이전 경로가 있는지 확인
//                pathHistory.remove(pathHistory.size() - 1); // 현재 경로 제거
//                String previousPath = pathHistory.get(pathHistory.size() - 1); // 이전 경로 가져오기
//                input_tf.setText(previousPath);
//                viewList(); // 이전 경로로 목록 갱신
//            } else {
//                JOptionPane.showMessageDialog(this, "더 이상 뒤로 갈 경로가 없습니다.");
//                initTextList(); // 빈 화면으로 초기화
//            }
//        });
//
//        // 더블 클릭 이벤트 처리
//        list.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                if (e.getClickCount() == 2) {
//                    String click = list.getSelectedValue();
//                    if (click != null) {
//                        String currentPath = input_tf.getText().trim();
//                        String newPath = currentPath.endsWith(File.separator) ? currentPath + click : currentPath + File.separator + click;
//
//                        // 경로가 변경될 때 현재 경로를 히스토리에 저장
//                        pathHistory.add(currentPath);
//
//                        input_tf.setText(newPath);
//                        viewList();
//                    }
//                }
//            }
//        });
//    }
//
//    public static void main(String[] args) {
//        new FileEx2();
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        // 현재 경로를 히스토리에 추가
//        String currentPath = input_tf.getText().trim();
//        if (!currentPath.isEmpty() && (pathHistory.isEmpty() || !pathHistory.get(pathHistory.size() - 1).equals(currentPath))) {
//            pathHistory.add(currentPath);
//        }
//        viewList();
//    }
//
//    private void initTextList() {
//        input_tf.setText("");   // 청소
//        list.setListData(new String[0]);
//    }
//
//    private void viewList() {
//        String path = input_tf.getText().trim();
//        if (path.length() > 3) {
//            File f = new File(path);
//            if (f.exists()) {
//                if (f.isDirectory()) {
//                    String[] ar = f.list();
//                    if (ar != null) {
//                        list.setListData(ar);
//                    } else {
//                        JOptionPane.showMessageDialog(this, "하위 파일을 가져올 수 없습니다.");
//                    }
//                } else {
//                    JOptionPane.showMessageDialog(this, "폴더 경로를 입력하세요.");
//                }
//            } else {
//                JOptionPane.showMessageDialog(this, "존재하지 않습니다.");
//            }
//        } else {
//            JOptionPane.showMessageDialog(this, "유효하지 않는 값입니다.");
//            initTextList();
//        }
//    }
//}