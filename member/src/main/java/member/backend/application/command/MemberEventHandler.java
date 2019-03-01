package member.backend.application.command;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import member.backend.domain.entity.MemberEntity;
import member.backend.domain.repository.MemberEntityJpaRepository;

@Service
public class MemberEventHandler {

	@Autowired
	private MemberEntityJpaRepository memberEntityJpaRepository;
	
	@EventHandler
	public void onSave(MemberEvent event) {
		//builder dentro del save????
		MemberEntity member = new MemberEntity();
		member.setId(event.getId());
		member.setName(event.getName());
		member.setIdTeam(event.getIdTeam());
		
		memberEntityJpaRepository.save(member);
	}

	
}
 