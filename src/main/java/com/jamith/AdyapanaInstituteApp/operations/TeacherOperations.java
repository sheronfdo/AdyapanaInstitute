package com.jamith.AdyapanaInstituteApp.operations;

import com.jamith.AdyapanaInstituteApp.database.DatabaseConnection;

import javax.swing.*;
import java.sql.*;

public class TeacherOperations {
    private Connection conn;

    public TeacherOperations() {
        try {
            conn = DatabaseConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Add Teacher
    public void addTeacher(String name, String address, String subjects) {
        try {
            String query = "INSERT INTO Teacher (Name, Address, Subjects) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setString(2, address);
            pstmt.setString(3, subjects);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Teacher Added Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Search Teacher
    public ResultSet searchTeacher(String name) {
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM Teacher WHERE Name LIKE ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "%" + name + "%");
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    // Update Teacher
    public void updateTeacher(int tno, String name, String address, String subjects) {
        try {
            String query = "UPDATE Teacher SET Name = ?, Address = ?, Subjects = ? WHERE Tno = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setString(2, address);
            pstmt.setString(3, subjects);
            pstmt.setInt(4, tno);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Teacher Updated Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete Teacher
    public void deleteTeacher(int tno) {
        try {
            String query = "DELETE FROM Teacher WHERE Tno = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, tno);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Teacher Deleted Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getAllTeachers() {
        ResultSet resultSet = null;
        try {
            Statement statement = DatabaseConnection.getConnection().createStatement();
            String query = "SELECT Tno, Name, Address, Subjects FROM Teacher";
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }
}
