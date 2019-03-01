package member.backend.application.query;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import member.backend.application.query.model.TeamQueryModel;
import member.backend.domain.entity.TeamEntity;
import member.backend.domain.persistence.TeamEntityJpaRepository;

@Service
public class TeamQuery {

	@Autowired
	private TeamEntityJpaRepository teamEntityJpaRepository;
	
	
	public List<TeamQueryModel> getAllTeam(){
		return convertEntityToCommand();
	}


	private List<TeamQueryModel> convertEntityToCommand() {
		List<TeamQueryModel> temaCmmand = new ArrayList<>();
		
		teamEntityJpaRepository.findAll().forEach(teamEntity -> {
			temaCmmand.add(new TeamQueryModel(teamEntity.getName(), teamEntity.getMembersNumer()));
		} );
		return temaCmmand;
	}
	
}
