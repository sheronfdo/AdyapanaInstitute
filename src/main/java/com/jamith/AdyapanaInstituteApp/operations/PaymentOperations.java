package com.jamith.AdyapanaInstituteApp.operations;


import com.jamith.AdyapanaInstituteApp.database.DatabaseConnection;

import javax.swing.*;
import java.sql.*;

public class PaymentOperations {
    private Connection conn;

    public PaymentOperations() {
        try {
            conn = DatabaseConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Method to add a new payment
    public void addPayment(int sno, int tno, int subno, String month, double value) {
        String query = "INSERT INTO Invoice (Sno, Tno, Subno, Month, Value) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, sno);
            statement.setInt(2, tno);
            statement.setInt(3, subno);
            statement.setString(4, month);
            statement.setDouble(5, value);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Method to update an existing payment
    public void updatePayment(int invoiceNo, int sno, int tno, int subno, String month, double value) {
        String query = "UPDATE Invoice SET Sno = ?, Tno = ?, Subno = ?, Month = ?, Value = ? WHERE InvoiceNo = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, sno);
            statement.setInt(2, tno);
            statement.setInt(3, subno);
            statement.setString(4, month);
            statement.setDouble(5, value);
            statement.setInt(6, invoiceNo);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to delete a payment
    public void deletePayment(int invoiceNo) {
        String query = "DELETE FROM Invoice WHERE InvoiceNo = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, invoiceNo);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve all payments
    public ResultSet getAllPayments() {
        String query = "SELECT * FROM Invoice";
        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            return statement.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to search payments by student name
    public ResultSet searchPaymentByStudentName(String studentName) {
        String query = "SELECT i.* FROM Invoice i JOIN Student s ON i.Sno = s.Sno WHERE s.Name LIKE ?";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "%" + studentName + "%");
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
