package com.jamith.AdyapanaInstituteApp.operations;

import com.jamith.AdyapanaInstituteApp.database.DatabaseConnection;

import java.sql.*;
import javax.swing.JOptionPane;

public class StudentOperations {
    private Connection conn;

    public StudentOperations() {
        try {
            conn = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Add Student
    public void addStudent(String name, String address, Date dob) {
        try {
            String query = "INSERT INTO Student (Name, Address, dob) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setString(2, address);
            pstmt.setDate(3, new java.sql.Date(dob.getTime()));
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Student Added Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Search Student
    public ResultSet searchStudent(String name) {
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM Student WHERE Name LIKE ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "%" + name + "%");
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    // Update Student
    public void updateStudent(int sno, String name, String address, Date dob) {
        try {
            String query = "UPDATE Student SET Name = ?, Address = ?, dob = ? WHERE Sno = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setString(2, address);
            pstmt.setDate(3, new java.sql.Date(dob.getTime()));
            pstmt.setInt(4, sno);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Student Updated Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete Student
    public void deleteStudent(int sno) {
        try {
            String query = "DELETE FROM Student WHERE Sno = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, sno);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Student Deleted Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
