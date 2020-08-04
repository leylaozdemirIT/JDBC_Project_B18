package com.cybertek.day1;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class MovingForwardAndBackWardWithResult {

    public static void main(String[] args) throws SQLException {
        String connectionStr = "jdbc:oracle:thin:@100.26.166.36:1521:XE";
        String username = "hr";
        String password = "hr";
        Connection conn = DriverManager.getConnection(connectionStr, username, password);
        // if we create the Statement in this way, this will generate a forward only ResultSet
        // meaning we can only move forward with next() and can not move backward with previous
        // Statement stmnt = conn.createStatement();

        // ResultSet.Type_Scroll_Insensitive will make the result set created from this statement
        // be able to move forward and backward
        // ResultSet.CONCUR_READ_ONLY will make resultSet read only and that's what we need
        Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmnt.executeQuery("SELECT * FROM COUNTRIES ");

        rs.next();
        System.out.println(rs.getString("COUNTRY_ID") + rs.getString("COUNTRY_NAME"));

        rs.next();
        System.out.println(rs.getString("COUNTRY_ID") + rs.getString("COUNTRY_NAME"));

        rs.previous();
        System.out.println(rs.getString("COUNTRY_ID") + rs.getString("COUNTRY_NAME"));

        rs.first(); // this will move the cursor to the first row location
        System.out.println(rs.getString("COUNTRY_ID") + rs.getString("COUNTRY_NAME"));

        // moving to the last row directly
        rs.last(); // this will move the cursor to the last row location
        System.out.println(rs.getString("COUNTRY_ID") + rs.getString("COUNTRY_NAME"));

        rs.beforeFirst(); // how to move to before first row location

        rs.afterLast(); // how to move to after last row location

        rs.absolute(5); // this will move the cursor directly to the 5th row
        System.out.println(rs.getString("COUNTRY_ID") + rs.getString("COUNTRY_NAME"));

        // how to move to before first row location
        rs.beforeFirst();
        // how to move to after last row location
        rs.afterLast();

//------ cleaning up -----
        rs.close();
        stmnt.close();
        conn.close();

    }
}