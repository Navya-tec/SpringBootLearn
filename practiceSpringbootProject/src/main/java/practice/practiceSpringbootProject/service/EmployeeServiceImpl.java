package practice.practiceSpringbootProject.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import practice.practiceSpringbootProject.dto.EmployeeDto;
import practice.practiceSpringbootProject.entity.EmployeeEntity;
import practice.practiceSpringbootProject.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    @Override
    public EmployeeDto getEmployeeById(Long id) {
       EmployeeEntity employeeEntity=employeeRepository
               .findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));;
       return modelMapper.map(employeeEntity, EmployeeDto.class);
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity=employeeRepository.save(modelMapper.map(employeeDto, EmployeeEntity.class));
        return modelMapper.map(employeeEntity, EmployeeDto.class);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeEntity> employeeEntities=employeeRepository.findAll();
        return employeeEntities.stream().map(entity->modelMapper.map(entity, EmployeeDto.class)).toList();
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
        return;
    }

    @Override
    public EmployeeDto updateEmployeeById(EmployeeDto employeeDto,Long id) {

        EmployeeEntity employeeEntity=employeeRepository.findById(id).orElse(null);
        if(employeeEntity==null){
           EmployeeEntity newEmployeeEntity=modelMapper.map(employeeDto,EmployeeEntity.class);
         //  newEmployeeEntity.setId(id);
           employeeRepository.save(newEmployeeEntity);
           return modelMapper.map(newEmployeeEntity, EmployeeDto.class);
        }

        modelMapper.map(employeeDto,employeeEntity);
        EmployeeEntity updated=employeeRepository.save(employeeEntity);
        return modelMapper.map(updated, EmployeeDto.class);
    }
}
