package uz.pdp.g34springbootjpa.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.pdp.g34springbootjpa.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     JPQL
     * */
    @Query(value = "SELECT u FROM User u WHERE u.username=?1")
    User customFindByUsername(String username);

    @Query(value = "SELECT u FROM User u WHERE u.username = :username")
    User findByUsernameByParam(@Param("username") String username);

    @Query(value = "SELECT u FROM User u WHERE u.username = :username")
    User findByUsernameWithoutParamParam(String username);

    @Query(value = "SELECT u FROM users u  WHERE u.email = :email", nativeQuery = true)
    User findByEmail(String email);

    User findByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.username = ?1 AND u.enabled = ?2")
    User findByUsernameAndEnabled(String username, boolean enabled);

    @Query("SELECT u FROM User u WHERE u.username = ?1 AND u.enabled IS TRUE")
    User findByUsernameAndEnabledEqualsTrue(String username);

    @Query("SELECT u FROM User u WHERE u.enabled = :enabled")
    Page<User> findAllByEnabledOrderByUsernameAsc(boolean enabled, Pageable pageable);


}
