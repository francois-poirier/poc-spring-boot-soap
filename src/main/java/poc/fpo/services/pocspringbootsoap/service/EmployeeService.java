package poc.fpo.services.pocspringbootsoap.service;

import com.fpo.poc_spring_boot_soap.Employee;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService {

    private static final Map<String, Employee> employees = new HashMap<String, Employee>();

    @PostConstruct
    public void initialize() {

        Employee john = new Employee();
        john.setName("John");
        john.setEmpId(54321);
        john.setSalary(1500);
        Employee.Address johnAdress = new Employee.Address();
        johnAdress.setAddressLine1("foo");
        johnAdress.setAddressLine2("foo2");
        johnAdress.setCountry("Spain");
        johnAdress.setState("Madrid");
        johnAdress.setZip((short) 28054);
        john.setAddress(johnAdress);

        Employee samuel = new Employee();
        samuel.setName("Samuel");
        samuel.setEmpId(12345);
        samuel.setSalary(2000);
        Employee.Address samuelAdress = new Employee.Address();
        samuelAdress.setAddressLine1("bar");
        samuelAdress.setAddressLine2("bar2");
        samuelAdress.setCountry("Spain");
        samuelAdress.setState("Madrid");
        samuelAdress.setZip((short) 28033);
        samuel.setAddress(samuelAdress);


        employees.put(john.getName(), john);
        employees.put(samuel.getName(), samuel);
    }

    public Employee getEmployee(String name) {
        return employees.get(name);
    }
}
