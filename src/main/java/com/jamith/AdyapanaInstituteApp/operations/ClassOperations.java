package com.jamith.AdyapanaInstituteApp.operations;

import com.jamith.AdyapanaInstituteApp.database.DatabaseConnection;

import javax.swing.*;
import java.sql.*;

public class ClassOperations {
    private Connection conn;

    public ClassOperations() {
        try {
            conn = DatabaseConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addClass(int subNo, int tNo, String timeslot) {
        String query = "INSERT INTO Class (SubNo, Tno, Timeslot) VALUES (?, ?, ?)";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, subNo);
            statement.setInt(2, tNo);
            statement.setString(3, timeslot);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to update an existing class
    public void updateClass(int classNo, int subNo, int tNo, String timeslot) {
        String query = "UPDATE Class SET SubNo = ?, Tno = ?, Timeslot = ? WHERE ClassNo = ?";
        try {

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, subNo);
            statement.setInt(2, tNo);
            statement.setString(3, timeslot);
            statement.setInt(4, classNo);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to delete a class
    public void deleteClass(int classNo) {
        String query = "DELETE FROM Class WHERE ClassNo = ?";
        try {

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, classNo);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve all classes
    public ResultSet getAllClasses() {
        String query = "SELECT * FROM Class";
        try {
            Statement statement = conn.createStatement();
            return statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to search classes by timeslot
    public ResultSet searchClassByTimeslot(String timeslot) {
        String query = "SELECT * FROM Class WHERE Timeslot LIKE ?";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, "%" + timeslot + "%");
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
