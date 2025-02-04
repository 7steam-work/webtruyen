package site.ngonlustory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.ngonlustory.models.ChapterImageEntity;

@Repository
public interface ChapterImageRepository extends JpaRepository<ChapterImageEntity, Integer> {
}
