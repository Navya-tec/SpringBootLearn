package practice.practiceSpringbootProject.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import practice.practiceSpringbootProject.dto.EmployeeDto;
import practice.practiceSpringbootProject.entity.EmployeeEntity;
import practice.practiceSpringbootProject.repository.EmployeeRepository;
import org.springframework.util.ReflectionUtils;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    @Override
    public Optional<EmployeeDto> getEmployeeById(Long id) {
       Optional<EmployeeEntity> employeeEntity=employeeRepository
               .findById(id);
       return employeeEntity.map(e-> modelMapper.map(e, EmployeeDto.class));
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
        boolean isExists=isExistsByEmployeeId(id);
        if(!isExists) return;
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

    @Override
    public EmployeeDto updatePartialEmployee(Map<String,Object> updates, Long id) {
        boolean isExists=isExistsByEmployeeId(id);
        if(!isExists) return null;

        EmployeeEntity employeeEntity=employeeRepository.findById(id).get();

        updates.forEach((key,val)->{
           Field fieldToUpdate= ReflectionUtils.findField(EmployeeEntity.class,key);
           fieldToUpdate.setAccessible(true);
           ReflectionUtils.setField(fieldToUpdate,employeeEntity,val);
        });

        EmployeeEntity updatedEntity=employeeRepository.save(employeeEntity);

        return modelMapper.map(updatedEntity, EmployeeDto.class);
    }

    public boolean isExistsByEmployeeId(Long id){
        return employeeRepository.existsById(id);
    }
}
