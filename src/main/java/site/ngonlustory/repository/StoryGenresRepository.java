package site.ngonlustory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.ngonlustory.models.GenresEntity;
import site.ngonlustory.models.StoryEntity;
import site.ngonlustory.models.StoryGenresEntity;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface StoryGenresRepository extends JpaRepository<StoryGenresEntity, Integer> {

    List<StoryGenresEntity> findByGenresModel(GenresEntity genresModel);

    List<StoryGenresEntity> findByStoryEntityIn(Collection<StoryEntity> storyEntities);
}
