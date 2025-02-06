package site.ngonlustory.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.ngonlustory.models.ChapterEntity;
import site.ngonlustory.models.StoryEntity;

import java.util.List;

@Repository
public interface ChaptersRepository extends JpaRepository<ChapterEntity, Integer> {
    List<ChapterEntity> findByStoryEntity(StoryEntity storyEntity, Pageable pageable);
    List<ChapterEntity> findByStoryEntity(StoryEntity storyEntity);
}
