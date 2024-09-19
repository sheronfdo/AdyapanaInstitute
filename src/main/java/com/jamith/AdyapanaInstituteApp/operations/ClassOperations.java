package com.jamith.AdyapanaInstituteApp.operations;

import com.jamith.AdyapanaInstituteApp.database.DatabaseConnection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClassOperations {
    private Connection conn;

    public ClassOperations() {
        try {
            conn = DatabaseConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Add Class
    public void addClass(int subno, int tno, String timeslot) {
        try {
            String query = "INSERT INTO Class (Subno, Tno, Timeslot) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, subno);
            pstmt.setInt(2, tno);
            pstmt.setString(3, timeslot);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Class Added Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Search Class by Subject
    public ResultSet searchClassBySubject(int subno) {
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM Class WHERE Subno = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, subno);
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
