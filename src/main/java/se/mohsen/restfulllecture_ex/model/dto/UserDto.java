package se.mohsen.restfulllecture_ex.model.dto;

import lombok.*;

import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "password")
public class UserDto {

    private String username;
    private String password;
    private boolean expired;
    private List<RoleDto> roles;


}
