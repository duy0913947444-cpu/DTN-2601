package org.example.Backend.Service.Impl;

import org.example.Backend.Repository.Impl.DepartmentRepositoryImpl;
import org.example.Backend.Repository.IDepartmentRepository;
import org.example.Backend.Service.IDepartmentService;
import org.example.DTO.CSV.DepartmentCsv;
import org.example.DTO.Context.DepartmentContext;
import org.example.DTO.ImportError;
import org.example.Entity.Department;
import org.example.Utils.Utils;

import java.io.*;
import java.sql.SQLException;
import java.util.*;

import static org.example.Utils.Utils.checkString;

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
    public String importDepartmentToCSV(String path) {
        Set<String> s = departmentRepository.getSetDepartmentName();
        DepartmentContext depContext = new DepartmentContext(s);
        return this.importFile(path, depContext, "D:/outputdepartment_error.txt");
    }

//    @Override
//    public boolean importDepartmentToCSV(String path){
//        if(!path.endsWith(".csv")) return false;
//
//        boolean check = false;
//        List<Department> departments = new ArrayList<>();
//        List<ImportError> importErrorList = new ArrayList<>();
//        Set<String> errors = new HashSet<>();
//        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
//            String line;
//            // khong doc dong dau tien
//            String lineError = bufferedReader.readLine() + ", message_error";
//            String pathError = "D:\\outputdepartment_error.txt";
//            while((line = bufferedReader.readLine()) != null){
//                Department department = new Department();
//                //Tach lay department name
//                String[] s = line.split(",");
//                String departmentName = s[0];
//                //check error
//                String error = checkError(departmentName, errors);
//                if(Objects.isNull(error)){
//                    department.setDepartmentName(s[0]);
//                    departments.add(department);
//                }else{
//                    importErrorList.add(new ImportError(String.join(" | ", error), line));
//                }
//            }
//            writeErrorFile(pathError, lineError, importErrorList);
//            if(!departments.isEmpty()){
//                check = departmentRepository.createDepartments(departments);
//            }
//        }catch(Exception e){
//            //message = e.getMessage();
//        }
//        return check;
//    }


    @Override
    public List<DepartmentCsv> readFile(String path) {
        List<DepartmentCsv> departmentCsvs = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            br.readLine();
            while((line = br.readLine()) != null){
                String[] departmentName = line.split(",");
                DepartmentCsv departmentCsv = new DepartmentCsv(departmentName[0]);
                departmentCsvs.add(departmentCsv);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return departmentCsvs;
    }
    @Override
    public void validation(DepartmentCsv csv, DepartmentContext context,
                           List<ImportError> importErrors, List<Department> entities) {
        String departmentName = csv.getDepartmentName();
        List<String> errors = new ArrayList<>();
        checkError(departmentName,errors,context);
        if(errors.isEmpty()){
            Department d = new Department(departmentName);
            //add vao list de check trung
            Set<String> s = context.getsDepartmentByDepartmentName();
            s.add(departmentName);
            //list saveAll
            entities.add(d);
        }else{
            //list export file
            importErrors.add(new ImportError(String.join("|",errors), departmentName));
        }
    }
    @Override
    public void saveAll(List<Department> entities) {
        try {
            departmentRepository.createDepartments(entities);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void exportFileError(String pathError, List<ImportError> importErrors) {
        String firstLine = "Department name, errors";
        Utils.writeErrorFile(pathError, firstLine, importErrors);
    }


    private void checkError(String departmentName, List<String> errors, DepartmentContext departmentContext){
        Set<String> s = departmentContext.getsDepartmentByDepartmentName();
        if(checkString(departmentName)){
            errors.add("Department name is not empty!");
        }else if(s.contains(departmentName)){
            errors.add("Department name is exist!");
        }
    }
}
