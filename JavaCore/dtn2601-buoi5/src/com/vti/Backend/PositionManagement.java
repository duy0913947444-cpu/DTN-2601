package com.vti.Backend;
import com.vti.Entity.Position;
import com.vti.Enums.PositionName;
import com.vti.Utils.JDBCConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PositionManagement {
    public static List<Position> getPosition(){
        try{
            List<Position> positionList = new ArrayList<>();
            String queryStatement = "select * from position";
            Connection connection = JDBCConnection.connectDB("qlcb");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(queryStatement);
            Position position;
            while(resultSet.next()){
                position = new Position();
                position.setPositionId(resultSet.getInt("position_id"));
                position.setPositionName(PositionName.valueOf(resultSet.getString("position_name")));
                positionList.add(position);
            }
            return positionList;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static boolean createPosition(PositionName positionName){
        try{
            String queryStatement = "insert into `position`(position_name)\n" +
                    "value (?)";
            Connection connection = JDBCConnection.connectDB("qlcb");
            PreparedStatement preparedStatement = connection.prepareStatement(queryStatement);
            preparedStatement.setString(1,String.valueOf(positionName));
            int c = preparedStatement.executeUpdate();
            return c > 0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public static boolean updatePosition(PositionName positionName, int positionId){
        try{
            String queryStatement = "update `position`\n" +
                    "set position_name = ?\n" +
                    "where position_id = ?";
            Connection connection = JDBCConnection.connectDB("qlcb");
            PreparedStatement preparedStatement = connection.prepareStatement(queryStatement);
            preparedStatement.setString(1,String.valueOf(positionName));
            preparedStatement.setInt(2,positionId);
            int c = preparedStatement.executeUpdate();
            return c > 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public static boolean deletePosition(int positionId){
        try{
            String disableUpdate = "SET SQL_SAFE_UPDATES = 0;";
            String queryStatement = "DELETE FROM `position`\n" +
                    "WHERE position_id = ?";
            String queryStatementAccount = "DELETE FROM `account` \n" +
                    "WHERE position_id = ?";
            Connection connection = JDBCConnection.connectDB("qlcb");
            //Set delete
            Statement statement = connection.createStatement();
            statement.executeUpdate(disableUpdate);
            //Delete account
            PreparedStatement preparedStatement2= connection.prepareStatement(queryStatementAccount);
            preparedStatement2.setInt(1,positionId);
            System.out.println(preparedStatement2.executeUpdate());
            //Delete position
            PreparedStatement preparedStatement = connection.prepareStatement(queryStatement);
            preparedStatement.setInt(1,positionId);
            int c = preparedStatement.executeUpdate();
            return c > 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public static List<Position> findPositionByName(PositionName positionName){
        try{
            List<Position> result = new ArrayList<>();
            String queryStatement = "select *\n" +
                    "from `position`\n" +
                    "where position_name = ?";
            Connection connection = JDBCConnection.connectDB("qlcb");
            PreparedStatement preparedStatement = connection.prepareStatement(queryStatement);
            preparedStatement.setString(1,String.valueOf(positionName));
            ResultSet resultSet = preparedStatement.executeQuery();
            Position position;
            while(resultSet.next()){
                position = new Position();
                position.setPositionId(resultSet.getInt("position_id"));
                position.setPositionName(PositionName.valueOf(resultSet.getString("position_name")));
                result.add(position);
            }
            return result;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
