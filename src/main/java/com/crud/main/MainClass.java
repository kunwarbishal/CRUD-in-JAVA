package com.crud.main;

import com.crud.model.Student;
import com.crud.services.DatabaseService;

import java.sql.SQLException;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {

        DatabaseService dbService = new DatabaseService();// object of database service to use service
        try (Scanner scanner = new Scanner(System.in)) {
            boolean isRunning = true;
            while (isRunning) {
                System.out.println("Enter Choice");
                System.out.println("1.Insert student");
                System.out.println("2.Select all student");
                System.out.println("3.Select student by ID");
                System.out.println("4.Delete student");
                System.out.println("5.Update student");
                System.out.println("6.Exit");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {

                    case 1:
                        System.out.println("Enter student's Name :: Age :: Address to insert record.");
                        Student student = new Student(scanner.nextLine(), Integer.parseInt(scanner.nextLine()), scanner.nextLine());
                        dbService.insertStudent(student);
                        break;
                    case 2:
                        dbService.getAllStudent();
                        break;
                    case 3:
                        System.out.println("Enter id of student to view info.");
                        DatabaseService.getStudentById(Integer.parseInt(scanner.nextLine()));
                        break;
                    case 4:
                        System.out.println("Enter id of student to delete record.");
                        DatabaseService.deleteStudent(Integer.parseInt(scanner.nextLine()));
                        break;
                    case 5:
                        System.out.println("Enter id of student to update info of student.");
                        int updateId = Integer.parseInt(scanner.nextLine());
                        boolean isFound = DatabaseService.getStudentById(updateId);
                        if (isFound) {
                            System.out.println("Enter student's Name :: Age :: Address to update record.");
                            Student student1 = new Student(updateId, scanner.nextLine(), Integer.parseInt(scanner.nextLine()), scanner.nextLine());
                            DatabaseService.updateStudent(student1);
                        }
                        break;
                    case 6:     //exit
                        isRunning = false;
                        break;
                    default:
                        System.out.println("please choose any operation");
                        break;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Something went wrong :( " + e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
