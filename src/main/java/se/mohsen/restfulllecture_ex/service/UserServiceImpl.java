package se.mohsen.restfulllecture_ex.service;




import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import se.mohsen.restfulllecture_ex.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.mohsen.restfulllecture_ex.model.dto.RoleDto;
import se.mohsen.restfulllecture_ex.model.dto.UserDto;
import se.mohsen.restfulllecture_ex.model.entity.User;
import se.mohsen.restfulllecture_ex.repo.RoleRepository;
import se.mohsen.restfulllecture_ex.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private final ModelMapper modelMapper;


    @Autowired
    public UserServiceImpl(UserRepository userRepository , RoleRepository roleRepository , ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public UserDto register(UserDto userDto) throws ResourceNotFoundException {
//we gonna check if the input data is valid

        if (userDto.isExpired()) throw new IllegalArgumentException("userDto status is expired");
        if (userDto == null) throw new IllegalArgumentException("userDto is null");
        if (userDto.getUsername() == null) throw new IllegalArgumentException("userDto username is null");
        if (userDto.getPassword() == null) throw new IllegalArgumentException("userDto password is null");
        if(userDto.getRoles()==null || userDto.getRoles().size()==0)
            throw new IllegalArgumentException("No Roles found");
        
//        Check if the username is duplicate
        
        if (userRepository.existsByUsername(userDto.getUsername()))
            throw new IllegalArgumentException("Username is already in use");
//        check if the Roles are valid Roles
        for (RoleDto roleDto: userDto.getRoles())
        {
            roleRepository.findById(roleDto.getId()).orElseThrow(() -> new ResourceNotFoundException("Role ID is not valid"));
        }
//        Convert Dto An Entity UserDto -> User + RoleDto -> Role  we do that via objectMapper
        User convertedToEntity = modelMapper.map(userDto, User.class);

        System.out.println("convertedToEntity = " + convertedToEntity);
//        Save entity to the Database

        User createdUser = userRepository.save(convertedToEntity);
        System.out.println("createdUser = " + createdUser);

//        convert the Entity to Dto Role -> RoleDto +User -> UserDto

        UserDto convertedToDto = modelMapper.map(createdUser, UserDto.class);

//        return Dto
        return convertedToDto;
    }

    public void disableUserByUsername(String username) throws  ResourceNotFoundException {

    }

    public void enableUserByUsername(String username) throws ResourceNotFoundException {

    }


}
