package com.vti.Backend;

import com.vti.Entity.CanBo;
import com.vti.Enums.Gender;
import com.vti.Enums.Loai;
import com.vti.Utils.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuanLiCanBo {
    public static List<CanBo> getCanBo() throws SQLException, ClassNotFoundException {
        List<CanBo> canBoList = new ArrayList<>();
        String queryStatement = "select * from can_bo";
        ResultSet resultSet = Connection.connectDB(queryStatement, "qlcb");
        CanBo canBo;
        while(resultSet.next()){
            canBo = new CanBo();
            canBo.setFullName(resultSet.getString("full_name"));
            canBo.setAge(resultSet.getInt("age"));
            canBo.setGender(Gender.valueOf(resultSet.getString("gioi_tinh")));
            canBo.setAddress(resultSet.getString("address"));
            canBo.setLoai(Loai.valueOf(resultSet.getString("loai")));
            canBo.setBac(resultSet.getInt("bac"));
            canBo.setNganh(resultSet.getString("nganh"));
            canBo.setCongViec(resultSet.getString("cong_viec"));
            canBoList.add(canBo);
        }
        return canBoList;
    }
}
