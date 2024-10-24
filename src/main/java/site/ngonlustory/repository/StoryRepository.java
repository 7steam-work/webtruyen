package site.ngonlustory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.ngonlustory.models.StoryModel;

@Repository
public interface StoryRepository extends JpaRepository<StoryModel, Integer> {
}
