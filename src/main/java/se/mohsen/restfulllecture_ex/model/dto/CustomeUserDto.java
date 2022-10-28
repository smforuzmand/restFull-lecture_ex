package se.mohsen.restfulllecture_ex.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomeUserDto {

    private String username;
    private List<RoleDto> roles;



}
