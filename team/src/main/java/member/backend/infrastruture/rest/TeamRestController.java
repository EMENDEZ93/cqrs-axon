package member.backend.infrastruture.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import member.backend.application.query.TeamQuery;
import member.backend.application.query.model.TeamQueryModel;

@RestController
public class TeamRestController {

    @Autowired
    private TeamQuery teamQuery;
	
	@GetMapping
	public List<TeamQueryModel> getAllTeam() {
		return teamQuery.getAllTeam();
	}
	
	
}
