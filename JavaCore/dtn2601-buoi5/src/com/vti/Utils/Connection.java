package com.vti.Utils;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class Connection {
    public static ResultSet connectDB(String queryStatement, String dataBaseUse) throws ClassNotFoundException, SQLException {
        if(Utils.checkString(dataBaseUse)) return null;
        String url = "jdbc:mysql://localhost:3306/" + dataBaseUse;
        String userName = "root";
        String password = "823067Nd";
        Class.forName("com.mysql.cj.jdbc.Driver");
        java.sql.Connection connection = DriverManager.getConnection(url,userName, password);
        Statement statement = connection.createStatement();
        return statement.executeQuery(queryStatement);
    }
}
