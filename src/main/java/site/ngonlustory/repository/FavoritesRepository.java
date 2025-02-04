package site.ngonlustory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.ngonlustory.models.FavoritesEntity;

@Repository
public interface FavoritesRepository extends JpaRepository<FavoritesEntity, Integer> {
}
