package practice.practiceSpringbootProject.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import practice.practiceSpringbootProject.dto.DepartmentDto;
import practice.practiceSpringbootProject.entity.DepartmentEntity;
import practice.practiceSpringbootProject.repository.DepartmentRepository;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{

    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
         DepartmentEntity departmentEntity=departmentRepository.save(modelMapper.map(departmentDto,DepartmentEntity.class));
         return modelMapper.map(departmentEntity,DepartmentDto.class);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<DepartmentEntity> departments=departmentRepository.findAll();
        return departments.stream().map(e->modelMapper.map(e,DepartmentDto.class)).toList();
    }

    @Override
    public Optional<DepartmentDto> getDepartmentById(Long id) {
        Optional<DepartmentEntity> departmentEntity=departmentRepository.findById(id);
        return departmentEntity.map(d->modelMapper.map(d,DepartmentDto.class));
    }

    @Override
    public boolean deleteDepartment(Long id) {
        Boolean isExist=departmentRepository.existsById(id);
        if(!isExist) return false;
        departmentRepository.deleteById(id);
        return true;
    }

    @Override
    public  DepartmentDto updateDepartment(DepartmentDto departmentDto, Long id) {
      DepartmentEntity departmentEntity= departmentRepository.findById(id).orElse(null);

//        departmentEntity.setName(departmentDto.getName());
//        departmentEntity.setIsActive(departmentDto.getIsActive());
//        departmentEntity.setCreatedAt(departmentDto.getCreatedAt());
        modelMapper.map(departmentDto,departmentEntity);
        DepartmentEntity updated=departmentRepository.save(departmentEntity);
        return modelMapper.map(updated,DepartmentDto.class);
    }

    @Override
    public DepartmentDto updatePartialDepartment(Map<String, Object> updates, Long id) {

        DepartmentEntity departmentEntity=departmentRepository.findById(id).orElseThrow(()->new RuntimeException("Department with gicven id not found! Partial Update"));

        updates.forEach((key,val)->{
            Field field=ReflectionUtils.findField(DepartmentEntity.class,key);
            field.setAccessible(true);
            ReflectionUtils.setField(field,departmentEntity,val);
        });

        DepartmentEntity newUpdatedDepartment=departmentRepository.save(departmentEntity);
        return modelMapper.map(newUpdatedDepartment,DepartmentDto.class);
    }
}
