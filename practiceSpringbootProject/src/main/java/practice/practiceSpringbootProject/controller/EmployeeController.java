package practice.practiceSpringbootProject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import practice.practiceSpringbootProject.dto.EmployeeDto;
import practice.practiceSpringbootProject.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping(path = "/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    @GetMapping
    public List<EmployeeDto> getAllEmpoyees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping(path = "/{employeeId}")
    public EmployeeDto getEmployeeById(@PathVariable(name = "employeeId") Long id){
        return employeeService.getEmployeeById(id);
    }

    @PostMapping(path = "/create")
    public EmployeeDto createEmployee(@RequestBody EmployeeDto body){
        return employeeService.createEmployee(body);
    }

    @PutMapping(path = "/{employeeId}")
    public EmployeeDto updateEmployeeById(@RequestBody EmployeeDto body,@PathVariable(name = "employeeId") Long id){
        return employeeService.updateEmployeeById(body,id);
    }

//    @PatchMapping(path = "/{employeeId}")
//    public EmployeeDto updateEmployee(@RequestBody EmployeeDto body){
//
//    }

    @DeleteMapping(path = "/{employeeId}")
    public void deleteEmployee(@PathVariable(name = "employeeId") Long id){
        employeeService.deleteEmployee(id);
    }
}
