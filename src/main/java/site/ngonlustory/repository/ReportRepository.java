package site.ngonlustory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.ngonlustory.models.RatingStoryEntity;
import site.ngonlustory.models.ReportEntity;

@Repository
public interface ReportRepository extends JpaRepository<ReportEntity, Integer> {
}
