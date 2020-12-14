package java核心技术.Chapter6;

import java.util.Arrays;

/**
 * @ClassName EmployeeSortTest
 * @Date 2020/10/6 21:26
 * @Created by sakura
 **/
public class EmployeeSortTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("sakurasa", 10000);
        staff[1] = new Employee("chenzhen", 20000);
        staff[2] = new Employee("saku1996", 15000);

        Arrays.sort(staff);

        for (Employee employee:
             staff) {
            System.out.println("name="+employee.getName()+", salary="+employee.getSalary());


        }
    }
}
