package se.mohsen.restfulllecture_ex.repo;

import org.hibernate.sql.Update;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import se.mohsen.restfulllecture_ex.model.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

    @Modifying
    @Query("update User u set u.expired = :status where u.username = :username")
    void updateExpiredByUsername(@Param("username") String username , @Param("status") boolean status);


    @Modifying
    @Query("update User u set  u.password = :pw  where u.username = :un")
    void updatePasswordByUsername(@Param("un") String Username, @Param("pw") String password);

}
