package com.cybertek.jdbc.day2;

import com.cybertek.jdbc.utility.DB_Utility;

public class JDBC_Practice {

    public static void main(String[] args) {
        DB_Utility.createConnection();
        DB_Utility.runQuery("SELECT * FROM EMPLOYEES");
        int colCnt = DB_Utility.getColumnCNT();
    }
}
