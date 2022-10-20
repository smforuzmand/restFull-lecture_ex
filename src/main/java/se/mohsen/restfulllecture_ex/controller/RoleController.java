package se.mohsen.restfulllecture_ex.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.mohsen.restfulllecture_ex.dto.RoleFormDto;
import se.mohsen.restfulllecture_ex.entity.Role;
import se.mohsen.restfulllecture_ex.repo.RoleRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class RoleController {


    private RoleRepository repository;


    @Autowired
    public RoleController(RoleRepository repository) {
        this.repository = repository;
    }


//    what kind of roles exist in this project?
//    How do we access it? through GetMapping
    /*
-I want to get through a specific URL
-What would I like to return?
  - return a ResponseEntity
 - what status? depend!
  -for find All we need to have a list
  Lets get list of our Role how?
     */

    @GetMapping("/api/v1/role")
    public ResponseEntity<List<Role>> findAll() {

        System.out.println("Get roles in this way");
        List<Role> roleList = repository.findAll();

        return ResponseEntity.ok(roleList);
    }

    //first we specify the parameters then we say that it is a path variable
// then we gonna find a way to address/access this path variable
// so the address in the get method must mach the path variable
    @GetMapping("/api/v1/role/{id}")
    public ResponseEntity<Role> findByRoleId(@PathVariable("id") Integer Id) {
        System.out.println("Id = " + Id);

//        repository would you please find by id
//        afterward can you save it in a Optional
//        if it was present, return our findById by ResponseEntity
        Optional<Role> findById = repository.findById(Id);
        return findById.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/api/v1/role/name")
    public ResponseEntity<Role> findByRoleName(@RequestParam("name") String name) {

        Optional<Role> findByName = repository.findByName(name);
        if (findByName.isPresent()) {
            return ResponseEntity.ok(findByName.get());

        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();


        }


    }

//    This has the same URL with the find all method but it has different mapping
//    this method is meant to test the message when the body is not implemented, it suppose to return a 500 status code
//    for this reason we mentioned the .NOT_Implemented
    // the first approach to fill in a form with Role entity
//    but the second approach will be using the RoleFormDto



   /*
    @PostMapping("/api/v1/role")
    public ResponseEntity<Role> create(@RequestBody Role role) {

        System.out.println("role = " + role);
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }*/

    @PostMapping("/api/v1/role")
    public ResponseEntity<Role> create(@RequestBody RoleFormDto roleForm) {

        System.out.println("roleForm = " + roleForm);
//        first we define a role object
//        according to the param we define a new objrc, both are the same
        Role role = new Role(roleForm.getId(), roleForm.getName());

//        adding new object to the repository and ctrl+alt+v to define and put it into a variable
        Role saveRole = repository.save(role);
//        final step is to change the not_implemented into the created and using body for implementing param
        return ResponseEntity.status(HttpStatus.CREATED).body(saveRole);
    }

    @DeleteMapping("/api/v1/role/{id}")
//    what do mean by Id
//    It is path variable which is called id
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
//        Now we are about to define a status to show the error while the id is nor exist
        if (repository.existsById(id)) {


            System.out.println("id = " + id);
            repository.deleteById(id);

            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    // @RequestMapping(method = RequestMethod.PUT)
    @PostMapping("/api/v1/role/")
    public ResponseEntity<Void> updateContent(@PathVariable("id") Integer id, @RequestBody RoleFormDto roleForm) {

        System.out.println("roleForm = " + roleForm);
        System.out.println("id = " + id);
        if (id .equals(roleForm.getId()) ) {
            Role role = new Role(roleForm.getId(), roleForm.getName());
            repository.save(role);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {

            return ResponseEntity.status(418).build();
//416 as well
        }

    }

}