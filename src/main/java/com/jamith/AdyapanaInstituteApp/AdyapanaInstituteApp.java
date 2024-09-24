package com.jamith.AdyapanaInstituteApp;

import com.jamith.AdyapanaInstituteApp.screen.*;
import com.jamith.AdyapanaInstituteApp.screen.Class;

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
        JPanel home = new Home(mainFrame);
        JPanel studentPanel = new Student();
        JPanel teacherPanel = new Teacher();
        JPanel subjectPanel = new Subject();
        JPanel classPanel = new Class();
        JPanel paymentPanel = new Payment();
        mainFrame.setContentPane(home);
        // Add ActionListeners for Menu Navigation
        studentMenu.addActionListener(e -> {
            mainFrame.setContentPane(studentPanel);
            mainFrame.setVisible(true);
        });
        teacherMenu.addActionListener(e -> {
            mainFrame.setContentPane(teacherPanel);
            mainFrame.setVisible(true);
        });
        subjectMenu.addActionListener(e -> {
            mainFrame.setContentPane(subjectPanel);
            mainFrame.setVisible(true);
        });
        classMenu.addActionListener(e -> {
            mainFrame.setContentPane(classPanel);
            mainFrame.setVisible(true);
        });
        paymentMenu.addActionListener(e -> {
            mainFrame.setContentPane(paymentPanel);
            mainFrame.setVisible(true);
        });

        mainFrame.setVisible(true);
    }
}
