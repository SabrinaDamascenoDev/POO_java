import java.util.*;
public class EmployeeTest {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        String firstName = sc.next();
        String lastName = sc.next();
        int salary = sc.nextInt();
        Employee employee = new Employee(id, salary, firstName, lastName);

        System.out.println(employee.getAnnualSalary());
        employee.setSalary(2400);
        System.out.println(employee.raiseSalary(20));
        System.out.println(employee.toString());
    }
}
