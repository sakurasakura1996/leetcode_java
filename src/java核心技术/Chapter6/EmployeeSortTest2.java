package java核心技术.Chapter6;

import java.util.Arrays;

/**
 * @ClassName EmployeeSortTest2
 * @Date 2020/12/8 16:00
 * @Created by sakura
 * 分析： 这里想实现 sort方法能够对Employee对象数组进行排序，前提是要确保Employee类实现了Comparable接口
 **/
public class EmployeeSortTest2 {

    public static void main(String[] args) {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("sakura", 1000);
        staff[1] = new Employee("hello", 2000);
        staff[2] = new Employee("world", 3000);

        Arrays.sort(staff, 0, 2);  // Employee类的定义中，实现compareTo方法是对Employee类中的salary进行倒序排序。

        for (Employee e :
                staff) {
            System.out.println(e.getName()+"'s salary is:" + e.getSalary());
        }
    }

}
