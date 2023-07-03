package com.crud.main;
import com.crud.menu.ProgramMenu;

import java.sql.SQLException;
//main class
public class MainClass {
    public static void main(String[] args) {
        try {
          //  CallableStatement.getCallableStatement();
            ProgramMenu.startMenu();

        } catch (SQLException e) {
            System.out.println("Something went wrong :( " + e);
        }

    }
}
