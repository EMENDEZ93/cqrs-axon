package member.backend.application.command;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateLifecycle;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;
//import org.springframework.util.Assert;

import member.backend.application.command.model.MemberCommand;

@Aggregate
public class MemberCommandHandler {

	@AggregateIdentifier
	private String id;
	
	@CommandHandler
	public MemberCommandHandler(MemberCommand memberCommand) {
		//Assert.hasLength(memberCommand.getIdTeam());
		AggregateLifecycle.apply(new MemberEvent(memberCommand.getId(), memberCommand.getName(), memberCommand.getIdTeam()));

	}
	
	public MemberCommandHandler() {}

	@EventSourcingHandler
	public void on(MemberEvent event) {
		this.id = event.getId();
	}
	
}
