package com.crud.services;


import com.crud.database.DatabaseConnection;
import com.crud.database.QueryUtils;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;

// it includes a method form get callable statement
public class CallableStatement {
    public static  void getCallableStatement() throws SQLException {
    try(Connection connection= DatabaseConnection.getConnection();
        java.sql.CallableStatement statement=connection.prepareCall(QueryUtils.callableGetStudentQuery(2));
        ResultSet resultSet=statement.executeQuery()){
        System.out.println(resultSet.getString(2));

    }

    }
}
