package site.ngonlustory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.ngonlustory.models.StoryGenresEntity;

@Repository
public interface StoryGenresRepository extends JpaRepository<StoryGenresEntity, Integer> {
}
