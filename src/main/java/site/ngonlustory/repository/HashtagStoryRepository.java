package site.ngonlustory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.ngonlustory.models.HashtagStoryEntity;

@Repository
public interface HashtagStoryRepository extends JpaRepository<HashtagStoryEntity, Integer> {
}
