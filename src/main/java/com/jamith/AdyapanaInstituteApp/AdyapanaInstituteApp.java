package com.jamith.AdyapanaInstituteApp;

import com.jamith.AdyapanaInstituteApp.UI.*;
import com.jamith.AdyapanaInstituteApp.screen.Class;
import com.jamith.AdyapanaInstituteApp.screen.Home;
import com.jamith.AdyapanaInstituteApp.screen.Student;
import com.jamith.AdyapanaInstituteApp.screen.Subject;
import com.jamith.AdyapanaInstituteApp.screen.Teacher;

import javax.swing.*;
import java.awt.*;

public class AdyapanaInstituteApp {
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Adyapana Institute Management System");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1150, 760);
        mainFrame.setLayout(new BorderLayout());

        // Menu for Navigation
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Manage");
        JMenuItem studentMenu = new JMenuItem("Students");
        JMenuItem teacherMenu = new JMenuItem("Teachers");
        JMenuItem subjectMenu = new JMenuItem("Subjects");
        JMenuItem classMenu = new JMenuItem("Classes");
        JMenuItem paymentMenu = new JMenuItem("Payments");

        menu.add(studentMenu);
        menu.add(teacherMenu);
        menu.add(subjectMenu);
        menu.add(classMenu);
        menu.add(paymentMenu);
        menuBar.add(menu);

        mainFrame.setJMenuBar(menuBar);

        // Panels
        JPanel home = new Home();
        JPanel studentPanel = new Student();
        JPanel teacherPanel = new Teacher();
        JPanel subjectPanel = new Subject();
        JPanel classPanel = new Class();
        JPanel paymentPanel = PaymentUI.getPaymentPanel();
        mainFrame.setContentPane(home);
        // Add ActionListeners for Menu Navigation
        studentMenu.addActionListener(e -> mainFrame.setContentPane(studentPanel));
        teacherMenu.addActionListener(e -> mainFrame.setContentPane(teacherPanel));
        subjectMenu.addActionListener(e -> mainFrame.setContentPane(subjectPanel));
        classMenu.addActionListener(e -> mainFrame.setContentPane(classPanel));
        paymentMenu.addActionListener(e -> mainFrame.setContentPane(paymentPanel));

        mainFrame.setVisible(true);
    }
}
