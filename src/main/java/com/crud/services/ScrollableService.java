package com.crud.services;
import com.crud.menu.ProgramMenu;
import com.crud.database.DatabaseConnection;
import com.crud.database.QueryUtils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
//this includes some scrollable resultSet services
public class ScrollableService {

    //<-----------------common methods in scrollable resultSet---------------->
    //<--------------------------------next()--------------------------------->
    public static void getNext(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) printResultSet(resultSet);
        else System.out.println("Record not found :(");
    }

    //<--------------------------------last()--------------------------------->
    public static void getLast(ResultSet resultSet) throws SQLException {
        resultSet.last();
        printResultSet(resultSet);

    }

    //<--------------------------------first()-------------------------------->
    public static void getFirst(ResultSet resultSet) throws SQLException {
        resultSet.first();
        printResultSet(resultSet);
    }

    //<--------------------------------getRow()-------------------------------->
    public static void getRow(ResultSet resultSet) throws SQLException {
        System.out.println("You are at row : " + resultSet.getRow());
    }

    //<--------------------------------Previous()------------------------------->
    public static void getPrevious(ResultSet resultSet) throws SQLException {
        if (resultSet.previous()){
            printResultSet(resultSet);
        }
        else {
            System.out.println("Record not found :(");
        }
    }

    //<-----------------------------Absolute(int index)-------------------------->
    public static void getAbsolute(ResultSet resultSet) throws SQLException {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Please enter index for absolute method: ");
            if (resultSet.absolute(Integer.parseInt(scanner.nextLine()))){
                printResultSet(resultSet);
            }
            else {
                System.out.println("Result not found :(");
            }
        }
    }

    //<-----------------------------Relative(int index)-------------------------->
    public static void getRelative(ResultSet resultSet) throws SQLException {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Please enter index for absolute method: ");
            if (resultSet.relative(Integer.parseInt(scanner.nextLine()))){
                printResultSet(resultSet);
            }
            else {
                System.out.println("Result not found :(");
            }
        }
    }

    //<---------------------------------getUpdate()------------------------------->
    public static void getUpdate(ResultSet resultSet) throws SQLException {
        try (Scanner scanner = new Scanner(System.in)) {

            if (resultSet.isAfterLast() || resultSet.isBeforeFirst()) {
                System.out.println("please select row to update.... :(");
            } else {
                System.out.println("Previous Data: ");
                printResultSet(resultSet);
                System.out.println("Enter New Details To Update: ");
                System.out.print("Name :");
                resultSet.updateString("name", scanner.nextLine());
                System.out.print("Age :");
                resultSet.updateInt("age", Integer.parseInt(scanner.nextLine()));
                System.out.print("Address :");
                resultSet.updateString("address", scanner.nextLine());
                resultSet.updateRow();
                System.out.println("After update: ");
                ScrollableService.printResultSet(resultSet);
            }
        }
    }
    //<---------------------------------getInsert()------------------------------->
    public static void getInsert(ResultSet resultSet)throws SQLException{
        try (Scanner scanner=new Scanner(System.in)){
            resultSet.moveToInsertRow();
            System.out.println("Enter New Details To Insert: ");
            System.out.print("Name:");
            String name=scanner.nextLine();
            System.out.print("Age :");
            int age=Integer.parseInt(scanner.nextLine());
            System.out.print("Address :");
            String address=scanner.nextLine();
            /*---------------------------------------------------*/
            resultSet.updateString("name", name);
            resultSet.updateInt("age", age);
            resultSet.updateString("address",address);
            resultSet.insertRow();
            resultSet.last();
        }
    }
    //<----------------getDelete()-------------------->
    public static void getDelete(ResultSet resultSet)throws SQLException{
        resultSet.deleteRow();
    }



    //<----------------printResultSet for scrollable resultSet-------------------->
    public static void printResultSet(ResultSet resultSet) throws SQLException {
        System.out.println("----------------------------------------------------------------------");
        System.out.println("ID : " + resultSet.getInt("id") +
                " | NAME : " + resultSet.getString("name") +
                " | AGE : " + resultSet.getInt("age") +
                " | ADDRESS : " + resultSet.getString("address")+" |");
        System.out.println("----------------------------------------------------------------------");
    }

    //<-----------------Scrollable ResultSet --- Sensitive Read Only --------------->
    public static void readonlySensitive() throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             ResultSet resultSet = statement.executeQuery(QueryUtils.selectAllStudentQuery())) {
            ProgramMenu.sensitiveReadOnlyMenu(resultSet);
        }
    }

    //<---------------Scrollable ResultSet --- UpdateAble Sensitive --------------->
    public static void updateAbleSensitive() throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet resultSet = statement.executeQuery(QueryUtils.selectAllStudentQuery())) {
            ProgramMenu.updateAbleResultSetMenu(resultSet);
        }
    }

    //<---------------Scrollable ResultSet --- UpdateAble Insensitive ------------->
    public static void updateAbleInSensitive() throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet resultSet = statement.executeQuery(QueryUtils.selectAllStudentQuery())) {
            ProgramMenu.updateAbleResultSetMenu(resultSet);
        }
    }

}
