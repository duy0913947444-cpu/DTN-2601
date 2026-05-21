package org.example.Backend.Repository.Impl;

import org.example.Backend.Repository.IPositionRepository;
import org.example.Entity.Position;
import org.example.Enums.PositionName;
import org.example.Utils.JDBCConnection;
import org.example.Utils.Utils;

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
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            List<Position> positionList = new ArrayList<>();
            String queryStatement = "select * from position";
            connection = JDBCConnection.connectDB("qlcb");
            statement = connection.createStatement();
            resultSet = statement.executeQuery(queryStatement);
            Position position;
            while (resultSet.next()) {
                position = new Position();
                position.setPositionId(resultSet.getInt("position_id"));
                position.setPositionName(PositionName.valueOf(resultSet.getString("position_name")));
                positionList.add(position);
            }
            return positionList;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utils.close(connection, statement, resultSet);
        }
        return null;
    }

    @Override
    public boolean createPosition(PositionName positionName) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            String queryStatement = "insert into `position`(position_name)\n" +
                    "value (?)";
            connection = JDBCConnection.connectDB("qlcb");
            preparedStatement = connection.prepareStatement(queryStatement);
            preparedStatement.setString(1, String.valueOf(positionName));
            int c = preparedStatement.executeUpdate();
            return c > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utils.close(connection, preparedStatement, null);
        }
        return false;
    }

    @Override
    public boolean updatePosition(PositionName positionName, int positionId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            String queryStatement = "update `position`\n" +
                    "set position_name = ?\n" +
                    "where position_id = ?";
            connection = JDBCConnection.connectDB("qlcb");
            preparedStatement = connection.prepareStatement(queryStatement);
            preparedStatement.setString(1, String.valueOf(positionName));
            preparedStatement.setInt(2, positionId);
            int c = preparedStatement.executeUpdate();
            return c > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utils.close(connection, preparedStatement, null);
        }
        return false;
    }

    @Override
    public boolean deletePosition(int positionID) {
        Connection conn = null;
        PreparedStatement preparedStatementAccount = null;
        PreparedStatement preparedStatement = null;
        Statement statement = null;
        String disableSafeUpdate = "SET SQL_SAFE_UPDATES = 0;";
        String deleteAccount = "DELETE FROM `account` WHERE position_id = ?";
        String deletePosition = "DELETE FROM `position` WHERE position_id = ?";

        try {
            conn = JDBCConnection.connectDB("qlcb");
            conn.setAutoCommit(false);
            statement = conn.createStatement();
            statement.executeUpdate(disableSafeUpdate);
            preparedStatementAccount = conn.prepareStatement(deleteAccount);
            preparedStatementAccount.setInt(1, positionID);
            preparedStatementAccount.executeUpdate();

            preparedStatement = conn.prepareStatement(deletePosition);
            preparedStatement.setInt(1, positionID);
            int rows = preparedStatement.executeUpdate();
            if(rows > 0){
                conn.commit();
                return true;
            }else{
                conn.rollback();
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            Utils.close(conn, preparedStatement, null);
            Utils.close(null, preparedStatementAccount, null);
            Utils.close(null, statement, null);
        }
        return false;
    }

    @Override
    public List<Position> findPositionByName(PositionName positionName) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            List<Position> result = new ArrayList<>();
            String queryStatement = "select *\n" +
                    "from `position`\n" +
                    "where position_name = ?";
            connection = JDBCConnection.connectDB("qlcb");
            preparedStatement = connection.prepareStatement(queryStatement);
            preparedStatement.setString(1, String.valueOf(positionName));
            resultSet = preparedStatement.executeQuery();
            Position position;
            while (resultSet.next()) {
                position = new Position();
                position.setPositionId(resultSet.getInt("position_id"));
                position.setPositionName(PositionName.valueOf(resultSet.getString("position_name")));
                result.add(position);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            Utils.close(connection, preparedStatement, resultSet);
        }
        return null;
    }

    @Override
    public List<Position> getPositionWithHighestAccount() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ResultSet rs = null;
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
        try {
            connection = JDBCConnection.connectDB("qlcb");
            //Subquery
            statement = connection.createStatement();
            resultSet = statement.executeQuery(subQuery);
            if (!resultSet.next()) return null;
            int count = resultSet.getInt("count(1)");
            //Query
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, count);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Position position = new Position();
                position.setPositionId(rs.getInt("position_id"));
                position.setPositionName(PositionName.valueOf(rs.getString("position_name")));
                positionList.add(position);
            }
            return positionList;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            Utils.close(connection, preparedStatement, resultSet);
            Utils.close(null, statement, rs);
        }
        return null;
    }

    @Override
    public List<Position> getPositionWithSmallestAccount() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ResultSet rs = null;
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
        try {
            connection = JDBCConnection.connectDB("qlcb");
            //Subquery
            statement = connection.createStatement();
            resultSet = statement.executeQuery(subQuery);
            if (!resultSet.next()) return null;
            int count = resultSet.getInt("count(1)");
            //Query
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, count);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Position position = new Position();
                position.setPositionId(rs.getInt("position_id"));
                position.setPositionName(PositionName.valueOf(rs.getString("position_name")));
                positionList.add(position);
            }
            return positionList;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            Utils.close(connection, preparedStatement, resultSet);
            Utils.close(null, statement, rs);
        }
        return null;
    }

    @Override
    public boolean checkExistName(PositionName positionName, Integer ID) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean check = false;
        try {
            String queryStatement = "select * \n" +
                    "from position\n" +
                    "where position_name = ? and (position_id != ? or ? is null)";

            if (Objects.nonNull(ID)) {
                queryStatement += " and position_id != ? ";
            }
            connection = JDBCConnection.connectDB("qlcb");
            preparedStatement = connection.prepareStatement(queryStatement);
            preparedStatement.setString(1, String.valueOf(positionName));
            if (Objects.isNull(ID)) {
                preparedStatement.setNull(2, java.sql.Types.INTEGER);
                preparedStatement.setNull(3, java.sql.Types.INTEGER);
            } else {
                preparedStatement.setInt(2, ID);
                preparedStatement.setInt(3, ID);
            }
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) check = true;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            Utils.close(connection, preparedStatement, resultSet);
        }
        return check;
    }

    @Override
    public boolean checkExistID(int positionId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean check = false;
        try {
            String queryStatement = "Select * from position where position_id = ? ";

            connection = JDBCConnection.connectDB("qlcb");
            preparedStatement = connection.prepareStatement(queryStatement);

            preparedStatement.setInt(1, positionId);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) check = true;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            Utils.close(connection, preparedStatement, resultSet);
        }
        return check;
    }
}
