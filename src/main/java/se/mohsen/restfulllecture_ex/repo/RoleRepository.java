package se.mohsen.restfulllecture_ex.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import se.mohsen.restfulllecture_ex.entity.Role;

import java.util.Optional;


public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String integer);




}
