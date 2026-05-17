package org.example.Backend.Repository.Impl;

import org.example.Backend.Repository.IPositionRepository;
import org.example.Entity.Position;
import org.example.Enums.PositionName;
import org.example.Utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PositionRepositoryImpl implements IPositionRepository {
    @Override
    public List<Position> getPosition() {
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

    @Override
    public boolean createPosition(PositionName positionName) {
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

    @Override
    public boolean updatePosition(PositionName positionName, int positionId) {
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

    @Override
    public boolean deletePosition(int positionID) {
        String deleteAccount = "DELETE FROM `account` WHERE position_id = ?";
        String deletePosition = "DELETE FROM `position` WHERE position_id = ?";

        try (Connection conn = JDBCConnection.connectDB("qlcb")) {
            conn.setAutoCommit(false);

            try (PreparedStatement ps = conn.prepareStatement(deleteAccount)) {
                ps.setInt(1, positionID);
                ps.executeUpdate();
            }

            try (PreparedStatement ps = conn.prepareStatement(deletePosition)) {
                ps.setInt(1, positionID);
                int rows = ps.executeUpdate();
                conn.commit();
                return rows > 0;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Position> findPositionByName(PositionName positionName) {
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

    @Override
    public List<Position> getPositionWithHighestAccount() {
        List<Position> positionList = new ArrayList<>();
        String subQuery = "select count(1)\n" +
                "\t\t\t\t\tfrom `position` p\n" +
                "\t\t\t\t\tjoin `account` a on a.position_id = p.position_id\n" +
                "\t\t\t\t\tgroup by p.position_id\n" +
                "\t\t\t\t\torder by count(1) desc\n" +
                "\t\t\t\t\tlimit 1";
        String query = "select p.*\n" +
                "from `position` p\n" +
                "join `account` a on a.position_id = p.position_id\n" +
                "group by p.position_id\n" +
                "having count(1) = ?";
        try{
            Connection connection = JDBCConnection.connectDB("qlcb");
            //Subquery
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(subQuery);
            if(!resultSet.next()) return null;
            int count = resultSet.getInt("count(1)");
            //Query
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,count);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Position position = new Position();
                position.setPositionId(rs.getInt("position_id"));
                position.setPositionName(PositionName.valueOf(rs.getString("position_name")));
                positionList.add(position);
            }
            return positionList;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Position> getPositionWithSmallestAccount() {
        List<Position> positionList = new ArrayList<>();
        String subQuery = "select count(1)\n" +
                "\t\t\t\t\tfrom `position` p\n" +
                "\t\t\t\t\tjoin `account` a on a.position_id = p.position_id\n" +
                "\t\t\t\t\tgroup by p.position_id\n" +
                "\t\t\t\t\torder by count(1)\n" +
                "\t\t\t\t\tlimit 1";
        String query = "select p.*\n" +
                "from `position` p\n" +
                "join `account` a on a.position_id = p.position_id\n" +
                "group by p.position_id\n" +
                "having count(1) = ?";
        try{
            Connection connection = JDBCConnection.connectDB("qlcb");
            //Subquery
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(subQuery);
            if(!resultSet.next()) return null;
            int count = resultSet.getInt("count(1)");
            //Query
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,count);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Position position = new Position();
                position.setPositionId(rs.getInt("position_id"));
                position.setPositionName(PositionName.valueOf(rs.getString("position_name")));
                positionList.add(position);
            }
            return positionList;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean checkExistName(PositionName positionName, Integer ID) {
        boolean check = false;
        try {
            String queryStatement = "Select * from position where position_name like ?  ";

            if (Objects.nonNull(ID)) {
                queryStatement += " and position_id != ? ";
            }
            Connection connection = JDBCConnection.connectDB("qlcb");
            PreparedStatement preparedStatement = connection.prepareStatement(queryStatement);
            preparedStatement.setString(1,String.valueOf(positionName));
            if (Objects.nonNull(ID)) {
                preparedStatement.setInt(2, ID);
            }
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) check = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public boolean checkExistID(int positionId) {
        boolean check = false;
        try{
            String queryStatement = "Select * from position where position_id = ? ";

            Connection connection = JDBCConnection.connectDB("qlcb");
            PreparedStatement preparedStatement = connection.prepareStatement(queryStatement);

            preparedStatement.setInt(1,positionId);

            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()) check = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return check;
    }
}
