package com.crud.menu;

import com.crud.model.Student;
import com.crud.services.CrudService;
import com.crud.services.ScrollableService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
// this is the menu for the program
public class ProgramMenu {
    public static void startMenu() throws SQLException {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Choose an option to get following services :-");
            System.out.println("1. Scrollable ResultSet Service");
            System.out.println("2. CRUD Service\t\t3. Exit");

            int startMenuChoice = Integer.parseInt(scanner.nextLine());
            switch (startMenuChoice) {
                case 1:
                    scrollableMenu();
                case 2:
                    crudMenu();
                case 3:
                    System.out.println("Exited Successfully ! ");
                    break;
                default:
                    System.out.println("Invalid choice :(");

            }
        }
    }

    public static void crudMenu() throws SQLException {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean isRunning = true;
            while (isRunning) {
                System.out.println("Select an operation (CRUD)");
                System.out.println("1.Insert student\t\t2.Select all student");
                System.out.println("3.Select student by ID\t4.Delete student");
                System.out.println("5.Update student\t\t6.Back to Start menu");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> {     //insertStudent
                        System.out.println("Enter student's Name :: Age :: Address to insert record");
                        Student student = new Student(scanner.nextLine(), Integer.parseInt(scanner.nextLine()), scanner.nextLine());
                        CrudService.insertStudent(student);
                    }
                    case 2 ->     //getAllStudent
                            CrudService.getAllStudent();
                    case 3 -> {     //getStudentById
                        System.out.println("Enter id of student to view info");
                        CrudService.getStudentById(Integer.parseInt(scanner.nextLine()));
                    }
                    case 4 -> {     // delete student
                        System.out.println("Enter id of student to delete record");
                        CrudService.deleteStudent(Integer.parseInt(scanner.nextLine()));
                    }
                    case 5 -> {     //update student
                        System.out.println("Enter id of student to update info of student");
                        int updateId = Integer.parseInt(scanner.nextLine());
                        boolean isFound = CrudService.getStudentById(updateId);
                        if (isFound) {
                            System.out.println("Enter student's Name :: Age :: Address to update record");
                            Student student1 = new Student(updateId, scanner.nextLine(), Integer.parseInt(scanner.nextLine()), scanner.nextLine());
                            CrudService.updateStudent(student1);
                        }
                    }
                    case 6 -> {     //exit
                        isRunning = false;
                        startMenu();
                    }
                    default -> System.out.println("Invalid Choice :(");
                }
            }
        }
    }


    public static void scrollableMenu() throws SQLException {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Choose an option to get following Scrollable ResultSet :-");
            System.out.println("1.sensitiveReadOnly ResultSet\t\t2.UpdateAbleInSensitive ResultSet");
            System.out.println("3.UpdateAbleSensitive ResultSet\t\t4.Back to Start menu");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1: //ReadOnly
                    ScrollableService.readonlySensitive();
                    break;
                case 2: //UpdateAbleInsensitive
                    ScrollableService.updateAbleInSensitive();
                    break;
                case 3: //UpdateAbleSensitive
                    ScrollableService.updateAbleSensitive();
                    break;
                case 4:
                    ProgramMenu.startMenu();
                default:
                    System.out.println("Invalid Choice :(");
                    break;

            }

        }
    }

    public static void sensitiveReadOnlyMenu(ResultSet resultSet) throws SQLException {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean isRunning = true;
            while (isRunning) {
                System.out.println("Choose an option to use following Methods :-");
                System.out.println("1.first()\t\t2.next()\t\t3.last");
                System.out.println("4.getRow()\t\t5.previous()\t6.absolute()");
                System.out.println("7.relative()\t8.Back to Scrollable menu");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        ScrollableService.getFirst(resultSet);
                        break;
                    case 2:
                        ScrollableService.getNext(resultSet);
                        break;
                    case 3:
                        ScrollableService.getLast(resultSet);
                        break;
                    case 4:
                        ScrollableService.getRow(resultSet);
                        break;
                    case 5:
                        ScrollableService.getPrevious(resultSet);
                        break;
                    case 6:
                        ScrollableService.getAbsolute(resultSet);
                        break;
                    case 7:
                        ScrollableService.getRelative(resultSet);
                        break;
                    case 8:
                        isRunning = false;
                        ProgramMenu.scrollableMenu();

                    default:
                        System.out.println("Invalid choice :(");

                }
            }
        }

    }

    public static void updateAbleResultSetMenu(ResultSet resultSet) throws SQLException {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean isRunning = true;
            while (isRunning) {
                System.out.println("Choose an option to use following Methods :-");
                System.out.println("1.first()\t\t\t2.next()\t\t\t3.last()");
                System.out.println("4.updateRow()\t\t5.previous()\t\t6.absolute()");
                System.out.println("7.relative()\t\t8.insertRow()\t\t9.deleteRow()");
                System.out.println("10.Back to Scrollable menu");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> ScrollableService.getFirst(resultSet);
                    case 2 -> ScrollableService.getNext(resultSet);
                    case 3 -> ScrollableService.getLast(resultSet);
                    case 4 -> ScrollableService.getUpdate(resultSet);
                    case 5 -> ScrollableService.getPrevious(resultSet);
                    case 6 -> ScrollableService.getAbsolute(resultSet);
                    case 7 -> ScrollableService.getRelative(resultSet);
                    case 8 -> ScrollableService.getInsert(resultSet);
                    case 9 -> ScrollableService.getDelete(resultSet);
                    case 10 -> {
                        isRunning = false;
                        ProgramMenu.scrollableMenu();
                    }
                    default -> System.out.println("Invalid choice :(");
                }
            }
        }
    }

}


