package com.crud.main;
import com.crud.menu.ProgramMenu;

import java.sql.SQLException;

public class MainClass {
    public static void main(String[] args) {
        try {
          //  CallableStatement.getCallableStatement();
            ProgramMenu.startMenu();

        } catch (SQLException e) {
            throw new RuntimeException("Something went wrong :( " + e);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
