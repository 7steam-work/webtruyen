package site.ngonlustory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.ngonlustory.models.StoryGenreModel;

@Repository
public interface StoryGenreRepository extends JpaRepository<StoryGenreModel, Integer> {
}
