package org.example.Backend.Service.Impl;

import org.example.Backend.Repository.Impl.DepartmentRepositoryImpl;
import org.example.Backend.Repository.IDepartmentRepository;
import org.example.Backend.Service.IDepartmentService;
import org.example.DTO.ImportError;
import org.example.Entity.Department;
import org.example.Utils.Utils;

import java.io.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class DepartmentServieImpl implements IDepartmentService {
    private IDepartmentRepository departmentRepository = new DepartmentRepositoryImpl();

    @Override
    public boolean deleteDepartment(int departmentID) {
        return departmentRepository.deleteDepartment(departmentID);
    }

    @Override
    public boolean updateDepartment(String departmentName, int departmentId) {
        return departmentRepository.updateDepartment(departmentName,departmentId);
    }

    @Override
    public boolean createDepartment(String departmentName) {
        return departmentRepository.createDepartment(departmentName);
    }

    @Override
    public List<Department> getDepartment() {
        return departmentRepository.getDepartment();
    }

    @Override
    public List<Department> getDepartmentWithSmallestAccount() {
        return departmentRepository.getDepartmentWithSmallestAccount();
    }

    @Override
    public List<Department> getDepartmentWithHighestAccount() {
        return departmentRepository.getDepartmentWithHighestAccount();
    }

    @Override
    public List<Department> findDepartmentByName(String departmentName) {
        return departmentRepository.findDepartmentByName(departmentName);
    }

    @Override
    public boolean checkExistName(String departmentName, Integer ID) {
        return departmentRepository.checkExistName(departmentName, ID);
    }

    @Override
    public boolean checkExistID(int departmentID) {
        return departmentRepository.checkExistID(departmentID);
    }

    @Override
    public boolean importDepartmentToCSV(String path){
        boolean flag = true;
        String message = "";
        boolean check = false;
        List<Department> departments = new ArrayList<>();
        List<ImportError> importErrorList = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
            List<String> errors = new ArrayList<>();
            String line;
            while((line = bufferedReader.readLine()) != null){
                Department department = new Department();
                if(flag){
                    flag = false;
                    continue;
                }
                String[] s = line.split(",");
                String departmentName = s[0];
                if(Utils.checkString(departmentName)){
                    errors.add("ten phong ban ko dc de trong");
                }else if(departmentRepository.checkExistName(departmentName, null)){
                    errors.add("Ten phong ban da ton tai");
                }
                if(errors.isEmpty()){
                    department.setDepartmentName(s[0]);
                    departments.add(department);
                }else{
                    importErrorList.add(new ImportError(line, String.join(" | ", errors)));
                }
            }
            String pathError = "D:\\outputdepartment_error.txt";
            try(BufferedWriter bf = new BufferedWriter(new FileWriter(pathError))){
                bf.write("Department_name, message_error");
                bf.newLine();
                for(ImportError importError : importErrorList){
                    bf.write(importError.getLine() + " , " + importError.getMassage());
                    bf.newLine();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            if(!departments.isEmpty()){
                check = departmentRepository.createDepartments(departments);
            }
        }catch(Exception e){
            //message = e.getMessage();
        }
        return check;
    }
}
