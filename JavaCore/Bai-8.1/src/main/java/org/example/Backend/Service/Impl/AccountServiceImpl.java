package org.example.Backend.Service.Impl;

import org.example.Backend.Repository.IDepartmentRepository;
import org.example.Backend.Repository.IPositionRepository;
import org.example.Backend.Repository.Impl.AccountRepositoryImpl;
import org.example.Backend.Repository.IAccountRepository;
import org.example.Backend.Repository.Impl.DepartmentRepositoryImpl;
import org.example.Backend.Repository.Impl.PositionRepositoryImpl;
import org.example.Backend.Service.IAccoountService;
import org.example.DTO.ImportError;
import org.example.Entity.Account;
import org.example.Entity.Department;
import org.example.Utils.Utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AccountServiceImpl implements IAccoountService {
    private IAccountRepository accountRepository = new AccountRepositoryImpl();
    private IDepartmentRepository departmentRepository = new DepartmentRepositoryImpl();
    private IPositionRepository positionRepository = new PositionRepositoryImpl();
    @Override
    public List<Account> getAccount() {
        return accountRepository.getAccount();
    }

    @Override
    public boolean updateAccount(String userName, int accountId) {
        return accountRepository.updateAccount(userName,accountId);
    }

    @Override
    public boolean deleteAccount(int accountID) {
        return accountRepository.deleteAccount(accountID);
    }

    @Override
    public List<Account> findAccountByUserName(String userName) {
        return accountRepository.findAccountByUserName(userName);
    }

    @Override
    public boolean createAccount(String email, String userName, String fullName, int departmentId, int positionId, LocalDate createDate) {
        return accountRepository.createAccount(email,userName,fullName,departmentId,positionId,LocalDate.now());
    }

    @Override
    public boolean checkUnique(String nameCol, String noiDung, Integer ID) {
        return accountRepository.checkUnique(nameCol,noiDung, ID);
    }

    @Override
    public boolean checkExistID(int accountID) {
        return accountRepository.checkExistID(accountID);
    }

    @Override
    public boolean importAccountToCSV(String path) {
        boolean flag = true;
        boolean check = false;
        List<Account> accounts = new ArrayList<>();
        List<ImportError> importErrorList = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
            List<String> errors = new ArrayList<>();
            String line;
            while((line = bufferedReader.readLine()) != null){
                Account account = new Account();
                if(flag){
                    flag = false;
                    continue;
                }
                String[] s = line.split(",");
                String email = s[0];
                String user_name = s[1];
                String full_name = s[2];
                Integer department_id = Integer.parseInt(s[3].trim());
                Integer position_id = Integer.parseInt(s[4].trim());
                if(Utils.checkString(email)){
                    errors.add("email ko dc de trong");
                }else if(!accountRepository.checkUnique("email", email,null)){
                    errors.add("email da ton tai");
                }else if(!accountRepository.checkUnique("user_name", user_name,null)){
                    errors.add("userName da ton tai");
                }else if(!departmentRepository.checkExistID(department_id)){
                    errors.add("department id khong ton tai");
                }else if(!positionRepository.checkExistID(position_id)){
                    errors.add("position id khong ton tai");
                }
                if(errors.isEmpty()){
                    account.setEmail(email);
                    account.setUser(user_name);
                    account.setFullName(full_name);
                    accounts.add(account);
                }else{
                    importErrorList.add(new ImportError(line, String.join(" | ", errors)));
                }
            }
            String pathError = "D:\\outputdepartment_error.txt";
            try(BufferedWriter bf = new BufferedWriter(new FileWriter(pathError))){
                bf.write("email, user_name, full_name, department_id, position_id, message_error");
                bf.newLine();
                for(ImportError importError : importErrorList){
                    bf.write(importError.getLine() + " , " + importError.getMassage());
                    bf.newLine();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            if(!accounts.isEmpty()){
                check = accountRepository.createAccounts(accounts);
            }
        }catch(Exception e){
            //message = e.getMessage();
        }
        return check;
    }
}
