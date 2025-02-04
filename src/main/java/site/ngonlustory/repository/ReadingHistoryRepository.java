package site.ngonlustory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.ngonlustory.models.RatingStoryEntity;

@Repository
public interface ReadingHistoryRepository extends JpaRepository<RatingStoryEntity, Integer> {
}
