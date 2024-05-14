package uz.pdp.g34springbootjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.g34springbootjpa.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
