package se.mohsen.restfulllecture_ex.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@OpenAPIDefinition(info= @Info(title = "REST API lecture exe" , version = "0.1" ,description = "replicating whatever has been done"))
@Configuration
public class AppConfig {

@Bean
    public ModelMapper modelMapper() {
    return new ModelMapper();
    }








}
