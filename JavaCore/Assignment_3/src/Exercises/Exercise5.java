package Exercises;

import Entities.Department;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Exercise5 {
    public static void question1(Department department){
        System.out.println(department);
    }
    public static void question2(List<Department> departments){
        for(Department department: departments){
            System.out.println(department);
        }
    }
    public static boolean question4(Department department){
        return department.getDepartmentName().equals("Phòng A");
    }
    public static boolean question5(Department department1, Department department2){
        return department1.equals(department2);
    }
    public static void question6(Department[] depts) {
        Arrays.sort(depts, new Comparator<Department>() {
            @Override
            public int compare(Department d1, Department d2) {
                return d1.getDepartmentName().compareToIgnoreCase(d2.getDepartmentName());
            }
        });

        for (Department d : depts) {
            System.out.println(d);
        }
    }
}
