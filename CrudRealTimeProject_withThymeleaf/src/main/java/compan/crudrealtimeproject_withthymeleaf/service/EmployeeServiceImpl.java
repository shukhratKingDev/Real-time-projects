package compan.crudrealtimeproject_withthymeleaf.service;

import compan.crudrealtimeproject_withthymeleaf.entity.Employee;
import compan.crudrealtimeproject_withthymeleaf.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeServiceImpl implements  EmployeeService{
    private final EmployeeRepository repository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Employee> getEmployeeList() {
        return repository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public void save(Employee employee) {
        repository.save(employee);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
