package se.mohsen.restfulllecture_ex.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.mohsen.restfulllecture_ex.model.dto.UserDto;
import se.mohsen.restfulllecture_ex.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService{


    UserRepository userRepository;

@Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto register(UserDto userDto) {
        return null;
    }
}
