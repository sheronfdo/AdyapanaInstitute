package com.jamith.AdyapanaInstituteApp.operations;

import com.jamith.AdyapanaInstituteApp.database.DatabaseConnection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SubjectOperations {
    private Connection conn;

    public SubjectOperations() {
        try {
            conn = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Add Subject
    public void addSubject(String description, double price) {
        try {
            String query = "INSERT INTO Subject (Description, Price) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, description);
            pstmt.setDouble(2, price);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Subject Added Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Search Subject
    public ResultSet searchSubject(String description) {
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM Subject WHERE Description LIKE ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "%" + description + "%");
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    // Update Subject
    public void updateSubject(int subno, String description, double price) {
        try {
            String query = "UPDATE Subject SET Description = ?, Price = ? WHERE Subno = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, description);
            pstmt.setDouble(2, price);
            pstmt.setInt(3, subno);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Subject Updated Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete Subject
    public void deleteSubject(int subno) {
        try {
            String query = "DELETE FROM Subject WHERE Subno = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, subno);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Subject Deleted Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
