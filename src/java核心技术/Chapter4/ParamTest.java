package java核心技术.Chapter4;

import java.sql.SQLOutput;
import java.time.LocalDate;

/**
 * @ClassName ParamTest
 * @Date 2020/10/3 15:36
 * @Created by sakura
 **/
// 测试一下方法参数部分的内容，java中，一个方法不能修改一个基本数据类型的参数。
public class ParamTest {
    public static void main(String[] args) {
        // test1: 方法不能修改一个基本数据类型的参数
        System.out.println("测试 tripleValue");
        double percent = 10;
        System.out.println("方法开始前：percent="+percent);
        tripleValue(percent);
        System.out.println("方法结束后：percent="+percent);

        /*
        test2: 方法可以修改对象引用参数的状态，也就是说将一个对象引用传递到一个方法中作为参数，方法是可以
        改变这个对象中的状态的。
         */
        System.out.println("测试 方法能够改变对象引用所指对象的状态");
        Employee harry = new Employee("Harry", 20000, 1996, 9, 3);
        System.out.println("方法开始前：harry‘s salary ="+harry.getSalary());
        tripSalary(harry);
        System.out.println("方法结束后：harry's salary ="+harry.getSalary());

        /*
        test3:一个方法不能让对象参数引用一个新的对象
         */
        System.out.println("测试一个方法不能让对象参数引用一个新的对象");
        Employee a = new Employee("sakura", 10000, 1996, 9, 3);
        Employee b = new Employee("heel", 34344, 1999, 3, 4);
        System.out.println("方法开始前，a="+a.getName());
        System.out.println("方法开始前，b="+b.getName());
        swap(a, b);
        System.out.println("方法结束后，a="+a.getName());
        System.out.println("方法结束后，b="+b.getName());
    }
    public static void tripleValue(double x){  // doesn't work
        x = 3 * x;
        System.out.println("方法结束之后：x="+x);
    }

    public static void tripSalary(Employee x){ // work
        x.raiseSalary(200);
        System.out.println("方法结束之后：salary="+x.getSalary());
    }

    public static void swap(Employee a, Employee b){
        Employee temp = a;
        a = b;
        b = temp;
        System.out.println("方法结束之后：a="+a.getName());
        System.out.println("方法结束之后：b="+b.getName());
    }
}
