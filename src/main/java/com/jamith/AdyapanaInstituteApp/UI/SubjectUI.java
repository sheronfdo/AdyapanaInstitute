package com.jamith.AdyapanaInstituteApp.UI;

import javax.swing.*;
import java.awt.*;

public class SubjectUI {
    public static JPanel getSubjectPanel() {
        JPanel subjectPanel = new JPanel();
        subjectPanel.setLayout(new GridLayout(5, 2, 5, 5));

        JLabel subnoLabel = new JLabel("Subject No:");
        JTextField subnoField = new JTextField();
        JLabel descriptionLabel = new JLabel("Description:");
        JTextField descriptionField = new JTextField();
        JLabel priceLabel = new JLabel("Price:");
        JTextField priceField = new JTextField();

        JButton addButton = new JButton("Add");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");
        JButton searchButton = new JButton("Search");

        subjectPanel.add(subnoLabel);
        subjectPanel.add(subnoField);
        subjectPanel.add(descriptionLabel);
        subjectPanel.add(descriptionField);
        subjectPanel.add(priceLabel);
        subjectPanel.add(priceField);
        subjectPanel.add(addButton);
        subjectPanel.add(updateButton);
        subjectPanel.add(deleteButton);
        subjectPanel.add(searchButton);

        // Implement Action Listeners to Call CRUD Operations
        addButton.addActionListener(e -> {
            // Call SubjectOperations.addSubject() with appropriate data
        });

        updateButton.addActionListener(e -> {
            // Call SubjectOperations.updateSubject() with appropriate data
        });

        deleteButton.addActionListener(e -> {
            // Call SubjectOperations.deleteSubject() with appropriate data
        });

        searchButton.addActionListener(e -> {
            // Call SubjectOperations.searchSubject() with appropriate data
        });

        return subjectPanel;
    }
}
