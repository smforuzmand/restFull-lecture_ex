package se.mohsen.restfulllecture_ex.service;

import se.mohsen.restfulllecture_ex.model.dto.RoleDto;

import java.util.List;

public interface RoleService {

//what do we want to handle
//    now we want toextract those methos which are excessive and reluctant in the controller in sake of sepratiion of concerns


    RoleDto create(RoleDto Form);

    void update(RoleDto form, Integer id);

    void deleteById(Integer id);
    List<RoleDto> findAll();

    RoleDto findById(Integer id);

    RoleDto findByName(String name);




}
