package practice.practiceSpringbootProject.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import practice.practiceSpringbootProject.dto.DepartmentDto;
import practice.practiceSpringbootProject.entity.DepartmentEntity;

@Configuration
public class MapperConfig {
    @Bean
    public ModelMapper modelMapper(){

        return new ModelMapper();

    }
}
