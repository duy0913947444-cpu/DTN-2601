package com.vti.Utils;

import java.sql.*;

public class JDBCConnection {
    public static Connection connectDB(String dataBaseUse) throws ClassNotFoundException, SQLException {
        if(Utils.checkString(dataBaseUse)) return null;
        String url = "jdbc:mysql://localhost:3306/" + dataBaseUse;
        String userName = "root";
        String password = "823067Nd";
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url,userName, password);
    }
}
