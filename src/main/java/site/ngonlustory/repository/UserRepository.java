package site.ngonlustory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import site.ngonlustory.models.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {

    @Query("SELECT user FROM UserModel user WHERE user.username = :value OR user.email = :value")
    UserModel findByUsernameOrEmail(@Param("value") String value);

}
