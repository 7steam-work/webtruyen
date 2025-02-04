package site.ngonlustory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.ngonlustory.models.CommentsEntity;

@Repository
public interface CommentRepository extends JpaRepository<CommentsEntity, Integer> {
}
