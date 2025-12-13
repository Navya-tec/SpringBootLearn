package practice.practiceSpringbootProject.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {

    Long id;
    @Size(min = 3,max = 50,message = "Department name length should lie in range[3,50]")
    @NotBlank(message = "Department name cannot be null")
    String title;

    @JsonProperty(value = "isActive")
    @AssertTrue(message = "Department should be active!")
    @NotNull(message = "Department isActive cannot be null")
    Boolean isActive;
    @PastOrPresent(message = "Department should be created in past or present")
    LocalDate createdAt;
}
