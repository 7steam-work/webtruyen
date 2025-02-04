package site.ngonlustory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.ngonlustory.models.HashtagsEntity;

@Repository
public interface HashtagRepository extends JpaRepository<HashtagsEntity, Integer> {
}
