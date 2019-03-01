package member.backend.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import member.backend.domain.entity.MemberEntity;

@Repository
public interface MemberEntityJpaRepository extends JpaRepository<MemberEntity, String>{

}
