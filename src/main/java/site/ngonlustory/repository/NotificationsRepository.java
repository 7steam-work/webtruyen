package site.ngonlustory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.ngonlustory.models.NotificationsEntity;

@Repository
public interface NotificationsRepository extends JpaRepository<NotificationsEntity, Integer> {
}
