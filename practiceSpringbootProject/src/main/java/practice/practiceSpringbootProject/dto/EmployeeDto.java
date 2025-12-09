package practice.practiceSpringbootProject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("isActive")
    Boolean isActive;
    String Role;
    Double salary;
}
