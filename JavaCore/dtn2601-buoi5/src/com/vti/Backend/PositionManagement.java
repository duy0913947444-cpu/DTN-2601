package com.vti.Backend;

import com.vti.Entity.CanBo;
import com.vti.Entity.Position;
import com.vti.Enums.Gender;
import com.vti.Enums.Loai;
import com.vti.Enums.PositionName;
import com.vti.Utils.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionManagement {
    public static List<Position> getPosition() throws SQLException, ClassNotFoundException {
        List<Position> positionList = new ArrayList<>();
        String queryStatement = "select * from position";
        ResultSet resultSet = Connection.connectDB(queryStatement, "qlcb");
        Position position;
        while(resultSet.next()){
            position = new Position();
            position.setPositionId(resultSet.getInt("position_id"));
            position.setPositionName(PositionName.valueOf(resultSet.getString("position_name")));
            positionList.add(position);
        }
        return positionList;
    }
}
