package practice.practiceSpringbootProject.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import practice.practiceSpringbootProject.dto.DepartmentDto;
import practice.practiceSpringbootProject.service.DepartmentService;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping("/{departmentId}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable(name = "departmentId") Long id){
         Optional<DepartmentDto> departmentDto=departmentService.getDepartmentById(id);
         return departmentDto.map(d->ResponseEntity.ok(d)).orElseThrow( ()-> new RuntimeException("department not found!Try again"));
    }


    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments(){
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @PostMapping("/create")
    public ResponseEntity<DepartmentDto> createDepartment(@Valid @RequestBody DepartmentDto body){
        DepartmentDto savedDepartmentDto=  departmentService.createDepartment(body);
        return new ResponseEntity<>(savedDepartmentDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{departmentId}")
    public ResponseEntity<Boolean> deleteDepartment(@PathVariable(name = "departmentId") Long id){
         Boolean isDeleted= departmentService.deleteDepartment(id);
         if(!isDeleted) return ResponseEntity.notFound().build();
         return ResponseEntity.ok(isDeleted);
    }

    @PutMapping("/{departmentId}")
    public ResponseEntity<DepartmentDto> updateDepartment(@Valid @RequestBody DepartmentDto body,@PathVariable(name = "departmentId") Long id){
        return ResponseEntity.ok(departmentService.updateDepartment(body,id));
    }

    @PatchMapping("/{departmentId}")
    public ResponseEntity<DepartmentDto> updatedPartialDepartment(@RequestBody Map<String,Object> updates, @PathVariable(name = "departmentId") Long id ){
        DepartmentDto departmentDto= departmentService.updatePartialDepartment(updates,id);
        if (departmentDto==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(departmentDto);
    }
}
