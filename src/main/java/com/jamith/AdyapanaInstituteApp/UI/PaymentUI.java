package com.jamith.AdyapanaInstituteApp.UI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PaymentUI {
    public static JPanel getPaymentPanel() {
        JPanel paymentPanel = new JPanel();
        paymentPanel.setLayout(new BorderLayout());

        // Top Panel - Input Fields and Buttons
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        JLabel snoLabel = new JLabel("Student No:");
        JTextField snoField = new JTextField();
        JLabel tnoLabel = new JLabel("Teacher No:");
        JTextField tnoField = new JTextField();
        JLabel subnoLabel = new JLabel("Subject No:");
        JTextField subnoField = new JTextField();
        JLabel monthLabel = new JLabel("Month:");
        JTextField monthField = new JTextField();
        JLabel valueLabel = new JLabel("Value:");
        JTextField valueField = new JTextField();

        JButton addButton = new JButton("Add Payment");
        JButton searchButton = new JButton("Search Due List");

        inputPanel.add(snoLabel);
        inputPanel.add(snoField);
        inputPanel.add(tnoLabel);
        inputPanel.add(tnoField);
        inputPanel.add(subnoLabel);
        inputPanel.add(subnoField);
        inputPanel.add(monthLabel);
        inputPanel.add(monthField);
        inputPanel.add(valueLabel);
        inputPanel.add(valueField);
        inputPanel.add(addButton);
        inputPanel.add(searchButton);

        // Table for displaying Payments
        String[] columnNames = {"Student No", "Teacher No", "Subject No", "Month", "Value"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable paymentTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(paymentTable);

        // Add components to the panel
        paymentPanel.add(inputPanel, BorderLayout.NORTH);
        paymentPanel.add(scrollPane, BorderLayout.CENTER);

        // Action Listeners for Buttons
        addButton.addActionListener(e -> {
            // Call PaymentOperations.addPayment() and update table
        });

        searchButton.addActionListener(e -> {
            // Call PaymentOperations.searchDueList() and display result in table
        });

        return paymentPanel;
    }
}
