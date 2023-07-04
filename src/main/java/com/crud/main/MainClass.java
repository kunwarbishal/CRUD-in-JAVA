package com.crud.main;
import com.crud.menu.ProgramMenu;

import java.sql.SQLException;
//main class
public class MainClass {
    public static void main(String[] args) {
        try {
          //  CallableStatement.getCallableStatement();
            ProgramMenu.startMenu();

        } catch (SQLException ex) {
            System.out.println("Something went wrong :( " + ex);
        }

    }
}
