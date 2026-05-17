package org.example.Utils;

import java.sql.*;
import java.util.Objects;

public class JDBCConnection {
    public static Connection connectDB(String dataBaseUse) throws ClassNotFoundException, SQLException {
        if(Utils.checkString(dataBaseUse)) return null;
        String url = "jdbc:mysql://localhost:3306/" + dataBaseUse;
        String userName = "root";
        String password = "823067Nd";
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url,userName, password);
    }
    public static void close(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {
        if(!Objects.isNull(connection)){
            connection.close();
        }else if(!Objects.isNull(statement)){
            statement.close();
        }else if(!Objects.isNull(resultSet)){
            resultSet.close();
        }
    }
}
