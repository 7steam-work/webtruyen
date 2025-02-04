package site.ngonlustory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.ngonlustory.models.ChapterEntity;

@Repository
public interface ChaptersRepository extends JpaRepository<ChapterEntity, Integer> {
}
