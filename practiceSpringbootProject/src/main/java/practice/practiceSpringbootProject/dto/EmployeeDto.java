package practice.practiceSpringbootProject.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeDto {
    Long id;
    String name;
    String email;
    Integer age;
    LocalDate dateOfJoining;
    Boolean isActive;
    String Role;
    Double salary;
}
