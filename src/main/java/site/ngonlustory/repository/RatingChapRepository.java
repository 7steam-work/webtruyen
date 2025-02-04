package site.ngonlustory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.ngonlustory.models.NotificationsEntity;
import site.ngonlustory.models.RatingsChapEntity;

@Repository
public interface RatingChapRepository extends JpaRepository<RatingsChapEntity, Integer> {
}
