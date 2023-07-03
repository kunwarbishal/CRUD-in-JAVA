package com.crud.services;

import com.crud.database.DatabaseConnection;
import com.crud.database.QueryUtils;
import com.crud.model.Student;

import java.sql.*;
//this includes some crud services
public class CrudService {
    public static  void insertStudent(Student student) throws SQLException {

        try (Connection connection = DatabaseConnection.getConnection()) //auto closes the connection after try block
        {
            PreparedStatement preparedStatement = connection.prepareStatement(QueryUtils.insertStudentQuery());
            preparedStatement.setString(1, student.getStudentName());
            preparedStatement.setInt(2, student.getStudentAge());
            preparedStatement.setString(3, student.getStudentAddress());
            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println("Student inserted successfully :)");
            } else {
                System.out.println("Failed to insert student :(");
            }
        }
    } //end of insert method

    public static void getAllStudent() throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(QueryUtils.selectAllStudentQuery())) {
            while (resultSet.next()) {
                printStudentInfo(new Student(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("age"), resultSet.getString("address")));
            }

        }
    }//end of getAllStudent

    private static void printStudentInfo(Student student) {
        System.out.println("________________________________________________");
        System.out.println("Student id: " + student.getStudentId());
        System.out.println("Student Name: " + student.getStudentName());
        System.out.println("Student Age: " + student.getStudentAge());
        System.out.println("Student Address: " + student.getStudentAddress());
        System.out.println("________________________________________________");
    }//end of printStudentInfo

    //getStudentById start
    public static boolean getStudentById(int id) throws SQLException {
        boolean isFound = false;
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(QueryUtils.getStudentByIdQuery(id))) {
            if (resultSet.next()) {
                isFound = true;
                printStudentInfo(new Student(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("age"), resultSet.getString("address")));
            } else {
                System.out.println("Record not found for id: " + id);
            }
        }
        return isFound;
    }//getStudentById end

    //delete student start
    public static void deleteStudent(int id) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {
            int rows = statement.executeUpdate(QueryUtils.deleteStudentQuery(id));
            if (rows > 0) {
                System.out.println("Student Record Deleted Successfully");
            } else {
                System.out.println("Something goes wrong");
            }
        }
    }//deleteStudent end

    //updateStudent start
    public static void updateStudent(Student student) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(QueryUtils.updateStudentQuery(student.getStudentId()))) {
            preparedStatement.setString(1, student.getStudentName());
            preparedStatement.setInt(2, student.getStudentAge());
            preparedStatement.setString(3, student.getStudentAddress());
            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println("Record updated successfully :)");
            } else {
                System.out.println("Failed to update record :(");
            }

        }
    }//end of updateStudent

}
