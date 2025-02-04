package site.ngonlustory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.ngonlustory.models.StoryEntity;

@Repository
public interface StoryRepository extends JpaRepository<StoryEntity, Integer> {
}
