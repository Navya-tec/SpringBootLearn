package practice.practiceSpringbootProject.service;

import practice.practiceSpringbootProject.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto getEmployeeById(Long id);
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    List<EmployeeDto> getAllEmployees();
    void deleteEmployee(Long id);

    EmployeeDto updateEmployeeById(EmployeeDto employeeDto,Long id);
}
