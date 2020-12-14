package java核心技术.Chapter9;

import com.sun.xml.internal.ws.config.management.policy.ManagementPolicyValidator;
import java核心技术.Chapter6.Employee;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MapTest
 * @Date 2020/12/8 11:58
 * @Created by sakura
 * 分析：
 **/
public class MapTest {
    public static void main(String[] args) {
        Map<String, Employee> map = new HashMap<>();
        map.put("001", new Employee("sakura", 190));
        map.put("002", new Employee("chen", 345));
        map.put("003", new Employee("sakura2", 453));

        System.out.println(map);

        //remove an entry
        map.remove("001");

        // replace an entry
        map.put("002", new Employee("chenzhengyun", 45));

        // look up a value
        System.out.println(map.get("002"));

        // iterate through all entries
        map.forEach((k, v) -> System.out.println("key = " + k + ",value = "+ v));
    }
}
