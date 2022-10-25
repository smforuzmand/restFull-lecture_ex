package se.mohsen.restfulllecture_ex.model.dto;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "password")
public class UserDto {


    @NotBlank
    @Size(min = 2, max = 40, message = "username must be at least 2 characters")

    @NotBlank
    @Size(min = 8, max = 60, message = "Must be more than 8 character.")

    @Pattern(regexp = "Password restrictions")
    @Size(min = 2, max = 30, message = "must be between two and 30")
    private String username;
    private String password;
    private boolean expired;


    @NonNull
//    this is a list of
    @Valid//if we want to activate some validation in the other dto like RoleDto
    private List<RoleDto> roles;


}
