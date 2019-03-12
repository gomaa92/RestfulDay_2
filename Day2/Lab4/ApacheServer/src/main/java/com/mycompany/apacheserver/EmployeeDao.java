/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apacheserver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ahmed
 */
public class EmployeeDao {
    
    private static final Map<String, Employee> employeesMap = new HashMap<String, Employee>();
 
    static {
        initEmps();
    }
 
    private static void initEmps() {
        Employee emp1 = new Employee("01", "Ahmed", "Clerk");
        Employee emp2 = new Employee("02", "gomaa", "Salesman");
        Employee emp3 = new Employee("03", "kamal", "Manager");
 
        employeesMap.put(emp1.getId(), emp1);
        employeesMap.put(emp2.getId(), emp2);
        employeesMap.put(emp3.getId(), emp3);
    }
 
    public static Employee getEmployee(String empNo) {
        return employeesMap.get(empNo);
    }
 
    public static Employee addEmployee(Employee emp) {
        employeesMap.put(emp.getId(), emp);
        return emp;
    }
 
    public static Employee updateEmployee(Employee emp) {
        employeesMap.put(emp.getId(), emp);
        return emp;
    }
 
    public static void deleteEmployee(String empNo) {
        employeesMap.remove(empNo);
    }
 
    public static List<Employee> getAllEmployees() {
        Collection<Employee> c = employeesMap.values();
        List<Employee> list = new ArrayList<Employee>();
        list.addAll(c);
        return list;
    }
     
    List<Employee> list;
    
}