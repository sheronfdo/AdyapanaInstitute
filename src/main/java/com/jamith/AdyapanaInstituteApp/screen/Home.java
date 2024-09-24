/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jamith.AdyapanaInstituteApp.screen;

import javax.swing.*;

/**
 *
 * @author Dell
 */
public class Home extends javax.swing.JPanel {
   JFrame mainFrame;
    JPanel studentPanel = new Student();
    JPanel teacherPanel = new Teacher();
    JPanel subjectPanel = new Subject();
    JPanel classPanel = new com.jamith.AdyapanaInstituteApp.screen.Class();
    JPanel paymentPanel = new Payment();


    /**
     * Creates new form Home
     */
    public Home(JFrame mainFrame) {
         this.mainFrame = mainFrame;
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

        jLabel1 = new javax.swing.JLabel();
        studentBTN = new javax.swing.JButton();
        teacherBTN = new javax.swing.JButton();
        subjectBTN = new javax.swing.JButton();
        classBTN = new javax.swing.JButton();
        paymentBTN = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(32767, 688));
        setPreferredSize(new java.awt.Dimension(1125, 688));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Adyapana Institute");

        studentBTN.setText("Student Manage");
        studentBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentBTNActionPerformed(evt);
            }
        });

        teacherBTN.setText("Teacher Manage");
        teacherBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teacherBTNActionPerformed(evt);
            }
        });

        subjectBTN.setText("Subject Manage");
        subjectBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectBTNActionPerformed(evt);
            }
        });

        classBTN.setText("Class Manage");
        classBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classBTNActionPerformed(evt);
            }
        });

        paymentBTN.setText("Payment Manage");
        paymentBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(358, 358, 358)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(449, 449, 449)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(teacherBTN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(studentBTN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(subjectBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(classBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(paymentBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 383, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jLabel1)
                .addGap(99, 99, 99)
                .addComponent(studentBTN)
                .addGap(27, 27, 27)
                .addComponent(teacherBTN)
                .addGap(27, 27, 27)
                .addComponent(subjectBTN)
                .addGap(27, 27, 27)
                .addComponent(classBTN)
                .addGap(28, 28, 28)
                .addComponent(paymentBTN)
                .addContainerGap(218, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void studentBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentBTNActionPerformed
        mainFrame.setContentPane(studentPanel);
        mainFrame.setVisible(true);
    }//GEN-LAST:event_studentBTNActionPerformed

    private void teacherBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teacherBTNActionPerformed
        mainFrame.setContentPane(teacherPanel);
        mainFrame.setVisible(true);
    }//GEN-LAST:event_teacherBTNActionPerformed

    private void subjectBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectBTNActionPerformed
        mainFrame.setContentPane(subjectPanel);
        mainFrame.setVisible(true);
    }//GEN-LAST:event_subjectBTNActionPerformed

    private void classBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classBTNActionPerformed
        mainFrame.setContentPane(classPanel);
        mainFrame.setVisible(true);
    }//GEN-LAST:event_classBTNActionPerformed

    private void paymentBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentBTNActionPerformed
        mainFrame.setContentPane(paymentPanel);
        mainFrame.setVisible(true);
    }//GEN-LAST:event_paymentBTNActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton classBTN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton paymentBTN;
    private javax.swing.JButton studentBTN;
    private javax.swing.JButton subjectBTN;
    private javax.swing.JButton teacherBTN;
    // End of variables declaration//GEN-END:variables
}
