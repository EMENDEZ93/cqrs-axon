package member.backend.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import member.backend.domain.entity.TeamEntity;

@Repository
public interface TeamEntityJpaRepository extends JpaRepository<TeamEntity, String> {

	public boolean existsByName(String name);	
	
	public TeamEntity findByName(String name);
	
}
