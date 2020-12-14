package java核心技术.Chapter4;

import java.time.LocalDate;

/**
 * @ClassName EmployeeTest
 * @Date 2020/10/1 16:47
 * @Created by sakura
 **/
public class EmployeeTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[2];

        staff[0] = new Employee("sakura", 10000, 1996, 9, 3);
        staff[1] = new Employee("chen", 2000, 1996, 3, 4);
        for (Employee employee:
             staff) {
            employee.raiseSalary(5);
        }

        for (Employee e :
                staff) {
            System.out.println("name="+e.getName()+",salary="+e.getSalary()+",hireDay="+e.getHireDay());

        }

    }
}

class Employee {
    private String name;
    private double salary;
    private LocalDate hireDay;

    public Employee(String n, double s, int year, int month, int day) {
        name = n;
        salary = s;
        hireDay = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void setHireDay(LocalDate hireDay) {
        this.hireDay = hireDay;
    }

    public void raiseSalary(double byPercent){
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}