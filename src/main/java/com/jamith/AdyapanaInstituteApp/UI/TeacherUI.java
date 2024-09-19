package com.jamith.AdyapanaInstituteApp.UI;

import javax.swing.*;
import java.awt.*;

public class TeacherUI {
    public static JPanel getTeacherPanel() {
        JPanel teacherPanel = new JPanel();
        teacherPanel.setLayout(new GridLayout(6, 2, 5, 5));

        JLabel tnoLabel = new JLabel("Teacher No:");
        JTextField tnoField = new JTextField();
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        JLabel addressLabel = new JLabel("Address:");
        JTextField addressField = new JTextField();
        JLabel subjectsLabel = new JLabel("Subjects:");
        JTextField subjectsField = new JTextField();

        JButton addButton = new JButton("Add");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");
        JButton searchButton = new JButton("Search");

        teacherPanel.add(tnoLabel);
        teacherPanel.add(tnoField);
        teacherPanel.add(nameLabel);
        teacherPanel.add(nameField);
        teacherPanel.add(addressLabel);
        teacherPanel.add(addressField);
        teacherPanel.add(subjectsLabel);
        teacherPanel.add(subjectsField);
        teacherPanel.add(addButton);
        teacherPanel.add(updateButton);
        teacherPanel.add(deleteButton);
        teacherPanel.add(searchButton);

        // Implement Action Listeners to Call CRUD Operations
        addButton.addActionListener(e -> {
            // Call TeacherOperations.addTeacher() with appropriate data
        });

        updateButton.addActionListener(e -> {
            // Call TeacherOperations.updateTeacher() with appropriate data
        });

        deleteButton.addActionListener(e -> {
            // Call TeacherOperations.deleteTeacher() with appropriate data
        });

        searchButton.addActionListener(e -> {
            // Call TeacherOperations.searchTeacher() with appropriate data
        });

        return teacherPanel;
    }
}
