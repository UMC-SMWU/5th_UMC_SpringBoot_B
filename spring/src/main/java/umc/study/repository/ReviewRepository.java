package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.review;

public interface ReviewRepository extends JpaRepository<review, Long> {
}
