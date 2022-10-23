package se.mohsen.restfulllecture_ex.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import se.mohsen.restfulllecture_ex.exception.ResourceNotFoundException;
import se.mohsen.restfulllecture_ex.model.dto.RoleDto;
import se.mohsen.restfulllecture_ex.model.entity.Role;
import se.mohsen.restfulllecture_ex.repo.RoleRepository;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {


    private final RoleRepository repository;

    private final ModelMapper modelMapper;

    @Autowired
    public RoleServiceImpl(RoleRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;

    }


    @Override
    public RoleDto create(RoleDto form) {

        Role toEntity = modelMapper.map(form, Role.class);

        Role saveRole = repository.save(toEntity);
        return modelMapper.map(saveRole, RoleDto.class);
    }

    @Override
    public void update(RoleDto form, Integer id) {
        if (form == null) throw new ResourceNotFoundException("form doesnt exist");
        if (id == null) throw new ResourceNotFoundException("Id is null");
        if (!id.equals(form.getId())) throw new ResourceNotFoundException("Id miss match");
        Role role = modelMapper.map(form, Role.class);
        repository.save(role);


    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);

    }

    @Override
    public List<RoleDto> findAll() {

        List<Role> roleList = repository.findAll();

        return modelMapper.map(roleList, new TypeToken<List<RoleDto>>() {
        }.getType());
    }


    @Override
    public RoleDto findById(Integer id) {


        if (id == null) throw new IllegalArgumentException("id was null");

        Role foundById = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Role data not found"));

        return modelMapper.map(foundById, RoleDto.class);
    }

    @Override
    public RoleDto findByName(String name) {

        if (name == null) throw new IllegalArgumentException("name is null");

        Role foundByName = repository.findByName(name).orElseThrow(
                () -> new ResourceNotFoundException("Role data not found")
        );

        return modelMapper.map(foundByName, RoleDto.class);
    }
}
//we have removed redundant variables into inline