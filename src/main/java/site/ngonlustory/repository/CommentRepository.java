package site.ngonlustory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.ngonlustory.models.CommentModel;

@Repository
public interface CommentRepository extends JpaRepository<CommentModel, Integer> {
}
