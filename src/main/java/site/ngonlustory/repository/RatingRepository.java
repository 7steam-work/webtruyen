package site.ngonlustory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.ngonlustory.models.RatingModel;

@Repository
public interface RatingRepository extends JpaRepository<RatingModel, Integer> {
}
