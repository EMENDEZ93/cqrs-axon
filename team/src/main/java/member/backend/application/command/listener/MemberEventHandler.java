package member.backend.application.command.listener;

import java.util.UUID;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import member.backend.application.command.MemberEvent;
import member.backend.domain.entity.TeamEntity;
import member.backend.domain.persistence.TeamEntityJpaRepository;

@ProcessingGroup("statistics")
@Service
public class MemberEventHandler {

	@Autowired
	private TeamEntityJpaRepository teamEntityJpaRepository;
	
	@EventHandler
	public void on(MemberEvent memberEvent) {
		System.out.println("**************** EventHandler 2 ****************");
		System.out.println(memberEvent);
		
		save(memberEvent);
	}

	private void save(MemberEvent memberEvent) {
		TeamEntity team = null;
		if(!teamEntityJpaRepository.existsByName(memberEvent.getIdTeam()) ) {
			team = new TeamEntity();
			team.setId(UUID.randomUUID().toString());
			team.setMembersNumer( team.getMembersNumer() + 1);
			team.setName( memberEvent.getIdTeam() );
			teamEntityJpaRepository.save(team);			
		} else {
			team = teamEntityJpaRepository.findByName( memberEvent.getIdTeam() );
			team.setMembersNumer( team.getMembersNumer() + 1);
			teamEntityJpaRepository.save(team);			
		}
	}	
	
}
