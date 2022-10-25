package se.mohsen.restfulllecture_ex.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.mohsen.restfulllecture_ex.exception.ResourceNotFoundException;
import se.mohsen.restfulllecture_ex.model.dto.CustomeUserDto;
import se.mohsen.restfulllecture_ex.model.dto.UserDto;
import se.mohsen.restfulllecture_ex.service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public ResponseEntity<UserDto> register(@Valid @RequestBody UserDto userDto) {

//        we add this sout method to test the output of controller in the console
        System.out.println(userDto);

/* generally we can handle the exception  in the following way while we have introduced the handler to do that
        UserDto result = null;
        try {

            userService. register(userDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        }catch (ResourceNotFoundException ex){
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
*/

        UserDto result = userService.register(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);





    }



    @GetMapping({"username"})
    public ResponseEntity<CustomeUserDto> findByUsername(@PathVariable("username") String username) throws ResourceNotFoundException {


        return null;
    }

    @PutMapping("/disable")
    public ResponseEntity<Void>disableUser(@RequestParam("username") String username) throws ResourceNotFoundException {

        return null;
    }




    @GetMapping("/enable")
    public ResponseEntity<Void> enableUser(@RequestParam("username") String username) throws ResourceNotFoundException {
        return null;
    }





































}
