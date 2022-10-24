package se.mohsen.restfulllecture_ex.model.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.DETACH;
import static javax.persistence.CascadeType.REFRESH;

@Entity
@Data
@Table(name = "users")
public class User {


    @Id
    @Column(unique = true, updatable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    private boolean expired;


    //    it might have to one to many so it is a many to many
//    uni directional many to many
    @ManyToMany(cascade = {DETACH, REFRESH}, fetch = FetchType.EAGER)
    @JoinTable(name = "USER_ROLES",
            joinColumns = {@JoinColumn(name = "USERNAME")},
            inverseJoinColumns = {@JoinColumn(name = "Roel_ID")}

    )
    private Set<Role> roles;

//    convinient method for adding

    public void addRole(Role role) {
        if (role ==null) throw new IllegalArgumentException("Role should not be null");
        if (roles == null) roles = new HashSet<>();

        roles.add(role);
    }



    public void removeRole(Role role) {
        if (role ==null) throw new IllegalArgumentException("Role should not be null");
        if (roles != null) roles .remove(role);
    }


}
