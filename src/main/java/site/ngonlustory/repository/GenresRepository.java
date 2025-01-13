package site.ngonlustory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.ngonlustory.models.RoleEntity;

@Repository
public interface GenresRepository extends JpaRepository<RoleEntity, Integer> {
}
