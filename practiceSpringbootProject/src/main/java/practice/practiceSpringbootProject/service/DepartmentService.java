package practice.practiceSpringbootProject.service;

import practice.practiceSpringbootProject.dto.DepartmentDto;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface DepartmentService {

    public DepartmentDto createDepartment(DepartmentDto departmentDto);
    public List<DepartmentDto> getAllDepartments();
    public Optional<DepartmentDto> getDepartmentById(Long id);
    public boolean deleteDepartment(Long id);
    public DepartmentDto updateDepartment(DepartmentDto departmentDto,Long id);
    public DepartmentDto updatePartialDepartment(Map<String,Object> updates, Long id);
}
