package compan.crudrealtimeproject_withthymeleaf.service;

import compan.crudrealtimeproject_withthymeleaf.entity.Employee;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getEmployeeList();
    Optional<Employee> getEmployeeById(Integer id);
    void save (Employee employee);
    void deleteById(Integer id);
}
