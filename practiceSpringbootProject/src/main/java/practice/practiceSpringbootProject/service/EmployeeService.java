package practice.practiceSpringbootProject.service;

import practice.practiceSpringbootProject.dto.EmployeeDto;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public interface EmployeeService {

    Optional<EmployeeDto> getEmployeeById(Long id);
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    List<EmployeeDto> getAllEmployees();
    void deleteEmployee(Long id);

    EmployeeDto updateEmployeeById(EmployeeDto employeeDto,Long id);

    EmployeeDto updatePartialEmployee(Map<String, Object> updates, Long id);
}
