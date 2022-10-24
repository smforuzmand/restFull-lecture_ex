package se.mohsen.restfulllecture_ex.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.mohsen.restfulllecture_ex.model.dto.UserDto;
import se.mohsen.restfulllecture_ex.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {




    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public ResponseEntity<UserDto> register(@RequestBody UserDto userDto) {
        System.out.println(userDto);

        userService.register(userDto);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
