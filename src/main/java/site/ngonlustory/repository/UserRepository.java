package site.ngonlustory.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import site.ngonlustory.models.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByUsername(String username);

    UserEntity findByUsernameAndRoleId(String username, Integer roleId);
}
