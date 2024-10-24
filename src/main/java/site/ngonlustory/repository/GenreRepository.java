package site.ngonlustory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.ngonlustory.models.GenreModel;

@Repository
public interface GenreRepository extends JpaRepository<GenreModel, Integer> {
}
