package practice.practiceSpringbootProject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import practice.practiceSpringbootProject.annotations.EmployeeRoleValidation;
import practice.practiceSpringbootProject.annotations.PrimeNumberValidation;

import java.time.LocalDate;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeDto {
    Long id;
    @NotBlank(message = "Employee name cannot be null!!!")
    @Size(min = 3,max = 50,message = "Number of characters in name should be in range [3,50]")
    String name;
    @Email(message = "Should be valid email")
    String email;
    @Min(value = 18 , message = "Age>=18")
    @Max(value = 60,message = "Age<=60")
    @PrimeNumberValidation
    Integer age;
    @PastOrPresent(message = "Date should be of past or present")
    LocalDate dateOfJoining;
    @JsonProperty("isActive")
    @AssertTrue(message = "employee should be active!")
    Boolean isActive;
  //  @Pattern(regexp = "^ADMIN|USER$",message = "Role should be User or admin")
    @EmployeeRoleValidation
    String Role;
    @Digits(integer = 6,fraction = 2,message = "Salary can be in form XXXXXX.YY")
    Double salary;
}
