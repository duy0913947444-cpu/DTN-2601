package org.example.Utils;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Utils {
    private static Scanner sc = new Scanner(System.in);

    public static boolean checkString(String s){
        return Objects.isNull(s) || s.trim().isEmpty();
    }
    public static boolean checkID(String ID){
        try{
            int i = Integer.parseInt(ID);
            if(i < 0) return false;
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public static void close(Connection connection, Statement statement, ResultSet resultSet){
        try{
            if(Objects.nonNull(connection)){
                connection.close();
            }else if(Objects.nonNull(statement)){
                statement.close();
            }else if(Objects.nonNull(resultSet)){
                resultSet.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }


}
