package site.ngonlustory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.ngonlustory.models.ChapterModel;

@Repository
public interface ChapterRepository extends JpaRepository<ChapterModel, Integer> {
}
