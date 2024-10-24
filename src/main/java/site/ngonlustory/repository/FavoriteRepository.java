package site.ngonlustory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.ngonlustory.models.FavoriteModel;

@Repository
public interface FavoriteRepository extends JpaRepository<FavoriteModel, Integer> {
}
