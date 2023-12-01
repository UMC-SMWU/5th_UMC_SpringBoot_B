package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.member;


public interface MemberRepository extends JpaRepository<member, Long> {
}
