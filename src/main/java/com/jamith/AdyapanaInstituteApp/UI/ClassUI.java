package com.jamith.AdyapanaInstituteApp.UI;

import javax.swing.*;
import java.awt.*;

public class ClassUI {
    public static JPanel getClassPanel() {
        JPanel classPanel = new JPanel();
        classPanel.setLayout(new GridLayout(5, 2, 5, 5));

        JLabel classnoLabel = new JLabel("Class No:");
        JTextField classnoField = new JTextField();
        JLabel subnoLabel = new JLabel("Subject No:");
        JTextField subnoField = new JTextField();
        JLabel tnoLabel = new JLabel("Teacher No:");
        JTextField tnoField = new JTextField();
        JLabel timeslotLabel = new JLabel("Timeslot:");
        JTextField timeslotField = new JTextField();

        JButton registerButton = new JButton("Register Class");
        JButton searchButton = new JButton("Search");

        classPanel.add(classnoLabel);
        classPanel.add(classnoField);
        classPanel.add(subnoLabel);
        classPanel.add(subnoField);
        classPanel.add(tnoLabel);
        classPanel.add(tnoField);
        classPanel.add(timeslotLabel);
        classPanel.add(timeslotField);
        classPanel.add(registerButton);
        classPanel.add(searchButton);

        // Implement Action Listeners to Call Class Operations
        registerButton.addActionListener(e -> {
            // Call ClassOperations.addClass() with appropriate data
        });

        searchButton.addActionListener(e -> {
            // Call ClassOperations.searchClassBySubject() with appropriate data
        });

        return classPanel;
    }
}
