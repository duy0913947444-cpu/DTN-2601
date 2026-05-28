package org.example.Backend.Service.Impl;

import org.example.Backend.Repository.IDepartmentRepository;
import org.example.Backend.Repository.IPositionRepository;
import org.example.Backend.Repository.Impl.AccountRepositoryImpl;
import org.example.Backend.Repository.IAccountRepository;
import org.example.Backend.Repository.Impl.DepartmentRepositoryImpl;
import org.example.Backend.Repository.Impl.PositionRepositoryImpl;
import org.example.Backend.Service.IAccoountService;
import org.example.DTO.CSV.AccountCsv;
import org.example.DTO.Context.AccountContext;
import org.example.DTO.ImportError;
import org.example.Entity.Account;
import org.example.Entity.Department;
import org.example.Entity.Position;
import org.example.Utils.Utils;

import java.io.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.example.Common.StringCommon.emailRegex;
import static org.example.Utils.Utils.checkID;
import static org.example.Utils.Utils.writeErrorFile;

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
        return accountRepository.updateAccount(userName, accountId);
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
        return accountRepository.createAccount(email, userName, fullName, departmentId, positionId, LocalDate.now());
    }

    @Override
    public boolean checkUnique(String nameCol, String noiDung, Integer ID) {
        return accountRepository.checkUnique(nameCol, noiDung, ID);
    }

    @Override
    public boolean checkExistID(int accountID) {
        return accountRepository.checkExistID(accountID);
    }

    @Override
    public String importAccountToCSV(String path) {
        Set<String> sAccountByUserName = new HashSet<>();
        Set<String> sAccountByEmail = new HashSet<>();
        List<Integer> departments = new ArrayList<>();
        List<Integer> positions = new ArrayList<>();
        accountRepository.getAccountContext(sAccountByUserName, sAccountByEmail, departments, positions);
        AccountContext accountContext = new AccountContext(sAccountByUserName,
                sAccountByEmail, departments, positions);
        return this.importFile(path, accountContext, "D:/account_errors.csv");
    }

//    @Override
//    public boolean importAccountToCSV(String path) {
//        boolean flag = true;
//        boolean check = false;
//        List<Account> accounts = new ArrayList<>();
//        List<ImportError> importErrorList = new ArrayList<>();
//        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
//            List<String> errors = new ArrayList<>();
//            String line;
//            while((line = bufferedReader.readLine()) != null){
//                Account account = new Account();
//                if(flag){
//                    flag = false;
//                    continue;
//                }
//                String[] s = line.split(",");
//                String email = s[0];
//                String user_name = s[1];
//                String full_name = s[2];
//                Integer department_id = Integer.parseInt(s[3].trim());
//                Integer position_id = Integer.parseInt(s[4].trim());
//                if(Utils.checkString(email)){
//                    errors.add("email ko dc de trong");
//                }else if(!accountRepository.checkUnique("email", email,null)){
//                    errors.add("email da ton tai");
//                }else if(!accountRepository.checkUnique("user_name", user_name,null)){
//                    errors.add("userName da ton tai");
//                }else if(!departmentRepository.checkExistID(department_id)){
//                    errors.add("department id khong ton tai");
//                }else if(!positionRepository.checkExistID(position_id)){
//                    errors.add("position id khong ton tai");
//                }
//                if(errors.isEmpty()){
//                    account.setEmail(email);
//                    account.setUser(user_name);
//                    account.setFullName(full_name);
//                    accounts.add(account);
//                }else{
//                    importErrorList.add(new ImportError(line, String.join(" | ", errors)));
//                }
//            }
//            String pathError = "D:\\outputdepartment_error.txt";
//            try(BufferedWriter bf = new BufferedWriter(new FileWriter(pathError))){
//                bf.write("email, user_name, full_name, department_id, position_id, message_error");
//                bf.newLine();
//                for(ImportError importError : importErrorList){
//                    bf.write(importError.getLine() + " , " + importError.getMassage());
//                    bf.newLine();
//                }
//            }catch(Exception e){
//                e.printStackTrace();
//            }
//            if(!accounts.isEmpty()){
//                check = accountRepository.createAccounts(accounts);
//            }
//        }catch(Exception e){
//            //message = e.getMessage();
//        }
//        return check;
//    }


    @Override
    public List<AccountCsv> readFile(String path) {
        String line;
        List<AccountCsv> accountCsvs = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] s = line.split(",", -1);
                //check dinh dang
                if(s.length < 5) return null;
                AccountCsv accountCsv = new AccountCsv();
                accountCsv.setUserName(s[0]);
                accountCsv.setFullName(s[1]);
                accountCsv.setEmail(s[2]);
                accountCsv.setDepartmentID(s[3]);
                accountCsv.setPositionID(s[4]);
                accountCsvs.add(accountCsv);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return accountCsvs;
    }

    @Override
    public void validation(AccountCsv csv, AccountContext context, List<ImportError> importErrors
            , List<Account> entities) {
        //create first line
        String lineError = csv.getUserName() + ", " + csv.getFullName() + ", "
                + csv.getEmail() + ", " + csv.getDepartmentID() + ", " + csv.getPositionID();
        //check errors
        List<String> errors = new ArrayList<>();
        checkError(csv, errors, context);
        if (errors.isEmpty()) {
            Account account = new Account();
            account.setUser(csv.getUserName());
            account.setEmail(csv.getEmail());
            account.setFullName(csv.getFullName());
            account.setDepartment(new Department(Integer.parseInt(csv.getDepartmentID())));
            account.setPosition(new Position(Integer.parseInt(csv.getPositionID())));
            entities.add(account);
        } else {
            importErrors.add(new ImportError(String.join(" | ", errors), lineError));
        }
    }

    private void checkError(AccountCsv csv, List<String> errors, AccountContext accountContext) {
        //check email
        if (Utils.checkString(csv.getEmail())) {
            errors.add("Email is not empty!");
        } else if (!csv.getEmail().matches(emailRegex)) {
            errors.add("Invalid email format!");
        } else if (accountContext.getsAccountByEmail().contains(csv.getEmail())) {
            errors.add("Email was exist!");
        }
        //check userName
        if (Utils.checkString(csv.getUserName())) {
            errors.add("User name is not empty!");
        } else if (accountContext.getsAccountByUserName().contains(csv.getUserName())) {
            errors.add("UserName was exist!");
        }
        //check departmentID
        if (Utils.checkString(csv.getDepartmentID())) {
            errors.add("Department ID is not empty!");
        } else if (!checkID(csv.getDepartmentID())) {
            errors.add("Department ID is wrong!!");
        } else if (!accountContext.getDepartmentIDs().contains(Integer.parseInt(csv.getDepartmentID()))) {
            errors.add("Department ID is not exist!");
        }
        //check positionID
        if (Utils.checkString(csv.getPositionID())) {
            errors.add("Position ID is not empty!");
        } else if (!checkID(csv.getPositionID())) {
            errors.add("Position ID is wrong!!");
        } else if (!accountContext.getDepartmentIDs().contains(Integer.parseInt(csv.getPositionID()))) {
            errors.add("Position ID is not exist!");
        }
    }

    @Override
    public void saveAll(List<Account> entities) {
        try {
            accountRepository.createAccounts(entities);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void exportFileError(String pathError, List<ImportError> importErrors) {
        String firstLine = "User name, Full name, Email, department ID, position ID | Errors";
        writeErrorFile(pathError, firstLine, importErrors);
    }

}
