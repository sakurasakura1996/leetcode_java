package 每日一题.problem690_员工的重要性;

import java.util.*;

class Employee{
    public int id;
    public int importance;
    public List<Integer> subordinates;
}
public class Solution {
    Map<Integer, Employee> map = new HashMap<>();
    public int getImportance(List<Employee> employees, int id){
        Map<Integer, Employee> hashMap = new HashMap<Integer, Employee>();
        for (Employee e :
                employees) {
            hashMap.put(e.id, e);
        }
        Deque<Employee> deque = new ArrayDeque<>();
        deque.add(hashMap.get(id));
        int ans = 0;
        while (!hashMap.isEmpty()){
            Employee employee = deque.poll();
            ans += employee.importance;
            for (int i :
                    employee.subordinates) {
                deque.add(hashMap.get(i));
            }
        }
        return ans;
    }

    public int getImportance2(List<Employee> employees, int id){
        for (Employee employee :
                employees) {
            map.put(employee.id, employee);
        }
        return dfs(id);
    }
    public int dfs(int id){
        Employee employee = map.get(id);
        int total = employee.importance;
        List<Integer> subordinates = employee.subordinates;
        for (int subIdx :
                subordinates) {
            total += dfs(subIdx);
        }
        return total;
    }
}
