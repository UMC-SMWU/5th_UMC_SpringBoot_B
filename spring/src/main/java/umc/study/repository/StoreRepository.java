package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.store;

public interface StoreRepository extends JpaRepository<store, Long> {
}
