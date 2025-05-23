/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.sist.ex1;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author ham
 */
public class ObjectTest extends javax.swing.JFrame {

    ArrayList<OvalVO> list;
    private File f;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    
    public ObjectTest() {
        initComponents(); // ghkaus elwkdls
        list = new ArrayList<>();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        center_p = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Image buf = createImage(this.getWidth(), this.getHeight());
                Graphics buf_g = buf.getGraphics();
                for(OvalVO ov : list){
                    buf_g.setColor(ov.c);
                    buf_g.fillOval(ov.getX()-ov.getWH()/2, ov.getY()-ov.getWH()/2, ov.getWH(), ov.getWH());
                }
                g.drawImage(buf, 0, 0, this);
            }
        };
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(650, 500));

        center_p.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                center_pMousePressed(evt);
            }
        });
        center_p.setLayout(new java.awt.BorderLayout());
        getContentPane().add(center_p, java.awt.BorderLayout.CENTER);

        jMenu1.setText("File");

        jMenuItem1.setText("Open");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Save");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);
        jMenu1.add(jSeparator1);

        jMenuItem3.setText("jMenuItem3");
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void center_pMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_center_pMousePressed
        // center_p에서 클릭할 때마다 호출되는 곳
        int x = evt.getX();
        int y = evt.getY();
        OvalVO ov = new OvalVO (x, y);
        
        // 생성된 Oval객체를 list에 저장!
        list.add(ov);
        center_p.repaint(); //   --> update --> paintComponent호
    }//GEN-LAST:event_center_pMousePressed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // 파일 선택기 생성
        JFileChooser jfc = new JFileChooser("/Users/ham/My_Study");
        int cmd = jfc.showSaveDialog(this);
        if(cmd == JFileChooser.APPROVE_OPTION){
            // 저장을 원하는 경우이므로 사용자가 선택한 파일을 얻어낸다.
            f = jfc.getSelectedFile();
            
            saveFile();
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // 열기 기능
        JFileChooser jfc = new JFileChooser("/Users/ham/My_Study");
        int cmd = jfc.showOpenDialog(this);
        if(cmd == JFileChooser.APPROVE_OPTION) {
            f = jfc.getSelectedFile();
            openFile();
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void openFile() {
        try{
            ois = new ObjectInputStream(new FileInputStream(f));
            Object obj = ois.readObject();
            if(obj instanceof ArrayList) {
                list = (ArrayList<OvalVO>) obj;
                this.setTitle(f.getAbsolutePath());
                center_p.repaint(); 
            }
        } catch(Exception e) {
            
        }
    }
    
    private void saveFile() {
        try{
            oos = new ObjectOutputStream(new FileOutputStream(f));
            oos.writeObject(list);
            oos.flush();
            JOptionPane.showMessageDialog(this, "저장완료!");
            this.setTitle(f.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
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
            java.util.logging.Logger.getLogger(ObjectTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ObjectTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ObjectTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ObjectTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ObjectTest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel center_p;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
