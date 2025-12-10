package practice.practiceSpringbootProject.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import practice.practiceSpringbootProject.dto.EmployeeDto;
import practice.practiceSpringbootProject.service.EmployeeService;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping(path = "/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmpoyees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable(name = "employeeId") Long id){
        Optional<EmployeeDto> employeeDto=  employeeService.getEmployeeById(id);
        return employeeDto.map(employeeDto1 -> ResponseEntity.ok(employeeDto1)).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(path = "/create")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody @Valid EmployeeDto body){
         EmployeeDto savedEmployeeDto=employeeService.createEmployee(body);
         return new ResponseEntity<>(savedEmployeeDto, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDto> updateEmployeeById(@RequestBody EmployeeDto body,@PathVariable(name = "employeeId") Long id){
        return ResponseEntity.ok(employeeService.updateEmployeeById(body,id));
    }

    @PatchMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody Map<String, Object> updates, @PathVariable Long id){
        EmployeeDto updatedPartialEmployee = employeeService.updatePartialEmployee(updates,id);
        return ResponseEntity.ok(updatedPartialEmployee);
    }

    @DeleteMapping(path = "/{employeeId}")
    public void deleteEmployee(@PathVariable(name = "employeeId") Long id){
            employeeService.deleteEmployee(id);
    }
}
