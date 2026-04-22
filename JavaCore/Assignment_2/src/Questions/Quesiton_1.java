package Questions;

import Entities.Account;
import Entities.Department;

public class Quesiton_1 {
    public static void checkDepartment(Account account){
        Department department = account.getDepartment();
        if(account.getDepartment() == null){
            System.out.println("NV ch co phong ban");
        }else{
            System.out.println("Phong ban nv: " + department.getDepartmentName());
        }
    }
}
