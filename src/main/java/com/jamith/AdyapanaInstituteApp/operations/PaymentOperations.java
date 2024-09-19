package com.jamith.AdyapanaInstituteApp.operations;

import com.jamith.AdyapanaInstituteApp.database.DatabaseConnection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentOperations {
    private Connection conn;

    public PaymentOperations() {
        try {
            conn = DatabaseConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Add Payment
    public void addPayment(int sno, int tno, int subno, String month, double value) {
        try {
            String query = "INSERT INTO Invoice (Sno, Tno, Subno, Month, Value) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, sno);
            pstmt.setInt(2, tno);
            pstmt.setInt(3, subno);
            pstmt.setString(4, month);
            pstmt.setDouble(5, value);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Payment Added Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Search Due List by Class
    public ResultSet searchDueListByClass(int classNo) {
        ResultSet rs = null;
        try {
            String query = "SELECT s.Name, c.Timeslot, i.Month, i.Value FROM Invoice i " +
                           "JOIN Student s ON i.Sno = s.Sno " +
                           "JOIN Class c ON i.Subno = c.Subno WHERE c.ClassNo = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, classNo);
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    // Generate Invoice
    public ResultSet generateInvoice(int sno, int subno) {
        ResultSet rs = null;
        try {
            String query = "SELECT i.Value, s.Name FROM Invoice i " +
                           "JOIN Student s ON i.Sno = s.Sno WHERE i.Sno = ? AND i.Subno = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, sno);
            pstmt.setInt(2, subno);
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
