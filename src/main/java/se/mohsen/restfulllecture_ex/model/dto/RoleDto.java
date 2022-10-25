package se.mohsen.restfulllecture_ex.model.dto;


import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RoleDto {

    private Integer id;

    @NotBlank
    @Size(min = 2, max = 40, message = "Role must not be a null")
    private String name;


}


//I will chanege the name of the class to the RoleDto in sake of simplicity