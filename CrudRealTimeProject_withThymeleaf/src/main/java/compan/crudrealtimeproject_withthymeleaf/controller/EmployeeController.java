package compan.crudrealtimeproject_withthymeleaf.controller;
import compan.crudrealtimeproject_withthymeleaf.entity.Employee;
import compan.crudrealtimeproject_withthymeleaf.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService service;
    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }
    @GetMapping("/list")
    public String listEmployees(Model model){
        List<Employee> theEmployee=service.getEmployeeList();
        model.addAttribute("employees",theEmployee);
        return "list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        Employee employee=new Employee();
        model.addAttribute("employee",employee);
        return "employee-form";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") Integer id, Model model){
        Optional<Employee> employee=service.getEmployeeById(id);
        model.addAttribute("employee",employee);
        return "employee-form";

    }
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee")Employee employee){
        service.save(employee);
        return "redirect:/employees/list";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id){
        service.deleteById(id);
        return "redirect:/employees/list";
    }


}
