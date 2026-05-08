package com.vti.Frontend;

import com.vti.Backend.AccountManagement;
import com.vti.Backend.DepartmentManagement;
import com.vti.Backend.PositionManagement;
import com.vti.Backend.QuanLiCanBo;
import com.vti.Entity.Account;
import com.vti.Entity.CanBo;
import com.vti.Entity.Department;
import com.vti.Entity.Position;

import java.sql.SQLException;
import java.util.List;

public class Program {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        List<CanBo> canBoList = QuanLiCanBo.getCanBo();
        for(CanBo canBo: canBoList){
            System.out.println(canBo);
        }
        List<Account> accountList = AccountManagement.getAccount();
        List<Department> departmentList = DepartmentManagement.getDepartment();
        List<Position> positionList = PositionManagement.getPosition();
        for(Account account: accountList){
            System.out.println(account);
        }
        for(Department department: departmentList){
            System.out.println(department);
        }
        for(Position position: positionList){
            System.out.println(position);
        }
    }
}
