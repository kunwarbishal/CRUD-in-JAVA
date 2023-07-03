package com.crud.database;

public class QueryUtils {
    public static String insertStudentQuery() {
        return "INSERT INTO studentinfo (name,age,address) VALUES(?,?,?)";
    }

    public static String selectAllStudentQuery() {
        return "SELECT * FROM studentinfo";
    }

    public static String getStudentByIdQuery(int id) {
        return "SELECT * FROM studentinfo WHERE id = " + id;
    }

    public static String deleteStudentQuery(int id) {
        return "DELETE FROM studentinfo WHERE id = " + id;
    }

    public static String updateStudentQuery(int id) {
        return "UPDATE studentinfo SET name = ?, age = ? ,address=? WHERE id = " + id;
    }
    //-------------------callable statement ------------------------->
    public  static String callableGetStudentQuery(int i){
        return "{call getStudentById("+i+")}";

    }

}
