package site.ngonlustory.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.ngonlustory.models.StoryEntity;

import java.util.Collection;

@Repository
public interface StoryRepository extends JpaRepository<StoryEntity, Integer> {
    Page<StoryEntity> findByIdIn(Collection<Integer> ids, Pageable pageable);

}
