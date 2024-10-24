package site.ngonlustory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.ngonlustory.models.ChapterImageModel;

@Repository
public interface ChapterImageRepository extends JpaRepository<ChapterImageModel, Integer> {
}
