package se.mohsen.restfulllecture_ex.service;

import org.hibernate.ObjectNotFoundException;
import se.mohsen.restfulllecture_ex.exception.ResourceNotFoundException;
import se.mohsen.restfulllecture_ex.model.dto.CustomeUserDto;
import se.mohsen.restfulllecture_ex.model.dto.UserDto;

public interface UserService {
     UserDto register(UserDto userDto) throws ResourceNotFoundException;

     CustomeUserDto findByUsername(String username) throws ResourceNotFoundException;

     void disableUserByUsername(String username) throws ResourceNotFoundException;

     void enableUserByUsername(String username) throws ResourceNotFoundException;

}
