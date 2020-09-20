package com.cybertek.jdbc.day1;

import java.sql.*;

public class IteratingPractice {

    public static void main(String[] args) throws SQLException {

        // TASK 1:
        // CREATE A NEW CLASS, ADD CONNECTION, STATEMENT, RESULTSET AND TRY TO PRINT OUT EACH AND EVERYTHING UNDER COUNTRIES TABLE

        String connectionStr = "jdbc:oracle:thin:@3.81.143.40:1521:XE";
        String username = "hr" ;
        String password = "hr" ;
        Connection conn = DriverManager.getConnection(connectionStr,username,password) ;
        Statement stmnt = conn.createStatement();
        //ResultSet rs   =   stmnt.executeQuery("SELECT * FROM COUNTRIES WHERE REGION_ID = 1") ;
        ResultSet rs   =   stmnt.executeQuery("SELECT * FROM COUNTRIES") ;

        // as long as rs.next() return true I know I have next row to print the data
        // we will keep looping as long as rs.next() return true
        while(rs.next()==true){

            System.out.println(rs.getString(1)+ " "
                    + rs.getString(2) + " "
                    + rs.getInt(3) ); /// this is getting region id as number instead of String

        }
//        rs.previous();
//------ cleaning up -----
        rs.close();
        stmnt.close();
        conn.close();


    }

}