/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.sist.ex1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author ham
 */
public class NewJFrame extends javax.swing.JFrame {

    // 파일 읽기에 필요한 스트림 준비
    File selectedFile;
    BufferedInputStream bis;
    BufferedOutputStream bos;
    String old_data; // 파일로부터 데이터를 읽기가 완료되면 현재 변수에 바로 저장해 둔다.
    
    public NewJFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenu7 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        jMenu1.setText("jMenu1");

        jMenu8.setText("jMenu8");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(550, 450));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jMenu2.setText("File");

        jMenu4.setText("New");
        jMenu2.add(jMenu4);

        jMenu9.setText("Open");
        jMenu9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu9ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenu9);

        jMenuItem4.setText("jMenuItem4");
        jMenu2.add(jMenuItem4);

        jMenu5.setText("Save");
        jMenu5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenu5);

        jMenu6.setText("Save as...");
        jMenu6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu6ActionPerformed(evt);
            }
        });

        jMenuItem3.setText("jMenuItem3");
        jMenu6.add(jMenuItem3);

        jMenu2.add(jMenu6);
        jMenu2.add(jSeparator1);

        jMenu7.setText("Exit");
        jMenu7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenu7);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu7ActionPerformed
        closed();
    }//GEN-LAST:event_jMenu7ActionPerformed

    private void jMenu9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu9ActionPerformed
        // 읽기
        JFileChooser jfc = new JFileChooser("/Users/ham/My_Study");
        int cmd = jfc.showOpenDialog(this);     
        if(cmd == JFileChooser.APPROVE_OPTION){
            // 파일 선택기에서 사용자가 선택한 파일을 얻어낸다.
            selectedFile = jfc.getSelectedFile();  //******************************
            readFile();
        }
    }//GEN-LAST:event_jMenu9ActionPerformed

    private void jMenu5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu5ActionPerformed
        // 저장기능 
        
        // 먼저 파일이 열려있는 상태일 경우
        if (selectedFile == null) { // 여기서 false는 파일이 열려져 있는 상태 
            JFileChooser jfc = new JFileChooser("/Users/ham/My_Study");
            int cmd = jfc.showSaveDialog(this);
            if( cmd != JFileChooser.APPROVE_OPTION)
                return;     // 제어권 반환!!!!!!! 취소
            else{
                // 저장하겠다고 한 경우!
                selectedFile = jfc.getSelectedFile();
            }
        }
        saveFile();
    }//GEN-LAST:event_jMenu5ActionPerformed

    private void jMenu6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu6ActionPerformed
        // Save as 기능
        JFileChooser jfc = new JFileChooser("/Users/ham/My_Study");
        int cmd = jfc.showSaveDialog(this);
        if(cmd == JFileChooser.APPROVE_OPTION) {
            selectedFile = jfc.getSelectedFile();
            saveFile();
        }
    }//GEN-LAST:event_jMenu6ActionPerformed

    
    private void saveFile() {
        try {
            bos = new BufferedOutputStream(new FileOutputStream(selectedFile));
            //JTextArea에 있는 모든 문자열들을 가져와서 파일에 쓰기 한다.
            byte[] data = jTextArea1.getText().getBytes();
            bos.write(data, 0, data.length);
            bos.flush();
            old_data = jTextArea1.getText();
        } catch(Exception e){
        }
    }
    
    private void readFile() {
        // 현재영역에 왔을 때는 이미 사용자가 선택한 파일이 있다.
        // 그것이 멤버변수인 selectedFile에 담겨진 상태다
        try {
            bis = new BufferedInputStream(new FileInputStream(selectedFile));
            // bis는 결국 선택된 파일과 연결된 것이다.
            byte[] buf = new byte[2048];
            int size = -1;
            jTextArea1.setText(""); // 청소!
            while((size = bis.read(buf)) != -1){
                // 읽은 자원들을 문자열로 만들어서 jTextArea1에 표현한다
                String str = new String(buf, 0, size);
                jTextArea1.append(str);
            } // 반복문의 끝
            old_data = jTextArea1.getText();
            jTextArea1.setCaretPosition(0);
            this.setTitle(selectedFile.getAbsolutePath());
        } catch (Exception e) {
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

    private void closed() {
        // 종료 전에 처리해야 할 일있다면 여기서 기술합니다.
        if(!old_data.equals(jTextArea1.getText())) {
            int cmd = JOptionPane.showConfirmDialog(this, "저장하시겠습니까?", "잠깐", JOptionPane.YES_NO_OPTION);
        }
        try {
            if(bis != null)
                bis.close();
            if(bos != null)
                bos.close();
        } catch (Exception e) {
            
        }
        System.exit(0);
    }
    
}