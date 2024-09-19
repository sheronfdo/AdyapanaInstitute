package com.jamith.AdyapanaInstituteApp.UI;

import com.jamith.AdyapanaInstituteApp.operations.StudentOperations;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StudentUI extends JPanel {
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    private JTextField snoField, nameField, addressField, dobField;
    private JTable studentTable;
    private DefaultTableModel model;

    public StudentUI() {
        setLayout(new BorderLayout());

        // Create input fields
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        JLabel snoLabel = new JLabel("Student No (Auto-generated):");
        snoField = new JTextField();
        snoField.setEditable(false); // Student No is auto-generated
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        JLabel addressLabel = new JLabel("Address:");
        addressField = new JTextField();
        JLabel dobLabel = new JLabel("Date of Birth:");
        dobField = new JTextField();

        JButton addButton = new JButton("Add Student");
        JButton updateButton = new JButton("Update Student");
        JButton deleteButton = new JButton("Delete Student");
        JButton searchButton = new JButton("Search by Name");

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

        // Create table for displaying student data
        String[] columnNames = {"Student No", "Name", "Address", "Date of Birth"};
        model = new DefaultTableModel(columnNames, 0);
        studentTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(studentTable);

        // Add components to the main panel
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Action Listeners
        addButton.addActionListener(e -> {
            String name = nameField.getText();
            String address = addressField.getText();
            String dob = dobField.getText();

            if (name.isEmpty() || address.isEmpty() || dob.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Add the student to the database
                try {
                    new StudentOperations().addStudent(name, address, formatter.parse(dob));
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
                refreshStudentTable();
                clearFields();
                JOptionPane.showMessageDialog(this, "Student added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        updateButton.addActionListener(e -> {
            int selectedRow = studentTable.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Please select a student from the table to update", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Get student ID from the selected row
                int studentId = (int) model.getValueAt(selectedRow, 0); // Assuming first column is student ID
                String name = nameField.getText();
                String address = addressField.getText();
                String dob = dobField.getText();

                if (name.isEmpty() || address.isEmpty() || dob.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Update the student in the database
                    try {
                        new StudentOperations().updateStudent(studentId, name, address, formatter.parse(dob));
                    } catch (ParseException ex) {
                        throw new RuntimeException(ex);
                    }
                    refreshStudentTable();
                    clearFields();
                    JOptionPane.showMessageDialog(this, "Student updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        deleteButton.addActionListener(e -> {
            int selectedRow = studentTable.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Please select a student from the table to delete", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Get student ID from the selected row
                int studentId = (int) model.getValueAt(selectedRow, 0); // Assuming first column is student ID
                int confirmation = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this student?", "Delete Confirmation", JOptionPane.YES_NO_OPTION);
                if (confirmation == JOptionPane.YES_OPTION) {
                    // Delete the student from the database
                    new StudentOperations().deleteStudent(studentId);
                    refreshStudentTable();
                    clearFields();
                    JOptionPane.showMessageDialog(this, "Student deleted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        searchButton.addActionListener(e -> {
            String searchText = nameField.getText(); // Using name as search criteria here
            if (searchText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a name to search", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Perform search and update the table with the results
                DefaultTableModel searchModel = new DefaultTableModel();
                ResultSet resultSet = new StudentOperations().searchStudent(searchText);
                try {
                    while (resultSet.next()) {
                        int sno = resultSet.getInt("Sno");
                        String name = resultSet.getString("Name");
                        String address = resultSet.getString("Address");
                        String dob = resultSet.getString("dob");

                        // Add the row to the table model
                        searchModel.addRow(new Object[]{sno, name, address, dob});
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                studentTable.setModel(searchModel);
            }
        });

        // Table selection listener to populate fields when a row is selected
        studentTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting() && studentTable.getSelectedRow() != -1) {
                    int selectedRow = studentTable.getSelectedRow();
                    snoField.setText(model.getValueAt(selectedRow, 0).toString()); // Student ID (auto-generated)
                    nameField.setText(model.getValueAt(selectedRow, 1).toString());
                    addressField.setText(model.getValueAt(selectedRow, 2).toString());
                    dobField.setText(model.getValueAt(selectedRow, 3).toString());
                }
            }
        });

        // Initial load of student data
        refreshStudentTable();
    }

    // Utility method to refresh the student table with the latest data from the database
    private void refreshStudentTable() {
        model.setRowCount(0);
        DefaultTableModel updatedModel = new DefaultTableModel();
        ResultSet resultSet = new StudentOperations().getAllStudents();
        try {
            while (resultSet.next()) {
                int sno = resultSet.getInt("Sno");
                String name = resultSet.getString("Name");
                String address = resultSet.getString("Address");
                String dob = resultSet.getString("dob");
                updatedModel.addRow(new Object[]{sno, name, address, dob});
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        studentTable.setModel(updatedModel);
    }

    private void clearFields() {
        snoField.setText("");
        nameField.setText("");
        addressField.setText("");
        dobField.setText("");
    }
}
