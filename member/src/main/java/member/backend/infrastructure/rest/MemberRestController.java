package member.backend.infrastructure.rest;

import java.util.UUID;

import javax.validation.Valid;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import member.backend.application.command.model.MemberCommand;

@RequestMapping("cqrs")
@RestController
public class MemberRestController {

	@Autowired
	private CommandGateway commandGateway;

	@PostMapping()
	public void saveMember(@Valid @RequestBody MemberCommand member) {
        member.setId(UUID.randomUUID().toString());
		commandGateway.send(member);
	}

}
