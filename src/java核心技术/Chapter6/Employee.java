package java核心技术.Chapter6;

/**
 * @ClassName Employee
 * @Date 2020/10/6 21:26
 * @Created by sakura
 **/
public class Employee implements Comparable<Employee> {

    private String name;
    private double salary;

    public Employee(String name, double salary){
        this.name = name;
        this.salary = salary;
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

    public void raiseSalary(double percent){
        double raise = salary * percent / 100;
        salary += raise;
    }

    @Override
    public int compareTo(Employee o) {
            // 在前面加了一个负号就表示从大到小排序了，这里其实意思就是我这个类实现了Comparable接口，那就必须实现Comparable接口的方法
            // 我理解成重载，接口中的方法并不需要实现，接口中没有实例域，定义不出来啊。。
            return -Double.compare(salary, o.salary);
    }
}
