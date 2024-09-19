package com.jamith.AdyapanaInstituteApp.UI;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class StudentUI {
    public static JPanel getStudentPanel() {
        JPanel studentPanel = new JPanel();
        studentPanel.setLayout(new BorderLayout());

        // Top Panel - Input Fields and Buttons
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        JLabel snoLabel = new JLabel("Student No:");
        JTextField snoField = new JTextField();
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        JLabel addressLabel = new JLabel("Address:");
        JTextField addressField = new JTextField();
        JLabel dobLabel = new JLabel("DOB:");
        JTextField dobField = new JTextField();

        JButton addButton = new JButton("Add");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");
        JButton searchButton = new JButton("Search");

        inputPanel.add(snoLabel);
        inputPanel.add(snoField);
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(addressLabel);
        inputPanel.add(addressField);
        inputPanel.add(dobLabel);
        inputPanel.add(dobField);
        inputPanel.add(addButton);
        inputPanel.add(updateButton);
        inputPanel.add(deleteButton);
        inputPanel.add(searchButton);

        // Table for displaying Students
        String[] columnNames = {"Student No", "Name", "Address", "DOB"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable studentTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(studentTable);

        // Add components to the panel
        studentPanel.add(inputPanel, BorderLayout.NORTH);
        studentPanel.add(scrollPane, BorderLayout.CENTER);

        // Action Listeners for Buttons
        addButton.addActionListener(e -> {
            // Call StudentOperations.addStudent() and update table
        });

        updateButton.addActionListener(e -> {
            // Call StudentOperations.updateStudent() and update table
        });

        deleteButton.addActionListener(e -> {
            // Call StudentOperations.deleteStudent() and update table
        });

        searchButton.addActionListener(e -> {
            // Call StudentOperations.searchStudent() and display result in table
        });

        return studentPanel;
    }
}
